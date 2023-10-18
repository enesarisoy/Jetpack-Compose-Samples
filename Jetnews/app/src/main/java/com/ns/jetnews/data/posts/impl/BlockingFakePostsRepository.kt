package com.ns.jetnews.data.posts.impl

import com.ns.jetnews.data.Result
import com.ns.jetnews.data.posts.PostsRepository
import com.ns.jetnews.data.posts.utils.addOrRemove
import com.ns.jetnews.model.Post
import com.ns.jetnews.model.PostsFeed
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.withContext
import java.lang.IllegalArgumentException

class BlockingFakePostsRepository : PostsRepository {

    private val favorites = MutableStateFlow<Set<String>>(setOf())
    private val postsFeed = MutableStateFlow<PostsFeed?>(null)

    override suspend fun getPost(postId: String): Result<Post> {
        return withContext(Dispatchers.IO){
            val post = posts.allPosts.find { it.id == postId }
            if (post == null) {
                Result.Error(IllegalArgumentException("Unable to find post"))
            } else {
                Result.Success(post)
            }
        }
    }

    override suspend fun getPostsFeed(): Result<PostsFeed> {
        postsFeed.update { posts }
        return Result.Success(posts)
    }

    override fun observeFavorites(): Flow<Set<String>> = favorites
    override fun observePostsFeed(): Flow<PostsFeed?> = postsFeed

    override suspend fun toggleFavorite(postId: String) {
        favorites.update { it.addOrRemove(postId) }
    }
}