package tops212

fun main()
{
        try
        {

            var data = 10/0
            println(data)
        }
        catch(e:Exception)
        {
            println(e)
        }


        println("success")

}