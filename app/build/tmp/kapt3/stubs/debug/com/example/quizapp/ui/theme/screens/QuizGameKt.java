package com.example.quizapp.ui.theme.screens;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001aA\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052!\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00010\bH\u0007\u001a;\u0010\r\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2!\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00010\bH\u0002\u00a8\u0006\u0010"}, d2 = {"QuizGame", "", "context", "Landroid/content/Context;", "questions", "", "Lcom/example/quizapp/data/Question;", "onQuizEnd", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "score", "saveScoreAndEndQuiz", "leaderboardDao", "Lcom/example/quizapp/data/LeaderboardDao;", "app_debug"})
public final class QuizGameKt {
    
    @androidx.compose.runtime.Composable
    public static final void QuizGame(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.util.List<com.example.quizapp.data.Question> questions, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onQuizEnd) {
    }
    
    private static final void saveScoreAndEndQuiz(int score, com.example.quizapp.data.LeaderboardDao leaderboardDao, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onQuizEnd) {
    }
}