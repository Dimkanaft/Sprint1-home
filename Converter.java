public class Converter{

   StepTracker stepTracker;
   //StepTracker stepTracker = new StepTracker(); ???

    public double countKcal(){  //метод считает калории

       double kcal = stepTracker.countSumStepsMonth()/25;
        return kcal;
    }

    public double countDistanceTraveled(){ //метод считает шаги
        double distanceTraveled = stepTracker.countSumStepsMonth() * 0.00075;
        return distanceTraveled;
    }
}
