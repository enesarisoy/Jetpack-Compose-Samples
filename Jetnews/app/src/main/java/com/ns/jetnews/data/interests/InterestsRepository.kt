package com.ns.jetnews.data.interests

import com.ns.jetnews.data.Result
import kotlinx.coroutines.flow.Flow

data class InterestSection(val title: String, val interest: List<String>)

interface InterestsRepository {
    suspend fun getTopics(): Result<List<InterestSection>>
    suspend fun getPeople(): Result<List<String>>
    suspend fun getPublications(): Result<List<String>>
    suspend fun toggleTopicSelection(topic: TopicSelection)
    suspend fun togglePersonSelected(person: String)
    suspend fun togglePublicationSelected(publication: String)
    fun observeTopicsSelected(): Flow<Set<TopicSelection>>
    fun observePeopleSelected(): Flow<Set<String>>
    fun observePublicationSelected(): Flow<Set<String>>
}

data class TopicSelection(val section: String, val topic: String)