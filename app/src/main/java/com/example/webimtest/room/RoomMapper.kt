package com.example.webimtest.room

import com.example.webimtest.entities.Note
import com.example.webimtest.entities.NoteDB
import com.example.webimtest.utils.EntityMapper
import javax.inject.Inject

class RoomMapper @Inject constructor(): EntityMapper<NoteDB, Note> {
    override fun mapFromEntity(entity: NoteDB): Note {
        return Note(
            id = entity.id,
            title = entity.title,
            description = entity.description
//            date = entity.date
        )
    }

    override fun mapToEntity(domainModel: Note): NoteDB {
        return NoteDB(
//            id = domainModel.id,
            title = domainModel.title,
            description = domainModel.description
//            date = domainModel.date
        )
    }

    fun mapFromEntitiesList(entities : List<NoteDB>?) : List<Note>?{
        return entities?.map { mapFromEntity(it) }
    }
}