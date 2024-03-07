package com.example.domain.mapperInterface

interface Mapper<I,O> {
    fun map(input:I):O
}