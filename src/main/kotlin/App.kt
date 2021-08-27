import dao.Dao
import dao.StudentDao
import model.Student
import kotlin.system.exitProcess

class App {
    private val dao: Dao<Student, String> = StudentDao()

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            App().startApp()
        }
    }

    fun startApp() {
        navigateToMainMenu()
    }

    private fun printHeader() {
        println(
            """
        ===============================================
        Aplikasi Data Mahasiswa
        ===============================================
        1. Cetak Semua data Mahasiswa
        2. Tambah Data Mahasiswa
        3. Hapus Data Mahasiswa
        4. Keluar
        ===============================================
        Masukkan Pilihan Anda (1,2,3,4) ?
        ===============================================
        """.trimIndent()
        )
    }

    private fun navigateToMenu(menu: String) {
        when (menu) {
            "1" -> {
                // TODO: 25/08/2021 open menu print data student
                openMenuPrintStudent()
            }

            "2" -> {
                // TODO: 25/08/2021 add data student
                openMenuInsertStudent()
            }

            "3" -> {
                // TODO: 25/08/2021 delete data student
                openMenuDeleteStudent()
            }

            "4" -> {
                exitProcess(0)
            }
            else -> {
                println("Pilihan Tidak Ada")
            }
        }
        askToMainMenu()
    }

    private fun openMenuDeleteStudent() {
        println("===============================================")
        println("Hapus data dengan NIM = ")
        readLine()?.let {
            dao.deleteData(it)
        }
        println("===============================================")
        println("Hapus Data Berhasil")
    }

    private fun openMenuInsertStudent() {
        println("===============================================")
        println("Nama Mahasiswa = ")
        val name = readLine().orEmpty()
        println("NIM Mahasiswa = ")
        val nim = readLine().orEmpty()
        println("Jurusan Mahasiswa = ")
        val major = readLine().orEmpty()
        println("Kelas = ")
        val className = readLine().orEmpty()
        println("Nama Universitas = ")
        val univ = readLine().orEmpty()
        dao.addData(Student(name, nim, major, className, univ))
        println("===============================================")
        println("Insert Data Berhasil")
    }

    private fun openMenuPrintStudent() {
        val students = dao.getData()
        if (students.isNotEmpty()) {
            students.forEachIndexed { index, student ->
                println("===============================================")
                println("Mahasiswa ke-${index + 1}")
                println("===============================================")
                println("Nama       : ${student.name}")
                println("NIM        : ${student.nim}")
                println("Jurusan    : ${student.major}")
                println("Kelas      : ${student.className}")
                println("University : ${student.university}")
            }
/*            for (student in students) {
                println("===============================================")
                println("Mahasiswa ke-$number")
                println("===============================================")
                println("Nama       : ${student.name}")
                println("NIM        : ${student.nim}")
                println("Jurusan    : ${student.major}")
                println("Kelas      : ${student.className}")
                println("University : ${student.university}")
                number++
            }*/
        } else {
            println("===============================================")
            println("Tidak Ada Data!")
            println("===============================================")
        }
    }

    private fun askToMainMenu() {
        println(
            """
        ===============================================
        Kembali ke menu utama ? (Y/N)
        ===============================================
        """.trimIndent()
        )
        if (readLine().equals("Y", ignoreCase = true)) {
            navigateToMainMenu()
        } else {
            exitProcess(0)
        }
    }

    private fun navigateToMainMenu() {
        printHeader()
        readLine()?.let {
            navigateToMenu(it)
        }
    }
}