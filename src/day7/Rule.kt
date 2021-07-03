package day7

class Rule(
        val color:  String,
        val colors: List<ContainerRule>
){

}



class ContainerRule(
        val quantity:Int,
        val color:String
)