package com.example.webviewtest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;


public class WritableWebView extends WebView {

	private Path _writedPath = null;
	private Paint _paint = null;
	private Canvas _canvas = null;
	private Bitmap _Bitmap;
	
	private boolean _writable = true;
	
	public WritableWebView(Context context) {
		super(context);
		
		_Bitmap = Bitmap.createBitmap(320, 480, Bitmap.Config.ARGB_8888);
		_canvas = new Canvas(_Bitmap);
		_writedPath = new Path();
		_paint = new Paint(Paint.DITHER_FLAG);
		_paint.setAntiAlias(true);
		_paint.setDither(true);
		_paint.setColor(0xFFFF0000);
		_paint.setStyle(Paint.Style.STROKE);
		_paint.setStrokeJoin(Paint.Join.ROUND);
		_paint.setStrokeCap(Paint.Cap.ROUND);
		_paint.setStrokeWidth(12);
	}
	
	public WritableWebView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		_Bitmap = Bitmap.createBitmap(320, 480, Bitmap.Config.ARGB_8888);
		_canvas = new Canvas(_Bitmap);
		_writedPath = new Path();
		_paint = new Paint(Paint.DITHER_FLAG);
		_paint.setAntiAlias(true);
		_paint.setDither(true);
		_paint.setColor(0xFFFF0000);
		_paint.setStyle(Paint.Style.STROKE);
		_paint.setStrokeJoin(Paint.Join.ROUND);
		_paint.setStrokeCap(Paint.Cap.ROUND);
		_paint.setStrokeWidth(12);
	}
	
	public WritableWebView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		
		_Bitmap = Bitmap.createBitmap(320, 480, Bitmap.Config.ARGB_8888);
		_canvas = new Canvas(_Bitmap);
		_writedPath = new Path();
		_paint = new Paint(Paint.DITHER_FLAG);
		_paint.setAntiAlias(true);
		_paint.setDither(true);
		_paint.setColor(0xFFFF0000);
		_paint.setStyle(Paint.Style.STROKE);
		_paint.setStrokeJoin(Paint.Join.ROUND);
		_paint.setStrokeCap(Paint.Cap.ROUND);
		_paint.setStrokeWidth(12);
	}
	
	
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		canvas.drawPath(_writedPath, _paint);
	}
	
	private float mX, mY;
	private static final float TOUCH_TOLERANCE = 4;
	
	private void touch_start(float x, float y) {
		_writedPath.reset();
		_writedPath.moveTo(x, y);
		mX = x;
		mY = y;
	}

	private void touch_move(float x, float y) {
		float dx = Math.abs(x - mX);
		float dy = Math.abs(y - mY);

		if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) {
			_writedPath.quadTo(mX, mY, (x + mX)/2, (y + mY)/2);
			mX = x;
			mY = y;
		}
	}

	private void touch_up() {
		_writedPath.lineTo(mX, mY);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (_writable == true) {
			float x = event.getX();
			float y = event.getY();
			
			switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				touch_start(x, y);
				invalidate();
				break;
			case MotionEvent.ACTION_MOVE:
				touch_move(x, y);
				invalidate();
				break;
			case MotionEvent.ACTION_UP:
				touch_up();
				invalidate();
				break;
			}
			return true;
		}
		else {
			return super.onTouchEvent(event);
		}
	}
}
