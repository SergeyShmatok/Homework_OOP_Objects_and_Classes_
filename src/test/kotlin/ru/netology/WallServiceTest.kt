package ru.netology

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Test
import ru.netology.WallService.posts

class WallServiceTest {

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun add_Testing() {
        val post = Post()
        WallService.add(post)
        assertTrue(posts.last().id != 0)

    }

//----------------------------------------------------

    @Test
    fun update_Testing1() {
        val post1 = Post()
        val post2 =
            Post(id = 1, text = "New text") // - пост с изменённым значением text, но с уже имеющимся в массиве id
        WallService.add(post1)

        val result = WallService.update(post2)

        assertEquals(true, result)

    }


    @Test
    fun update_Testing2() {
        val post1 = Post()
        val post2 = Post(id = 2, text = "Qwewqeqwe") // - пост с несуществующим id
        WallService.add(post1)

        val result = WallService.update(post2)

        assertEquals(false, result)

    }
}