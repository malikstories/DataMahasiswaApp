package dao

interface Dao<T, UID> { // val dao : Dao<Student,String> = StudentDao()
    fun getData(): List<T> // mengambil semua data dari database
    fun addData(item: T) // memasukkan data ke database
    fun deleteData(uniqueID: UID)
}