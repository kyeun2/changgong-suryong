package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class Simplesetting1 extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(
                getApplicationContext(), Simplesetting.class
        );
        startActivity(intent);
    }

    ArrayAdapter<CharSequence> adspin1, adspin2;    //Adapter
    String choice_do="";
    String choice_si="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simplesetting1);
        final Spinner spin1 = (Spinner)findViewById(R.id.spinner);
        final Spinner spin2 = (Spinner)findViewById(R.id.spinner2);
        final Button btn_do = (Button)findViewById(R.id.button7);
        final LinearLayout layout1 = (LinearLayout)findViewById(R.id.layout1);
        final Button btn_re = (Button)findViewById(R.id.button8);
        final TextView text_re = (TextView)findViewById(R.id.re_Address);
        final EditText edit_re = (EditText) findViewById(R.id.re_editText);
        final TextView Address = (TextView)findViewById(R.id.text_address);
        Button before = (Button)findViewById(R.id.button5);
        Button After = (Button)findViewById(R.id.button6);

        adspin1 = ArrayAdapter.createFromResource(this, R.array.Address, android.R.layout.simple_spinner_dropdown_item);
        adspin1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(adspin1);
        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (adspin1.getItem(position).equals("서울특별시")) {
                    choice_do = "서울특별시";
                    adspin2 = ArrayAdapter.createFromResource(Simplesetting1.this, R.array.Seoul, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            choice_si = adspin2.getItem(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
                else if (adspin1.getItem(position).equals("인천광역시")) {
                    choice_do = "인천광역시";
                    adspin2 = ArrayAdapter.createFromResource(Simplesetting1.this, R.array.Incheon, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            choice_si = adspin2.getItem(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
                else if (adspin1.getItem(position).equals("경기도")) {
                    choice_do = "경기도";
                    adspin2 = ArrayAdapter.createFromResource(Simplesetting1.this, R.array.GamZa, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            choice_si = adspin2.getItem(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
                else if (adspin1.getItem(position).equals("대전광역시")) {
                    choice_do = "대전광역시";
                    adspin2 = ArrayAdapter.createFromResource(Simplesetting1.this, R.array.DaeJeon, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            choice_si = adspin2.getItem(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
                else if (adspin1.getItem(position).equals("충청북도")) {
                    choice_do = "충청북도";
                    adspin2 = ArrayAdapter.createFromResource(Simplesetting1.this, R.array.chungbuk, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            choice_si = adspin2.getItem(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
                else if (adspin1.getItem(position).equals("충청남도")) {
                    choice_do = "충청남도";
                    adspin2 = ArrayAdapter.createFromResource(Simplesetting1.this, R.array.chungnam, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            choice_si = adspin2.getItem(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
                else if (adspin1.getItem(position).equals("대구광역시")) {
                    choice_do = "대구광역시";
                    adspin2 = ArrayAdapter.createFromResource(Simplesetting1.this, R.array.DaeGu, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            choice_si = adspin2.getItem(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
                else if (adspin1.getItem(position).equals("경상북도")) {
                    choice_do = "경상북도";
                    adspin2 = ArrayAdapter.createFromResource(Simplesetting1.this, R.array.gyeongbuk, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            choice_si = adspin2.getItem(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
                else if (adspin1.getItem(position).equals("부산광역시")) {
                    choice_do = "부산광역시";
                    adspin2 = ArrayAdapter.createFromResource(Simplesetting1.this, R.array.Busan, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            choice_si = adspin2.getItem(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
                else if (adspin1.getItem(position).equals("경상남도")) {
                    choice_do = "경상남도";
                    adspin2 = ArrayAdapter.createFromResource(Simplesetting1.this, R.array.gyeongnam, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            choice_si = adspin2.getItem(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
                else if (adspin1.getItem(position).equals("광주광역시")) {
                    choice_do = "광주광역시";
                    adspin2 = ArrayAdapter.createFromResource(Simplesetting1.this, R.array.gwangju, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            choice_si = adspin2.getItem(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
                else if (adspin1.getItem(position).equals("전라북도")) {
                    choice_do = "전라북도";
                    adspin2 = ArrayAdapter.createFromResource(Simplesetting1.this, R.array.jeonbuk, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            choice_si = adspin2.getItem(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
                else if (adspin1.getItem(position).equals("전라남도")) {
                    choice_do = "전라남도";
                    adspin2 = ArrayAdapter.createFromResource(Simplesetting1.this, R.array.jeonnam, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            choice_si = adspin2.getItem(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
                else if (adspin1.getItem(position).equals("강원도")) {
                    choice_do = "강원도";
                    adspin2 = ArrayAdapter.createFromResource(Simplesetting1.this, R.array.RealGamZa, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            choice_si = adspin2.getItem(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
                else if (adspin1.getItem(position).equals("제주특별자치도")) {
                    choice_do = "제주특별자치도";
                    adspin2 = ArrayAdapter.createFromResource(Simplesetting1.this, R.array.Jeju, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            choice_si = adspin2.getItem(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
        btn_do.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout1.setVisibility(view.VISIBLE);
            }
        });

        btn_re.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                text_re.setVisibility(view.VISIBLE);
                edit_re.setVisibility(view.VISIBLE);
            }
        });





        After.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String InputAddress = choice_do + "  " + choice_si + "  " + edit_re.getText().toString();
                //데이터 저장
                SharedPreferences add_preferences = getSharedPreferences("Address_Output", MODE_PRIVATE);
                SharedPreferences.Editor editor1 = add_preferences.edit();
                editor1.putString("add_1", InputAddress);
                editor1.commit();
                //데이터 다른 레이아웃에 넘기기
                Intent intent = new Intent(Simplesetting1.this, MainActivity.class);
                intent.putExtra("Address_Output", InputAddress);
                startActivity(intent);
                //다음페이지
                Intent intent1 = new Intent(
                        getApplicationContext(), Simplesetting2.class
                );
                startActivity(intent1);
                finish();
            }
        });

        before.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getApplicationContext(), Simplesetting.class
                );
                startActivity(intent);
                finish();
            }

        });
    }
}
