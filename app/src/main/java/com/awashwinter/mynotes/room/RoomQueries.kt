package com.awashwinter.mynotes.room

class RoomQueries {
    companion object{
        const val SELECT_ALL_NOTES = "SELECT * FROM notes ORDER BY modified_at ASC"
    }
}