package com.may.myandroidsamples.fcm

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


import android.util.Log

/**
 * Using FirebaseMessagingService
 *
 * 1. AndroidStudio > Tools > Firebase > Cloud messaging 선택
 * 2. AndroidStudio 오른쪽 window 에 설정가이드가 나옴. 따라서 하면됨
 * - FirebaseMessagingService 를 상속받아서, onMessageReceived 구현
 * - 해당 서비스를 Manifest 에 추가
 * - 해당서비스에 onNewToken 구현 (token refresh 시 호출됨 -fcm 에는 토큰이 자동등록되지만, 테스트 푸시 보내야하거나 서버에 토큰 등록해야하니 필요)
 *
 * ==> google service 가 gradle 에 등록되는등 fcm 에 필요한 설정이 자동으로 project 에 추가되고,
 *      firebase console 에 앱이 자동 등록됨.
 *
 *      !! 가끔 에뮬에서 토큰등록 실패 날 경우 있는데, AVD 에뮬 cold reboot 하면 해결됨.
 *
 * Test
 * 1. Firebase Console 에서 app 에 대한 auth key 를 찾아둠
 * 2. 위의 키를 이용하여 postman 에서 테스트 푸시를 전송함.
 *
 *
 * Android P 이상에서 이슈
 * 설정에서 앱을 background restriction 하면 OS 에서 푸시 노티 생성하지 않음.
 * - https://firebase.google.com/docs/cloud-messaging/android/receive
 */

/*
FCM message sample
- FCM URL :  https://fcm.googleapis.com/fcm/send
- Header

content-type:application/json
Authorization:key=여기에 서버키값 (FCM console > cloud messaging > server key)


- Body 1 (일반적인 케이스. 백그라운드 일때 알아서 nofi 생성해줌. 단, 포그라운드일때는 onMessageReceived 불리지 않음
{
"to":"토큰값!!!",
"notification":{
"title":"FCM message title",
"body":"Message from fcm push Json's notification!"
},
"data" : {
"Nick" : "Mario",
"Room" : "PortugalVSDenmark"
}
}


- Body 2 (백그라운드 일때 onMessageReceived 를 받아야할때. notification 을 제거!, priority 를 high 로 설정)
{
    "to": "dzSaWUSZEeU:APA91bG53kQVvoQaZVtV0hI2cs3PKZbcg-zbINMZeOGGiSTp6lL7uwlMSvQ_C5NHfFJVuc7h6Z2j5z_fuTF9Wred3KXxxvlNaEBVU4_NI-lyLwsulWADF1qHMCQd4A2XKb9JWoAFvIII",
    "data": {
        "Nick": "Mario",
        "Room": "PortugalVSDenmark",
        "priority": "high"
    }
}
 */


class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        // ...

        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.d("MySample", "From remoteMessage: " + remoteMessage!!.from!!)

        // Check if message contains a data payload.
        if (remoteMessage.data.size > 0) {
            Log.d("MySample", "Message data payload: " + remoteMessage.data)

            if (/* Check if data needs to be processed by long running job */ true) {
                // For long-running tasks (10 seconds or more) use Firebase Job Dispatcher.
                //scheduleJob()
            } else {
                // Handle message within 10 seconds
                handleNow()
            }

        }

        // Check if message contains a notification payload.
        if (remoteMessage.notification != null) {
            Log.d("MySample", "Message Notification Body: " + remoteMessage.notification!!.body!!)
        }

        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
    }


    /**
     * Called if InstanceID token is updated. This may occur if the security of
     * the previous token had been compromised. Note that this is called when the InstanceID token
     * is initially generated so this is where you would retrieve the token.
     */
    override fun onNewToken(token: String?) {
        Log.d("MySample", "Refreshed token: " + token!!)

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        sendRegistrationToServer(token)
    }

    fun handleNow(){
        Log.d("MySample","handleNow!!!")
    }

    fun sendRegistrationToServer(token: String?){
        Log.d("MySample","sendRegistrationToServer!!!")
    }
}