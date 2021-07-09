package bank

data class Banco(val nome:String, val numero:Int){
    fun inf()="$nome - $numero"
}
