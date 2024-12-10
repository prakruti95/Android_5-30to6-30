package tops1012

import java.util.Stack

//entry

class Mystack
{
    fun topspush(st:Stack<Int>,i:Int)
    {
        st.push(i)

        println(i)
        println(st)
    }

    //exit
    fun topspop(st:Stack<Int>)
    {
        var i:Int = st.pop()

        println(i)
        println(st)
    }
}




fun main()
{
    var st = Mystack()
    var st2 = Stack<Int>()

    st.topspush(st2,10)
    st.topspush(st2,20)
    st.topspush(st2,30)
    st.topspush(st2,40)

    println("----------------------")

    try
    {
        st.topspop(st2)
        st.topspop(st2)
        st.topspop(st2)
        st.topspop(st2)
        st.topspop(st2)
        st.topspop(st2)
        st.topspop(st2)
    }
    catch(e:Exception)
    {
        println("No data")
    }
    finally
    {
        println("Always Executed")
    }






}