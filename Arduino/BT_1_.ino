#include<SoftwareSerial.h>


#define bt_txd 7
#define bt_rxd 8
SoftwareSerial BTSerial(8,7);

byte buffer[512];
int bufferPosition;

void setup() {

  // put your setup code here, to run once:

  Serial.begin(9600);
  pinMode(3,INPUT);
  pinMode(2,OUTPUT);
  BTSerial.begin(9600);

  bufferPosition = 0;
}



void loop() {
  // put your main code here, to run repeatedly:
  int a = digitalRead(3);
  if(a == LOW)
    BTSerial.println("open");
  else
    BTSerial.println("close");
  if (BTSerial.available() ){
    byte data = BTSerial.read();
    Serial.write(data);
    buffer[bufferPosition++] = data;
    if (data == '\n'){
      buffer[bufferPosition] = '\0';
      BTSerial.write(buffer, bufferPosition);
      bufferPosition = 0;
      }
 
      
    }
 
  if (Serial.available()){
    BTSerial.write(Serial.read());
    }
  
  if(a == HIGH)
  {
    digitalWrite(2,LOW);
    delay(1000);
  }

  else{
    digitalWrite(2,HIGH);
    delay(1000);
    }
}
