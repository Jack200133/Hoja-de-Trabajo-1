import structure.Assert;

public class Radio {
    protected boolean isOn; // is the radio on
    protected boolean isFM; // is the radio tuned to FM
    protected double tunedTo; // current radio freq
    protected double tunedToAM; // current AM radio freq
    protected double tunedToFM; // current FM radio freq
    protected double FMFreq[]; // presets for FM
    protected double AMFreq[]; // presets for AM
    protected double AMPreset = 1030.0; // factory setting for AM
    protected double FMPreset = 88.5; // factory setting for FM



    public Radio()
// post: constructs a radio, initially tuned to FM.
// FM presets are 88.5, and AM presets are 1030.
    {
        FMFreq = new double[12];
        AMFreq = new double[12];
        for (int i = 0; i < 12; i++)
        {
            FMFreq[i] = FMPreset;
            AMFreq[i] = AMPreset;
        }
        on();
        AM();
        press(1);
        FM();
        press(1);
        off();
    }

    public boolean isOn()
// post: returns true iff the radio is on
    {
        return isOn;
    }
    public boolean isFM()
    // post: returns true iff the radio is set to FM
    {
        return isFM;
    }

    protected boolean validAM(double f)
// post: returns true iff f is a valid AM frequency
    {
        return (530 <= f && f <= 1610) && (0.0 == f % 10.0);
    }
    protected boolean validFM(double f)
// post: returns true iff f is a valid FM frequency
    {
        return (87.9 <= f) && (f <= 107.9) && ((((int)(f*10+0.5))-879)%2) == 0;
    }
    public void set(int button, double frequency)
// pre: radio is on and
// button is between 1 and 12, and
// frequency is a multiple of 10 if set to AM, or .2 if set to FM
// post: sets the indicated preset if the frequency is valid
    {
        if (!isOn()) return;
        Assert.pre(button >= 1 && button <= 12, "Button value between 1 and 12.");
        if (isFM() && validFM(frequency)) FMFreq[button-1] = frequency;
        if ((!isFM()) && validAM(frequency)) AMFreq[button-1] = frequency;
    }
    public void press(int button)
// pre: button is between 1 and 12
// post: tunes radio to preset indicated by button
    {
        if (isFM()) tune(FMFreq[button-1]);
        else tune(AMFreq[button-1]);
    }
    public void tune(double freq)
// pre: radio is on and frequency is valid for current AM/FM setting
// post: tunes the indicated radio frequency
    {
        if (!isOn()) return;
        if (isFM() && validFM(freq)) tunedTo = tunedToFM = freq;
        else if ((!isFM()) && validAM(freq)) tunedTo = tunedToAM = freq;
    }

    public double frequency()
// post: returns the frequency that the radio is tuned to.
    {
        return tunedTo;
    }

    public void AM()
// post: sets frequency range to AM; tunes radio to last AM freq
    {
        isFM = false;
        tunedTo = tunedToAM;
    }
    public void FM()
// post: sets frequency range to FM; tunes radio to last FM freq
    {
        isFM = true;
        tunedTo = tunedToFM;
    }
    public void on()
// post: turns radio on
    {
        isOn = true;
    }
    public void off()
// post: turns radio off
    {
        isOn = false;
    }

    public String toString()
// post: generates a string representing the radio.
    {
        String result = "<Radio: ";
        if (isOn()) result += "turned on, ";
        else result += "turned off, ";
        if (isFM()) {
            result += "tuned to FM frequency "+tunedTo+"\n";
            result += "current AM frequency is "+tunedToAM+"\n";
        } else {
            result += "tuned to AM frequency "+tunedTo+"\n";
            result += "current FM frequency is "+tunedToFM+"\n";;
        }
        int i;
        result += "FM presets: ";
        for (i = 1; i <= 12; i++)
        {
            result += " "+FMFreq[i-1];
        }
        result += "\n";
        result += "AM presets: ";
        for (i = 1; i <= 12; i++)
        {
            result += " "+AMFreq[i-1];
        }
        result += "\n";
        result += ">";
        return result;
    }
}
