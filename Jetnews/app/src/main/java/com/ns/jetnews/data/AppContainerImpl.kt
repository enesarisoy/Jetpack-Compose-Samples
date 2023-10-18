package com.ns.jetnews.data

import android.content.Context
import com.ns.jetnews.data.interests.InterestsRepository
import com.ns.jetnews.data.interests.impl.FakeInterestsRepository
import com.ns.jetnews.data.posts.PostsRepository
import com.ns.jetnews.data.posts.impl.FakePostsRepository

interface AppContainer {
    val postsRepository: PostsRepository
    val interestsRepository: InterestsRepository
}

class AppContainerImpl(private val applicationContext: Context) : AppContainer {

    override val postsRepository: PostsRepository by lazy {
        FakePostsRepository()
    }

    override val interestsRepository: InterestsRepository by lazy {
        FakeInterestsRepository()
    }
}