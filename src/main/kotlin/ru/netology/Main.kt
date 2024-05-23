package ru.netology


import java.time.LocalDateTime


data class Post(
    val id: Int = 0,
    val likes: Likes = Likes(),
    val text: String = "text",
    val date: LocalDateTime = LocalDateTime.now(),
    val comments: Comments = Comments(),
    val ownerId: Int = 5,
    val fromId: Int = 5,
    val canPin: Boolean = true,
    val canDelete: Boolean = true,
    val canEdit: Boolean = true,
)

class Likes(
    count: Int = 0,
    userLikes: Boolean = true,
    scanLike: Boolean = true,
    canPublish: Boolean = true
) {

    var count: Int = count
        set(value) {
            if (value >= 0) {
                field = value
            }
        }
}


class Comments(
    count: Int = 0,
    canPost: Boolean = true,
    groupsCanPost: Boolean = true,
    canClose: Boolean = true,
    canOpen: Boolean = true
)


object WallService {

    var posts = emptyArray<Post>() // массив оставляем неприватным, чтобы иметь к нему доступ ниже

    private var nextUniqueId: Int = 0

    fun add(post: Post): Post {
        val nextPost = post.copy(id = post.id + nextUniqueId + 1)
        posts += nextPost
        nextUniqueId++
        return nextPost
    }

    fun update(post: Post): Boolean {
        for ((index, postFromArray) in posts.withIndex())
            if (post.id == postFromArray.id) {
                posts[index] = post
                return true
            }
        return false
    }

    fun clear() {
        posts = emptyArray<Post>() // - очистка массива
        nextUniqueId = 0
    }

}


fun main() {

    val post1 = Post()
    val post2 = Post()
    val post3 = Post()

    WallService.add(post1)
    WallService.add(post2)

    val addingPost3 = WallService.add(post3)

    println(addingPost3) // - номер id изменился в зависимости от количества постов и теперь равен 3-м

    println()

    val post4 = Post(id = 3, text = "New text") // - пост с изменённым значением text, но с уже имеющимся в массиве id

    val post5 = Post(id = 4, text = "Qwewqeqwe") // - пост с несуществующим id

    println(WallService.update(post4)) // пост с id = 3 обновился

    println()

    WallService.posts.forEach { println(it) } // печать всех элементов массива

    println()

    println(WallService.update(post5)) // изменений не произошло

    println()

    WallService.posts.forEach { println(it) }

    WallService.clear()

    println()

    println(WallService.posts.size) // clear работает: массив обнулился


}