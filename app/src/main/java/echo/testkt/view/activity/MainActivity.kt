package echo.testkt.view.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import echo.testkt.R
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {
    
    val mStudent: Student by lazy { Student("Hurry", 1) }
    lateinit var  mAnotherStudent: Student 
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toast("hello world!", false)
        tvHello.text = "hello Kotlin"
        
        Customer("1", "2", "3").toString()
        
        var testSdtArray = ArrayList<Student>()
        testSdtArray.add(Student("1", 1))
        testSdtArray.add(Student("2", 2))
        testSdtArray.add(Student("3", 3))
        testSdtArray.add(Student("4", 4))
        testSdtArray.add(mStudent)

        mAnotherStudent = Student("Y", 10)
        testSdtArray.add(mAnotherStudent)
        
        toast(testSdtArray.filter { s -> s.age!! > 2 }.toString())
        
        var testArray = listOf("a1","a2","b3")
        testArray.filter { it.startsWith("a") }
                .sortedBy { it }
                .map { it.toUpperCase() }
                .forEach { println(it) }
        
        for (i in testArray.indices){
            println("index[$i] is ${testArray[i]}")

            when (i) {
                1 -> {}
                else -> {}
            } 
            
            if(i !in 1..3){ }
        }

        for (x in 0 .. 10){ }
        for (x in 0 until 1000 step 2){}
        for (x in 1000 downTo 0 step 3){}
        
        val map = mapOf("1" to "a", "2" to "b")

        val files = File("Test").listFiles()
        println(files?.size ?: "empty")
        
        //代码会执行到此处, 假如files不为null
        files?.let{
            
        }

        ThisIsASingleton.sayHello("Echo")
        
        with(ThisIsASingleton){
            sayHello("Love")
        }

        ThisIsASingleton.apply { name = "haha" }
        
        
//        var output: String
//        output = null   // 编译错误

        val name: String? = null    // 可控类型
        val other: String? = "hello"    // 可控类型
        println("name: ${name?.length}")      // 会怎么打印？ name: null
        //println("name: ${name!!.length}")      // 会怎么打印？ 会抛出nullpointexcption
        println("other: ${other!!.length}")      // 编译错误   
        
    }

    override fun onDestroy() {
        super.onDestroy()
        toast("ondestroy")
    }
    
    fun add(a: Int, b: Int): Int{
        return a + b;
    }

    fun reduce(a: Int, b: Int) = a - b
    

    fun toast(str: String?, isShort: Boolean = true){
        Toast.makeText(this@MainActivity, str, if(isShort)Toast.LENGTH_SHORT else Toast.LENGTH_LONG).show()
    }
}

/**
 * 定义POJO
 */
data class Customer(val name: String, val email: String, val company: String)

data class Student(val name: String? = null, val age: Int? = 18)

object ThisIsASingleton{
    
    var name: String? = "hello"
    
    fun sayHello(name: String?){
        ThisIsASingleton.name = name
        println("hello $name")
    }

    fun testTodo(): Nothing = TODO("todo fun")
    
}