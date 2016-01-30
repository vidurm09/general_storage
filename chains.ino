int photoresist = 3; //Photoresistor pin
int brightness = 0; //Don't worry about it
int chains = 0; //Keeps track of chain count
int threshold = 511; //Value that separates light and no light
bool pulse = false; //if pulse registered

void setup() {
  // put your setup code here, to run once:

}

void loop() {
  // put your main code here, to run repeatedly:
  brightness = analogRead(photoresist); //Read photoresistor
  //If code has not recognized a pulse and is over threshold add one chain and set pulse to true
  if(!pulse && brightness > threshold) {
    chains++;
    pulse = true;
  }
  //If light is below threshold and pulse is recognized then set pulse to false to wait for another one
  if(pulse && brightness <= threshold) {
    pulse = false;
  }
}
