package edu.udelp.music.data.remote.dto

data class HomeContentDto(
    val sections: List<SectionDto>
)

data class SectionDto(
    val title: String,
    val items: List<ItemDto>
)

data class ItemDto(
    val id: String,
    val title: String,
    val subtitle: String,
    val imageUrl: String,
    val type: String
)
