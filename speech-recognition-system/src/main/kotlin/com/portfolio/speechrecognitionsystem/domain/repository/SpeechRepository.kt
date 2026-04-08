package com.portfolio.speechrecognitionsystem.domain.repository

import com.portfolio.speechrecognitionsystem.domain.model.Transcription

interface SpeechRepository {
    suspend fun save(transcription: Transcription): Transcription
    suspend fun findAll(): List<Transcription>
}
