abstract class PizzaCity(
    val neapolitanPizzaPrice: Double, val romanPizzaPrice: Double,
    val sicilianPizzaPrice: Double, val tyroleanPizzaPrice:Double
) {
    var neapolitanPizzaCount = 0
    var romanPizzaCount = 0
    var sicilianPizzaCount = 0
    var tyroleanPizzaCount = 0

    var totalPeople = 0
    var serviceCount = 0
    var serviceSum = 0
    var serviceDeny = 0
    var serviceSauseT = 0
    var serviceSauseC = 0

    var neapolitanService = 0
    var romanService = 0
    var sicilianService = 0
    var tyroleanService = 0

    abstract fun neapolitanPizzaSale()
    abstract fun romanPizzaSale()
    abstract fun sicilianPizzaSale()
    abstract fun tyroleanPizzaSale()

    fun showStatistics() {
        println("  Продано сицилийской пиццы: $sicilianPizzaCount")
        println("  Продано неаполитанской пиццы: $neapolitanPizzaCount")
        println("  Продано римской пиццы: $romanPizzaCount")
        println("  Продано тирольской пиццы: $tyroleanPizzaCount")

        val servicePerc = if (totalPeople == 0) 0.0 else (serviceCount.toDouble() / totalPeople) * 100
        val serviceDenyPerc = if (totalPeople == 0) 0.0 else (serviceDeny.toDouble() / totalPeople) * 100
        println("  Оказано доп услуг: $serviceCount ($servicePerc% - оказано, $serviceDenyPerc% - отказались)")

        val maxService = maxOf(neapolitanService, romanService, sicilianService, tyroleanService)
        val totalServices = neapolitanService + romanService + sicilianService + tyroleanService
        val maxServicePerc = if (totalServices == 0) 0.0 else (maxService.toDouble() / totalServices) * 100
        val maxServiceStat = when (maxService) {
            neapolitanService -> "к неаполитанской пицце ($neapolitanService)" + String.format("%.1f", maxServicePerc) + "%"
            romanService -> "к римской пицце ($romanService)" + String.format("%.1f", maxServicePerc) + "%"
            sicilianService -> "к сицилийской пицце ($sicilianService)" + String.format("%.1f", maxServicePerc) + "%"
            tyroleanService -> "к тирольской пицце ($tyroleanService)" + String.format("%.1f", maxServicePerc) + "%"
            0 -> "ни к одной пицце"
            else -> "ни к одной пицце"
        }
        println("  Чаще всего доп услугу берут $maxServiceStat")

        if (serviceSauseT != 0 || serviceSauseC != 0) {
            println("  Продано соусов: томатных($serviceSauseT), сырных($serviceSauseC). Выручка: ${(serviceSauseT + serviceSauseC) * 15}")
        }

        val money = neapolitanPizzaCount * neapolitanPizzaPrice + romanPizzaCount * romanPizzaPrice +
                sicilianPizzaCount * sicilianPizzaPrice + tyroleanPizzaCount * tyroleanPizzaPrice +
                serviceCount * serviceSum + serviceSauseT * serviceSum + serviceSauseC * serviceSum

        println("| Всего заработано денег: $money\n")
    }
}