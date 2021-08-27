package dao

import model.Student

class StudentDao : Dao<Student, String> {
    // mocking how databases works, using list of object in kotlin
    private var students = arrayListOf<Student>().apply {
        add(Student("Tony bin Stark", "12345", "Teknik Informatika", "4IA01", "Universitas Gunadarma"))
        add(Student("Black Widdow", "12346", "Ekonomi", "4IA02", "Universitas Indonesia"))
        add(Student("Hawkeye bin Robin", "12347", "Teknik Elektro", "4IA03", "Universitas Pancasila"))
        add(Student("Bruce bin Banner", "12348", "Teknik Komputer", "4IA04", "BSI"))
        add(Student("Vision bin Tony Stark", "12349", "Sastra Inggris", "4IA05", "IPB"))
    }

    override fun getData(): List<Student> {
        return students
    }

    override fun addData(item: Student) {
        students.add(item)
    }

    override fun deleteData(uniqueID: String) {
        /*
        OLD IMPLEMENTATION

        for(student in students){
            if(student.nim == uniqueID){
                students.remove(student)
            }
        }
        */
        students.remove(students.find { student ->
            student.nim == uniqueID
        })
    }
}