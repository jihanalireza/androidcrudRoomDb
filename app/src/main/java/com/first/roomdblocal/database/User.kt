package com.first.roomdblocal.database

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class User {
    @PrimaryKey(autoGenerate = true) var uid: Int=0
    @ColumnInfo(name = "first_name") var firstName: String? =null
    @ColumnInfo(name = "last_name") var lastName: String? =null
}
