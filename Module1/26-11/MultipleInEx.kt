package tops26

open class P
{

}
open interface Q :
{

}
open interface R : Q()
{

}


class MultipleInEx : P(),Q,R
{

}