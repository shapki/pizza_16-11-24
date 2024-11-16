class PizzaPeter(
   neapolitanPizzaPrice: Double, romanPizzaPrice: Double,
    sicilianPizzaPrice: Double, tyroleanPizzaPrice: Double
) : PizzaCity(
    neapolitanPizzaPrice, romanPizzaPrice,
    sicilianPizzaPrice, tyroleanPizzaPrice
), Drink {
    private var serviceTemp = 0
    override fun drinkSale() {
        println("| Вы будете кофе?")
        println("  1. Да\n  2. Нет")
        when (readln()) {
            "1" -> {
                totalPeople++
                serviceCount++
                serviceSum+=200
                serviceTemp=1

                println("С вас 200 рублей")
            }
            "2" -> {
                totalPeople++
                serviceDeny++
                serviceTemp=2
            }
        }
    }

    override fun neapolitanPizzaSale() {
        neapolitanPizzaCount++
        if (serviceTemp == 1) neapolitanService++
        serviceTemp = 0
        println("Спасибо за покупку неаполитанской пиццы в Санкт-Петербурге")
    }

    override fun romanPizzaSale() {
        romanPizzaCount++
        if (serviceTemp == 1) romanService++
        serviceTemp = 0
        println("Спасибо за покупку римской пиццы в Санкт-Петербурге")
    }

    override fun sicilianPizzaSale() {
        sicilianPizzaCount++
        if (serviceTemp == 1) sicilianService++
        serviceTemp = 0
        println("Спасибо за покупку сицилийской пиццы в Санкт-Петербурге")
    }

    override fun tyroleanPizzaSale() {
        tyroleanPizzaCount++
        if (serviceTemp == 1) tyroleanService++
        serviceTemp = 0
        println("Спасибо за покупку тирольской пиццы в Санкт-Петербурге")
    }
}