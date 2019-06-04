package com.may.myandroidsamples.retrofit

object WikiResponse {
    data class Result(val query: Query)
    data class Query(val searchinfo: SearchInfo)
    data class SearchInfo(val totalhits: Int)
}

// JSON
//query: {
//    searchinfo: {
//            totalhits: 16776
//    },