package ru.netology

// Тут находится абстрактный класс,
// классы-вложения, и контент для них.

abstract class Attachment {

    abstract val type: String
}


// ______Классы - вложения______

class PhotoAttachment(
    override val type: String = "photo",
    val photo: Photo
) : Attachment() {

}

class VideoAttachment(
    override val type: String = "video",
    val video: Video
) : Attachment() {

}


class AudioAttachment(
    override val type: String = "audio",
    val video: Audio
) : Attachment() {

}

class FileAttachment(
    override val type: String = "file",
    val video: File
) : Attachment() {

}

class LinkAttachment(
    override val type: String = "link",
    val video: Link
) : Attachment() {

}

// ________Контент________

class Photo(
    val id: Int,
    val albumId: Int,
    val ownerId: Int,
    val userId: Int,
    val text: String = "Описание фотографии"
) {

}

class Video(
    val id: Int,
    val ownerId: Int,
    val title: String = "Название видеозаписи",
    val description: String = "Текст описания видеозаписи",
    val duration: Int,
) {


}

class Audio(
    val id: Int,
    val ownerId: Int,
    val title: String = "Название композиции",
    val artist: String = "Исполнитель",
    val duration: Int,
) {

}


class File(
    val id: Int,
    val ownerId: Int,
    val title: String = "Название файла",
    val size: Int,
    val ext: String = "Расширение файла",
) {

}

class Link(

    val url: String = "URL ссылки",
    val title: String = "Заголовок ссылки",
    val caption: String = "Подпись ссылки",
    val description: String = "Описание ссылки",
    val previewUrl: String = "URL страницы с контентом для предпросмотра",
) {

}
