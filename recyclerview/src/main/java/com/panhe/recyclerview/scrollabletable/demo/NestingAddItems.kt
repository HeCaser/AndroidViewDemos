package com.panhe.recyclerview.scrollabletable.demo



/**
 * @author: hepan
 * @date: 2022/6/14
 * @desc:
 */
data class NestingAddItems(

    val list: List<NestingAddStockInfo>?,

    val subtitle1: String?,
    val title: String?
)

data class NestingAddStockInfo(

    val current: Double?,

    val customPercent: Double?,

    val customTag: String?,

    val name: String?,

    val percent: Double?,

    val symbol: String?,

    val tag: String?
)