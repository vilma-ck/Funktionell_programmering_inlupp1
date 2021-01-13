
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/*
Inlämningsuppgit i kursen Funktionell Programmering för JAVA-programmet
För samtliga funktioner i denna fil, byt ut "throw UnSupportedException"-raden
och skriv ett pipeline-uttryck som returnerar det som ska returneras.
Streams MÅSTE användas i samtliga funktioner som lämnas in
För att testa om era funktioner funkar, kör testerna som hör till denna fil
För att bli godkänd på denna uppgift måste minst 7 av funktionerna vara implementerade.
Sigruns bedömning av denna uppgift kommer att gå till så att hon klipper in er version av denna fil
i sitt projekt och kör testerna.
Hennes kontroll om ni har klarat uppgifterna eller inte görs genom att
hon kollar att tillräckeligt många av tester går gröna. Pga detta ska ni inte ändra i någon fil
medföljande detta projekt, och inte heller metodsignaturerna i denna fil eller era tester, eftersom
ni då riskerar att påverka rättningen i negativ riktning.
 */

public class RewriteMe {

    public Database database = new Database();
    public List<Question> questions = database.getQuestions();

    //Skriv en funktion som returnerar hur många frågor det finns i databasen?
    public int getAmountOfQuestionsInDatabase(){
        return Math.toIntExact(questions.stream().count());
    }

    //Hur många frågor finns i databasen för en viss, given kategori (som ges som inparameter)
    public int getAmountOfQuestionsForACertainCategory(Category category){
        return Math.toIntExact(questions.stream().filter(s -> s.getCategory().equals(category)).count());
    }

    //Skapa en lista innehållandes samtliga frågesträngar i databasen
    public List<String> getListOfAllQuestions(){
        return questions.stream().map(Question::getQuestionString).collect(Collectors.toList());
    }

    //Skapa en lista innehållandes samtliga frågesträngar där frågan tillhör en viss kategori
    //Kategorin ges som inparameter
    public List<String> getAllQuestionStringsBelongingACategory(Category category){
        return questions.stream().filter(s -> s.getCategory().equals(category)).map(Question::getQuestionString).collect(Collectors.toList());
    }

    //Skapa en lista av alla svarsalternativ, där varje svarsalternativ får förekomma
    // en och endast en gång i den lista som du ska returnera
    public List<String> getAllAnswerOptionsDistinct(){
        // här måste jag på nåt sätt bryta ut listan med alla svar, det gjordes med flatMap
        return questions.stream().map(Question::getAllAnswers).flatMap(v -> v.stream()).distinct().collect(Collectors.toList());
    }


    //Finns en viss sträng, given som inparameter, som svarsalternativ till någon fråga i vår databas?
    public boolean isThisAnAnswerOption(String answerCandidate){
        List<String> allAnswerOptions = getAllAnswerOptionsDistinct();
        return allAnswerOptions.stream().anyMatch(s -> s.equalsIgnoreCase(answerCandidate));
    }

    //Hur ofta förekommer ett visst svarsalternativ, givet som inparameter, i databasen
    public int getAnswerCandidateFrequncy(String answerCandidate){
        // lista med svar, ej distinct
        List<String> allAnswersToken = questions.stream().map(Question::getAllAnswers).flatMap(a -> a.stream()).collect(Collectors.toList());
        return Math.toIntExact(allAnswersToken.stream().filter(s -> s.equalsIgnoreCase(answerCandidate)).count());
     }

    //Skapa en Map där kategorierna är nycklar och värdena är en lista
    //av de frågesträngar som tillhör varje kategori
    public Map<Category, List<String>> getQuestionGroupedByCategory(){

        throw new UnsupportedOperationException("Not supported yet.");

        //Map<Category, List<Question>> questionsByCategory = questions.stream().collect(groupingBy(q -> q.getCategory()));

        //Map<Category, List<String>> questionsByCategory2 = questions.stream().collect(groupingBy((q) -> q.getCategory(), Question::getQuestionString));

        //Map<Category, List<String>> newMap = questionsByCategory.replaceAll( (k,v) -> v = v.stream().map(Question::getQuestionString).collect(Collectors.toList()));

        //return newMap;

    }

    public void test(){

        Map<Category, List<Question>> questionsByCategory = questions.stream().collect(groupingBy(q -> q.getCategory()));

        questionsByCategory.forEach((v,k) -> System.out.println(v + " " + k));

        //Map<Category, List<String>> newMap = questionsByCategory.replaceAll( (k,v) -> v = v.stream().map(Question::getQuestionString).collect(Collectors.toList()));

    }

    //Skapa en funktion som hittar det svarsalternativ som har flest bokstäver, i en kategori, given som inparameter
    // OBS: Du måste använda Reduce!
    public String getLongestLettercountAnwerInAGivenCategory(Category c)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    public static void main(String[] args){
        RewriteMe uppg4 = new RewriteMe();
        uppg4.test();

    }

}