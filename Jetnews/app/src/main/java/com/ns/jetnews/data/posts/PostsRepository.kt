package com.ns.jetnews.data.posts

import com.ns.jetnews.data.Result
import com.ns.jetnews.model.Post
import com.ns.jetnews.model.PostsFeed
import kotlinx.coroutines.flow.Flow

interface PostsRepository {
    suspend fun getPost(postId: String): Result<Post>
    suspend fun getPostsFeed(): Result<PostsFeed>
    fun observeFavorites(): Flow<Set<String>>
    fun observePostsFeed(): Flow<PostsFeed?>
    suspend fun toggleFavorite(postId: String)
}