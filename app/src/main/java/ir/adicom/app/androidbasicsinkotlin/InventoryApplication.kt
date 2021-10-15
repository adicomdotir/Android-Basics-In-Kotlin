package ir.adicom.app.androidbasicsinkotlin

import android.app.Application
import ir.adicom.app.androidbasicsinkotlin.data.ItemRoomDatabase

class InventoryApplication : Application() {
    val database: ItemRoomDatabase by lazy {
        ItemRoomDatabase.getDatabase(this)
    }
}
