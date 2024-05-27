package ru.netology

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import ru.netology.WallService.posts

class WallServiceTest {

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }


    @Test
    fun add_testing() { // проверка без null
        val post = Post(0)
        WallService.add(post)
        assertTrue(posts.last().id != 0)

    }

    @Test
    fun add_testing_with_null() { // проверка с null
        val post = Post(null)
        WallService.add(post)
        assertTrue(posts.last().id != 0)

    }

//----------------------------------------------------

    @Test
    fun update_testing_1() {
        val post1 = Post(null)
        val post2 =
            Post(id = 1, text = "New text") // - пост с изменённым значением text, но с уже имеющимся в массиве id
        WallService.add(post1)

        val result = WallService.update(post2)

        assertEquals(true, result)

    }


    @Test
    fun update_testing_2() {
        val post1 = Post(null)
        val post2 = Post(id = 2, text = "Qwewqeqwe") // - пост с несуществующим id
        WallService.add(post1)

        val result = WallService.update(post2)

        assertEquals(false, result)

    }

    // добавлены сеттеры для count у Likes

    @Test
    fun setCount_more_than_0() {

        val likes1 = Likes()

        likes1.count = 1

        Assert.assertEquals(1, likes1.count)

    }


    @Test
    fun setCount_less_than_0() {

        val likes1 = Likes()
        likes1.count = -1

        Assert.assertEquals(0, likes1.count)


    }
}