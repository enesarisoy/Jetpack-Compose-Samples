package com.ns.jetnews.model

data class PostsFeed(
    val highlightedPost: Post,
    val recommendedPosts: List<Post>,
    val popularPosts: List<Post>,
    val recentPosts: List<Post>,
){

    val allPosts: List<Post> =
        listOf(highlightedPost) + recommendedPosts + popularPosts + recentPosts
}