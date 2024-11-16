class PizzaMoscow(
    neapolitanPizzaPrice: Double, romanPizzaPrice: Double,
    sicilianPizzaPrice: Double, tyroleanPizzaPrice: Double
) : PizzaCity(
    neapolitanPizzaPrice, romanPizzaPrice,
    sicilianPizzaPrice, tyroleanPizzaPrice
), CheckPhoto {
    private var serviceTemp = 0
    override fun showCheckPhoto() {
        println("| У вас есть фотография чека?")
        println("  1. Да\n  2. Нет")
        when (readln()) {
            "1" -> {
                totalPeople++
                serviceCount++
                serviceSum-=50
                serviceTemp=1
                println("Вам будет скидка 50 рублей с покупки")
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
        println("Спасибо за покупку неаполитанской пиццы в Москве")
    }

    override fun romanPizzaSale() {
        romanPizzaCount++
        if (serviceTemp == 1) romanService++
        serviceTemp = 0
        println("Спасибо за покупку римской пиццы в Москве")
    }

    override fun sicilianPizzaSale() {
        sicilianPizzaCount++
        if (serviceTemp == 1) sicilianService++
        serviceTemp = 0
        println("Спасибо за покупку сицилийской пиццы в Москве")
    }

    override fun tyroleanPizzaSale() {
        tyroleanPizzaCount++
        if (serviceTemp == 1) tyroleanService++
        serviceTemp = 0
        println("Спасибо за покупку тирольской пиццы в Москве")
    }
}