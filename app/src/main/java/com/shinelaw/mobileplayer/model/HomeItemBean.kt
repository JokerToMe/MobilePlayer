package com.shinelaw.mobileplayer.model

/**
 * @Package:        com.shinelaw.mobileplayer.model
 * @ClassName:      HomeItemBean
 * @Description:     java类作用描述
 * @Author:         ShineLaw
 * @CreateDate:     2019/5/15 14:42
 */
data class HomeItemBean(
    var id: Int,
    var videoId: Int,
    var artists: List<ArtistBean>,
    var title: String,
    var image: String,
    var rank: Int,
    var partner: Boolean
)