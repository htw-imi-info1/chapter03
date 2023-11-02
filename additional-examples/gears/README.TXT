------------------------------------------------------------------------
This is a simple example for communicating objects:

It calculates the gear_inches and metres of development for 
a bicycle with one gear.

------------------------------------------------------------------------

Wheel has two fields:  rim and tire
Gear calculates the gear_ratio from it's fields sprocket and cog.

Wheel wheel1 = new Wheel(622, 25);
Gear gear1 = new Gear(48, 24);
Bicycle bicycle1 = new Bicycle(wheel1, gear1);
gear1.gearRatio();
    // returned double 2.0
wheel1.getCircumference();
    // returned double 2111.150263212341
bicycle1.gearInches();
    // returned double 52.91338582677166
bicycle1.gearInches();
    // returned double 52.91338582677166
gear1.gearRatio();
    // returned double 2.0
wheel1.getCircumference();
    // returned double 2111.150263212341
bicycle1.rollOut();
    // returned double 4222.300526424682