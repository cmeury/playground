/**
 * Copyright 2012, netbreeze GmbH
 */
package ch.wurmlo.tawogo;

import android.app.Activity;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class TaWoGoProvider extends AppWidgetProvider {

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
		// This method is also called when the user adds the App Widget, so it should perform the
		// essential setup, such as define event handlers for Views and start a temporary Service,
		// if necessary.

		Intent intent = new Intent(Intent.ACTION_DIAL);
		PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

		RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.tawogo);
		views.setOnClickPendingIntent(R.id.goButton, pendingIntent);
	}


}
