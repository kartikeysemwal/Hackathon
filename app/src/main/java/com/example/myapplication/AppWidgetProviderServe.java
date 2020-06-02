package com.example.myapplication;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;

public class AppWidgetProviderServe extends AppWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            Intent intentEducation = new Intent(context, EducationUser.class);
            PendingIntent pendingIntentEducation = PendingIntent.getActivity(context, 0, intentEducation, 0);
            RemoteViews viewsEducation = new RemoteViews(context.getPackageName(), R.layout.app_widget);
            viewsEducation.setOnClickPendingIntent(R.id.appWidgetEducation, pendingIntentEducation);
            appWidgetManager.updateAppWidget(appWidgetId, viewsEducation);

            Intent intentJobs = new Intent(context, Employement.class);
            intentJobs.putExtra("lang", R.string.lang);
            PendingIntent pendingIntentJobs = PendingIntent.getActivity(context, 0, intentJobs, 0);
            RemoteViews viewsJobs = new RemoteViews(context.getPackageName(), R.layout.app_widget);
            viewsJobs.setOnClickPendingIntent(R.id.appWidgetJobs, pendingIntentJobs);
            appWidgetManager.updateAppWidget(appWidgetId, viewsJobs);

            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:0377778888"));
            PendingIntent pendingIntentSos = PendingIntent.getActivity(context, 0, callIntent, 0);
            RemoteViews viewsSos = new RemoteViews(context.getPackageName(), R.layout.app_widget);
            viewsSos.setOnClickPendingIntent(R.id.appWidgetSos, pendingIntentSos);
            appWidgetManager.updateAppWidget(appWidgetId, viewsSos);
        }
    }
}
