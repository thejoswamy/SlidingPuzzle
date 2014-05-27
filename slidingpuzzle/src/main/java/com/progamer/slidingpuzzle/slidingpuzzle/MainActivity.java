package com.progamer.slidingpuzzle.slidingpuzzle;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button10;
    private Button button11;
    private Button button12;
    private Button button13;
    private Button button14;
    private Button button15;
    private Button button16;

    private Slider slate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button10 = (Button) findViewById(R.id.button10);
        button11 = (Button) findViewById(R.id.button11);
        button12 = (Button) findViewById(R.id.button12);
        button13 = (Button) findViewById(R.id.button13);
        button14 = (Button) findViewById(R.id.button14);
        button15 = (Button) findViewById(R.id.button15);
        button16 = (Button) findViewById(R.id.button16);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "Alice-Regular.ttf");
        button1.setTypeface(typeface);
        button2.setTypeface(typeface);
        button3.setTypeface(typeface);
        button4.setTypeface(typeface);
        button5.setTypeface(typeface);
        button6.setTypeface(typeface);
        button7.setTypeface(typeface);
        button8.setTypeface(typeface);
        button9.setTypeface(typeface);
        button10.setTypeface(typeface);
        button11.setTypeface(typeface);
        button12.setTypeface(typeface);
        button13.setTypeface(typeface);
        button14.setTypeface(typeface);
        button15.setTypeface(typeface);
        button16.setTypeface(typeface);

        startGame();

    }

    private void startGame() {

        slate = new Slider(4);
        slate.shuffleSlider();
        button1.setText(slate.valueAt(1));
        button2.setText(slate.valueAt(2));
        button3.setText(slate.valueAt(3));
        button4.setText(slate.valueAt(4));
        button5.setText(slate.valueAt(5));
        button6.setText(slate.valueAt(6));
        button7.setText(slate.valueAt(7));
        button8.setText(slate.valueAt(8));
        button9.setText(slate.valueAt(9));
        button10.setText(slate.valueAt(10));
        button11.setText(slate.valueAt(11));
        button12.setText(slate.valueAt(12));
        button13.setText(slate.valueAt(13));
        button14.setText(slate.valueAt(14));
        button15.setText(slate.valueAt(15));
        button16.setText(slate.valueAt(16));

        getButton(slate.zeroAt()).setVisibility(View.INVISIBLE);

    }


    private Button getButton(int position) {

        Button b = button1;
        switch (position) {
            case 1:
                b = button1;
                break;
            case 2:
                b = button2;
                break;
            case 3:
                b = button3;
                break;
            case 4:
                b = button4;
                break;
            case 5:
                b = button5;
                break;
            case 6:
                b = button6;
                break;
            case 7:
                b = button7;
                break;
            case 8:
                b = button8;
                break;
            case 9:
                b = button9;
                break;
            case 10:
                b = button10;
                break;
            case 11:
                b = button11;
                break;
            case 12:
                b = button12;
                break;
            case 13:
                b = button13;
                break;
            case 14:
                b = button14;
                break;
            case 15:
                b = button15;
                break;
            case 16:
                b = button16;
                break;
        }

        return b;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.new_game) {
            newGame();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void clickButton(View v) {

        int id = v.getId();
        int current_position, empty_position;

        switch (id) {
            case R.id.button1:
                current_position = 1;
                if ((empty_position = slate.isNeighbourEmpty(current_position)) != -1) {
                    button1.setVisibility(View.INVISIBLE);
                    getButton(empty_position).setVisibility(View.VISIBLE);
                    getButton(empty_position).setText(slate.valueAt(current_position));
                    slate.swaps(current_position, empty_position);

                    check_completion();
                }
                break;
            case R.id.button2:
                current_position = 2;
                if ((empty_position = slate.isNeighbourEmpty(current_position)) != -1) {
                    button2.setVisibility(View.INVISIBLE);
                    getButton(empty_position).setVisibility(View.VISIBLE);
                    getButton(empty_position).setText(slate.valueAt(current_position));
                    slate.swaps(current_position, empty_position);

                    check_completion();
                }
                break;
            case R.id.button3:
                current_position = 3;
                if ((empty_position = slate.isNeighbourEmpty(current_position)) != -1) {
                    button3.setVisibility(View.INVISIBLE);
                    getButton(empty_position).setVisibility(View.VISIBLE);
                    getButton(empty_position).setText(slate.valueAt(current_position));
                    slate.swaps(current_position, empty_position);

                    check_completion();
                }
                break;
            case R.id.button4:
                current_position = 4;
                if ((empty_position = slate.isNeighbourEmpty(current_position)) != -1) {
                    button4.setVisibility(View.INVISIBLE);
                    getButton(empty_position).setVisibility(View.VISIBLE);
                    getButton(empty_position).setText(slate.valueAt(current_position));
                    slate.swaps(current_position, empty_position);

                    check_completion();
                }
                break;
            case R.id.button5:
                current_position = 5;
                if ((empty_position = slate.isNeighbourEmpty(current_position)) != -1) {
                    button5.setVisibility(View.INVISIBLE);
                    getButton(empty_position).setVisibility(View.VISIBLE);
                    getButton(empty_position).setText(slate.valueAt(current_position));
                    slate.swaps(current_position, empty_position);

                    check_completion();
                }
                break;
            case R.id.button6:
                current_position = 6;
                if ((empty_position = slate.isNeighbourEmpty(current_position)) != -1) {
                    button6.setVisibility(View.INVISIBLE);
                    getButton(empty_position).setVisibility(View.VISIBLE);
                    getButton(empty_position).setText(slate.valueAt(current_position));
                    slate.swaps(current_position, empty_position);

                    check_completion();
                }
                break;
            case R.id.button7:
                current_position = 7;
                if ((empty_position = slate.isNeighbourEmpty(current_position)) != -1) {
                    button7.setVisibility(View.INVISIBLE);
                    getButton(empty_position).setVisibility(View.VISIBLE);
                    getButton(empty_position).setText(slate.valueAt(current_position));
                    slate.swaps(current_position, empty_position);

                    check_completion();
                }
                break;
            case R.id.button8:
                current_position = 8;
                if ((empty_position = slate.isNeighbourEmpty(current_position)) != -1) {
                    button8.setVisibility(View.INVISIBLE);
                    getButton(empty_position).setVisibility(View.VISIBLE);
                    getButton(empty_position).setText(slate.valueAt(current_position));
                    slate.swaps(current_position, empty_position);

                    check_completion();
                }
                break;
            case R.id.button9:
                current_position = 9;
                if ((empty_position = slate.isNeighbourEmpty(current_position)) != -1) {
                    button9.setVisibility(View.INVISIBLE);
                    getButton(empty_position).setVisibility(View.VISIBLE);
                    getButton(empty_position).setText(slate.valueAt(current_position));
                    slate.swaps(current_position, empty_position);

                    check_completion();
                }
                break;
            case R.id.button10:
                current_position = 10;
                if ((empty_position = slate.isNeighbourEmpty(current_position)) != -1) {
                    button10.setVisibility(View.INVISIBLE);
                    getButton(empty_position).setVisibility(View.VISIBLE);
                    getButton(empty_position).setText(slate.valueAt(current_position));
                    slate.swaps(current_position, empty_position);

                    check_completion();
                }
                break;
            case R.id.button11:
                current_position = 11;
                if ((empty_position = slate.isNeighbourEmpty(current_position)) != -1) {
                    button11.setVisibility(View.INVISIBLE);
                    getButton(empty_position).setVisibility(View.VISIBLE);
                    getButton(empty_position).setText(slate.valueAt(current_position));
                    slate.swaps(current_position, empty_position);

                    check_completion();
                }
                break;
            case R.id.button12:
                current_position = 12;
                if ((empty_position = slate.isNeighbourEmpty(current_position)) != -1) {
                    button12.setVisibility(View.INVISIBLE);
                    getButton(empty_position).setVisibility(View.VISIBLE);
                    getButton(empty_position).setText(slate.valueAt(current_position));
                    slate.swaps(current_position, empty_position);

                    check_completion();
                }
                break;
            case R.id.button13:
                current_position = 13;
                if ((empty_position = slate.isNeighbourEmpty(current_position)) != -1) {
                    button13.setVisibility(View.INVISIBLE);
                    getButton(empty_position).setVisibility(View.VISIBLE);
                    getButton(empty_position).setText(slate.valueAt(current_position));
                    slate.swaps(current_position, empty_position);

                    check_completion();
                }
                break;
            case R.id.button14:
                current_position = 14;
                if ((empty_position = slate.isNeighbourEmpty(current_position)) != -1) {
                    button14.setVisibility(View.INVISIBLE);
                    getButton(empty_position).setVisibility(View.VISIBLE);
                    getButton(empty_position).setText(slate.valueAt(current_position));
                    slate.swaps(current_position, empty_position);

                    check_completion();
                }
                break;
            case R.id.button15:
                current_position = 15;
                if ((empty_position = slate.isNeighbourEmpty(current_position)) != -1) {
                    button15.setVisibility(View.INVISIBLE);
                    getButton(empty_position).setVisibility(View.VISIBLE);
                    getButton(empty_position).setText(slate.valueAt(current_position));
                    slate.swaps(current_position, empty_position);

                    check_completion();
                }
                break;
            case R.id.button16:
                current_position = 16;
                if ((empty_position = slate.isNeighbourEmpty(current_position)) != -1) {
                    button16.setVisibility(View.INVISIBLE);
                    getButton(empty_position).setVisibility(View.VISIBLE);
                    getButton(empty_position).setText(slate.valueAt(current_position));
                    slate.swaps(current_position, empty_position);

                    check_completion();
                }
                break;
        }

    }

    private void check_completion() {

        if (slate.isCompleted()) {
            showCompletionDialog();
        }
    }

    private void showCompletionDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this, AlertDialog.THEME_HOLO_DARK);
        builder.setTitle(R.string.dialog_title);
        builder.setPositiveButton(getString(R.string.restart), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                newGame();
            }
        });

        builder.setNegativeButton(getString(R.string.quit), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                endGame();
            }
        });
        builder.setCancelable(false);

        AlertDialog dialog = builder.create();
        dialog.show();

    }

    private void endGame() {
        finish();
    }

    private void newGame() {
        getButton(slate.zeroAt()).setVisibility(View.VISIBLE);
        startGame();
    }
}
