//%% NEW FILE traffic BEGINS HERE %%

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.27.0.3777.6132757 modeling language!*/


package SEG2106.core;

// line 3 "model.ump"
// line 134 "model.ump"
public class traffic
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //traffic State Machines
  public enum Low { nsArrowEWRed, nsGreenWERed, nsYellowWERed, nsRedWEGreen, nsRedWEYellow }
  private Low low;
  public enum High { nArrowAndGreenSEWRed, nYellowSWERed, nRedSGreenAndArrowWERed, nRedSYellowWERed, nRedSRedWGreenAndArrowERed, nRedSRedWGreenEGreen, nsRedWEYellow }
  private High high;
  public enum Moderate { northGreenRestRed, northYellowRestRed, southGreenRestRed, southYellowRestRed, westAndEastGreenNorthAndSouthRed, westAndEastYellowNorthAndSouthRed }
  private Moderate moderate;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public traffic()
  {
    setLow(Low.nsArrowEWRed);
    setHigh(High.nArrowAndGreenSEWRed);
    setModerate(Moderate.northGreenRestRed);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public String getLowFullName()
  {
    String answer = low.toString();
    return answer;
  }

  public String getHighFullName()
  {
    String answer = high.toString();
    return answer;
  }

  public String getModerateFullName()
  {
    String answer = moderate.toString();
    return answer;
  }

  public Low getLow()
  {
    return low;
  }

  public High getHigh()
  {
    return high;
  }

  public Moderate getModerate()
  {
    return moderate;
  }

  public boolean toSecond()
  {
    boolean wasEventProcessed = false;
    
    Low aLow = low;
    High aHigh = high;
    switch (aLow)
    {
      case nsArrowEWRed:
        setLow(Low.nsGreenWERed);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aHigh)
    {
      case nArrowAndGreenSEWRed:
        setHigh(High.nYellowSWERed);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean toThird()
  {
    boolean wasEventProcessed = false;
    
    Low aLow = low;
    High aHigh = high;
    switch (aLow)
    {
      case nsGreenWERed:
        setLow(Low.nsYellowWERed);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aHigh)
    {
      case nYellowSWERed:
        setHigh(High.nRedSGreenAndArrowWERed);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean toFourth()
  {
    boolean wasEventProcessed = false;
    
    Low aLow = low;
    High aHigh = high;
    switch (aLow)
    {
      case nsYellowWERed:
        setLow(Low.nsRedWEGreen);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aHigh)
    {
      case nRedSGreenAndArrowWERed:
        setHigh(High.nRedSYellowWERed);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean toFith()
  {
    boolean wasEventProcessed = false;
    
    Low aLow = low;
    High aHigh = high;
    switch (aLow)
    {
      case nsRedWEGreen:
        setLow(Low.nsRedWEYellow);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aHigh)
    {
      case nRedSYellowWERed:
        setHigh(High.nRedSRedWGreenAndArrowERed);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean toFirst()
  {
    boolean wasEventProcessed = false;
    
    Low aLow = low;
    High aHigh = high;
    switch (aLow)
    {
      case nsRedWEYellow:
        setLow(Low.nsArrowEWRed);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aHigh)
    {
      case nsRedWEYellow:
        setHigh(High.nArrowAndGreenSEWRed);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean toSixth()
  {
    boolean wasEventProcessed = false;
    
    High aHigh = high;
    switch (aHigh)
    {
      case nRedSRedWGreenAndArrowERed:
        setHigh(High.nRedSRedWGreenEGreen);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean toSeventh()
  {
    boolean wasEventProcessed = false;
    
    High aHigh = high;
    switch (aHigh)
    {
      case nRedSRedWGreenEGreen:
        setHigh(High.nsRedWEYellow);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean timerGreen()
  {
    boolean wasEventProcessed = false;
    
    Moderate aModerate = moderate;
    switch (aModerate)
    {
      case northGreenRestRed:
        setModerate(Moderate.northYellowRestRed);
        wasEventProcessed = true;
        break;
      case northYellowRestRed:
        setModerate(Moderate.southGreenRestRed);
        wasEventProcessed = true;
        break;
      case southYellowRestRed:
        setModerate(Moderate.westAndEastGreenNorthAndSouthRed);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean timerYellow()
  {
    boolean wasEventProcessed = false;
    
    Moderate aModerate = moderate;
    switch (aModerate)
    {
      case southGreenRestRed:
        setModerate(Moderate.southYellowRestRed);
        wasEventProcessed = true;
        break;
      case westAndEastGreenNorthAndSouthRed:
        setModerate(Moderate.westAndEastYellowNorthAndSouthRed);
        wasEventProcessed = true;
        break;
      case westAndEastYellowNorthAndSouthRed:
        setModerate(Moderate.northGreenRestRed);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void setLow(Low aLow)
  {
    low = aLow;

    // entry actions and do activities
    switch(low)
    {
      case nsArrowEWRed:
        // line 8 "model.ump"
        traficsLightManager.northArrow();
        // line 9 "model.ump"
        traficsLightManager.southArrow();
        // line 10 "model.ump"
        traficsLightManager.westRed();
        // line 11 "model.ump"
        traficsLightManager.eastRed();
        break;
      case nsGreenWERed:
        // line 14 "model.ump"
        traficsLightManager.northGreen();
        // line 15 "model.ump"
        traficsLightManager.southGreen();
        // line 16 "model.ump"
        traficsLightManager.westRed();
        // line 17 "model.ump"
        traficsLightManager.eastRed();
        break;
      case nsYellowWERed:
        // line 20 "model.ump"
        traficsLightManager.northYellow();
        // line 21 "model.ump"
        traficsLightManager.southYellow();
        // line 22 "model.ump"
        traficsLightManager.westRed();
        // line 23 "model.ump"
        traficsLightManager.eastRed();
        break;
      case nsRedWEGreen:
        // line 26 "model.ump"
        traficsLightManager.northRed();
        // line 27 "model.ump"
        traficsLightManager.southRed();
        // line 28 "model.ump"
        traficsLightManager.westGreen();
        // line 29 "model.ump"
        traficsLightManager.eastGreen();
        break;
      case nsRedWEYellow:
        // line 32 "model.ump"
        traficsLightManager.northRed();
        // line 33 "model.ump"
        traficsLightManager.southRed();
        // line 34 "model.ump"
        traficsLightManager.westYellow();
        // line 35 "model.ump"
        traficsLightManager.eastYellow();
        break;
    }
  }

  private void setHigh(High aHigh)
  {
    high = aHigh;

    // entry actions and do activities
    switch(high)
    {
      case nArrowAndGreenSEWRed:
        // line 43 "model.ump"
        traficsLightManager.northGreenAndArrow();
        // line 44 "model.ump"
        traficsLightManager.southRed();
        // line 45 "model.ump"
        traficsLightManager.westRed();
        // line 46 "model.ump"
        traficsLightManager.eastRed();
        break;
      case nYellowSWERed:
        // line 49 "model.ump"
        traficsLightManager.northYellow();
        // line 50 "model.ump"
        traficsLightManager.southRed();
        // line 51 "model.ump"
        traficsLightManager.westRed();
        // line 52 "model.ump"
        traficsLightManager.eastRed();
        break;
      case nRedSGreenAndArrowWERed:
        // line 55 "model.ump"
        traficsLightManager.northRed();
        // line 56 "model.ump"
        traficsLightManager.southGreenAndArrow();
        // line 57 "model.ump"
        traficsLightManager.westRed();
        // line 58 "model.ump"
        traficsLightManager.eastRed();
        break;
      case nRedSYellowWERed:
        // line 61 "model.ump"
        traficsLightManager.northRed();
        // line 62 "model.ump"
        traficsLightManager.southYellow();
        // line 63 "model.ump"
        traficsLightManager.westRed();
        // line 64 "model.ump"
        traficsLightManager.eastRed();
        break;
      case nRedSRedWGreenAndArrowERed:
        // line 67 "model.ump"
        traficsLightManager.northRed();
        // line 68 "model.ump"
        traficsLightManager.southRed();
        // line 69 "model.ump"
        traficsLightManager.westGreenAndYellow();
        // line 70 "model.ump"
        traficsLightManager.eastRed();
        break;
      case nRedSRedWGreenEGreen:
        // line 73 "model.ump"
        traficsLightManager.northRed();
        // line 74 "model.ump"
        traficsLightManager.southRed();
        // line 75 "model.ump"
        traficsLightManager.westGreen();
        // line 76 "model.ump"
        traficsLightManager.eastGreen();
        break;
      case nsRedWEYellow:
        // line 79 "model.ump"
        traficsLightManager.northRed();
        // line 80 "model.ump"
        traficsLightManager.southRed();
        // line 81 "model.ump"
        traficsLightManager.westGreenAndYellow();
        // line 82 "model.ump"
        traficsLightManager.eastYellow();
        break;
    }
  }

  private void setModerate(Moderate aModerate)
  {
    moderate = aModerate;

    // entry actions and do activities
    switch(moderate)
    {
      case northGreenRestRed:
        // line 89 "model.ump"
        trafficLightManager.northGreenAndArrow();
        // line 90 "model.ump"
        trafficLightManager.southRed();
        // line 91 "model.ump"
        trafficLightManager.westRed();
        // line 92 "model.ump"
        trafficLightManager.eastRed();
        break;
      case northYellowRestRed:
        // line 96 "model.ump"
        trafficLightManager.northYellow();
        // line 97 "model.ump"
        trafficLightManager.southRed();
        // line 98 "model.ump"
        trafficLightManager.westRed();
        // line 99 "model.ump"
        trafficLightManager.eastRed();
        break;
      case southGreenRestRed:
        // line 103 "model.ump"
        trafficLightManager.northRed();
        // line 104 "model.ump"
        trafficLightManager.southGreenAndArrow();
        // line 105 "model.ump"
        trafficLightManager.westRed();
        // line 106 "model.ump"
        trafficLightManager.eastRed();
        break;
      case southYellowRestRed:
        // line 110 "model.ump"
        trafficLightManager.northRed();
        // line 111 "model.ump"
        trafficLightManager.southYellow();
        // line 112 "model.ump"
        trafficLightManager.westRed();
        // line 113 "model.ump"
        trafficLightManager.eastRed();
        break;
      case westAndEastGreenNorthAndSouthRed:
        // line 117 "model.ump"
        trafficLightManager.northRed();
        // line 118 "model.ump"
        trafficLightManager.southRed();
        // line 119 "model.ump"
        trafficLightManager.wesGreen();
        // line 120 "model.ump"
        trafficLightManager.eastGreen();
        break;
      case westAndEastYellowNorthAndSouthRed:
        // line 124 "model.ump"
        trafficLightManager.northRed();
        // line 125 "model.ump"
        trafficLightManager.southRed();
        // line 126 "model.ump"
        trafficLightManager.wesYellow();
        // line 127 "model.ump"
        trafficLightManager.eastYellow();
        break;
    }
  }

  public void delete()
  {}

}