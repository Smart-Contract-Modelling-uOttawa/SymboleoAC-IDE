package ca.uottawa.csmlab.symboleo.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import ca.uottawa.csmlab.symboleo.services.SymboleoGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSymboleoParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Domain'", "';'", "'endDomain'", "'TimeGranularity'", "'is'", "'Contract'", "'('", "','", "')'", "'Declarations'", "'Preconditions'", "'Postconditions'", "'Obligations'", "'Surviving'", "'Powers'", "'ACPolicy'", "'Constraints'", "'endContract'", "'isA'", "'isAn'", "'Enumeration'", "'with'", "':'", "'precondition'", "'postcondition'", "'Number'", "'String'", "'Date'", "'Boolean'", "'Asset'", "'Event'", "'Role'", "'DataTransfer'", "'Resource'", "'Controller'", "'Grant'", "'Revoke'", "'To'", "'On'", "'by'", "'obligations.'", "'powers.'", "'read'", "'write'", "'all'", "'transfer'", "'thirdParty'", "'Env'", "'.'", "':='", "'or'", "'and'", "'=='", "'!='", "'>='", "'<='", "'>'", "'<'", "'+'", "'-'", "'*'", "'/'", "'%'", "'not'", "'true'", "'false'", "'Math.pow'", "'Math.max'", "'Math.min'", "'Math.abs'", "'Math.floor'", "'Math.cbrt'", "'Math.ceil'", "'Math.exp'", "'Math.sign'", "'Math.sqrt'", "'String.substring'", "'String.replaceAll'", "'String.concat'", "'String.toLowerCase'", "'String.toUpperCase'", "'String.trimEnd'", "'String.trimStart'", "'String.trim'", "'Date.add'", "'->'", "'O'", "'Obligation'", "'P'", "'Power'", "'Suspended'", "'Resumed'", "'Discharged'", "'Terminated'", "'Triggered'", "'self'", "'Happens'", "'WhappensBefore'", "'ShappensBefore'", "'HappensWithin'", "'WhappensBeforeE'", "'ShappensBeforeE'", "'HappensAfter'", "'Occurs'", "'HappensAssign'", "'Assign'", "'IsEqual'", "'IsOwner'", "'CannotBeAssigned'", "'Activated'", "'Exerted'", "'Expired'", "'Fulfilled'", "'Violated'", "'FulfilledObligations'", "'RevokedParty'", "'AssignedParty'", "'Rescinded'", "'seconds'", "'minutes'", "'hours'", "'days'", "'weeks'", "'months'", "'years'", "'Interval'", "'Create'", "'UnsuccessfulTermination'", "'Active'", "'InEffect'", "'Suspension'", "'SuccessfulTermination'", "'Discharge'", "'Violation'", "'Fulfillment'", "'Form'", "'UnAssign'", "'Rescission'"
    };
    public static final int T__144=144;
    public static final int T__143=143;
    public static final int T__146=146;
    public static final int T__50=50;
    public static final int T__145=145;
    public static final int T__140=140;
    public static final int T__142=142;
    public static final int T__141=141;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__137=137;
    public static final int T__52=52;
    public static final int T__136=136;
    public static final int T__53=53;
    public static final int T__139=139;
    public static final int T__54=54;
    public static final int T__138=138;
    public static final int T__133=133;
    public static final int T__132=132;
    public static final int T__60=60;
    public static final int T__135=135;
    public static final int T__61=61;
    public static final int T__134=134;
    public static final int RULE_ID=4;
    public static final int T__131=131;
    public static final int T__130=130;
    public static final int RULE_INT=5;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__67=67;
    public static final int T__129=129;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__126=126;
    public static final int T__63=63;
    public static final int T__125=125;
    public static final int T__64=64;
    public static final int T__128=128;
    public static final int T__65=65;
    public static final int T__127=127;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__148=148;
    public static final int T__41=41;
    public static final int T__147=147;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__99=99;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__122=122;
    public static final int T__70=70;
    public static final int T__121=121;
    public static final int T__71=71;
    public static final int T__124=124;
    public static final int T__72=72;
    public static final int T__123=123;
    public static final int T__120=120;
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__77=77;
    public static final int T__119=119;
    public static final int T__78=78;
    public static final int T__118=118;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int T__115=115;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__114=114;
    public static final int T__75=75;
    public static final int T__117=117;
    public static final int T__76=76;
    public static final int T__116=116;
    public static final int T__80=80;
    public static final int T__111=111;
    public static final int T__81=81;
    public static final int T__110=110;
    public static final int T__82=82;
    public static final int T__113=113;
    public static final int T__83=83;
    public static final int T__112=112;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int T__87=87;
    public static final int T__105=105;

    // delegates
    // delegators


        public InternalSymboleoParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSymboleoParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSymboleoParser.tokenNames; }
    public String getGrammarFileName() { return "InternalSymboleo.g"; }



     	private SymboleoGrammarAccess grammarAccess;

        public InternalSymboleoParser(TokenStream input, SymboleoGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected SymboleoGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalSymboleo.g:64:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalSymboleo.g:64:46: (iv_ruleModel= ruleModel EOF )
            // InternalSymboleo.g:65:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalSymboleo.g:71:1: ruleModel returns [EObject current=null] : (otherlv_0= 'Domain' ( (lv_domainName_1_0= RULE_ID ) ) ( ( (lv_domainTypes_2_0= ruleDomainType ) ) otherlv_3= ';' )+ otherlv_4= 'endDomain' (otherlv_5= 'TimeGranularity' otherlv_6= 'is' ( (lv_timeUnits_7_0= ruleTimeUnit ) ) )? otherlv_8= 'Contract' ( (lv_contractName_9_0= RULE_ID ) ) otherlv_10= '(' ( ( (lv_parameters_11_0= ruleParameter ) ) otherlv_12= ',' )+ ( (lv_parameters_13_0= ruleParameter ) ) otherlv_14= ')' (otherlv_15= 'Declarations' ( ( (lv_variables_16_0= ruleVariable ) ) otherlv_17= ';' )* )? (otherlv_18= 'Preconditions' ( ( (lv_preconditions_19_0= ruleProposition ) ) otherlv_20= ';' )* )? (otherlv_21= 'Postconditions' ( ( (lv_postconditions_22_0= ruleProposition ) ) otherlv_23= ';' )* )? (otherlv_24= 'Obligations' ( ( (lv_obligations_25_0= ruleObligation ) ) otherlv_26= ';' )* )+ (otherlv_27= 'Surviving' otherlv_28= 'Obligations' ( ( (lv_survivingObligations_29_0= ruleObligation ) ) otherlv_30= ';' )* )? (otherlv_31= 'Powers' ( ( (lv_powers_32_0= rulePower ) ) otherlv_33= ';' )* )? (otherlv_34= 'ACPolicy' ( (lv_acpolicys_35_0= ruleACPolicy ) ) ( ( (lv_rules_36_0= ruleRule ) ) otherlv_37= ';' )* )? (otherlv_38= 'Constraints' ( ( (lv_constraints_39_0= ruleProposition ) ) otherlv_40= ';' )* )? otherlv_41= 'endContract' ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_domainName_1_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token lv_contractName_9_0=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_26=null;
        Token otherlv_27=null;
        Token otherlv_28=null;
        Token otherlv_30=null;
        Token otherlv_31=null;
        Token otherlv_33=null;
        Token otherlv_34=null;
        Token otherlv_37=null;
        Token otherlv_38=null;
        Token otherlv_40=null;
        Token otherlv_41=null;
        EObject lv_domainTypes_2_0 = null;

        AntlrDatatypeRuleToken lv_timeUnits_7_0 = null;

        EObject lv_parameters_11_0 = null;

        EObject lv_parameters_13_0 = null;

        EObject lv_variables_16_0 = null;

        EObject lv_preconditions_19_0 = null;

        EObject lv_postconditions_22_0 = null;

        EObject lv_obligations_25_0 = null;

        EObject lv_survivingObligations_29_0 = null;

        EObject lv_powers_32_0 = null;

        EObject lv_acpolicys_35_0 = null;

        EObject lv_rules_36_0 = null;

        EObject lv_constraints_39_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:77:2: ( (otherlv_0= 'Domain' ( (lv_domainName_1_0= RULE_ID ) ) ( ( (lv_domainTypes_2_0= ruleDomainType ) ) otherlv_3= ';' )+ otherlv_4= 'endDomain' (otherlv_5= 'TimeGranularity' otherlv_6= 'is' ( (lv_timeUnits_7_0= ruleTimeUnit ) ) )? otherlv_8= 'Contract' ( (lv_contractName_9_0= RULE_ID ) ) otherlv_10= '(' ( ( (lv_parameters_11_0= ruleParameter ) ) otherlv_12= ',' )+ ( (lv_parameters_13_0= ruleParameter ) ) otherlv_14= ')' (otherlv_15= 'Declarations' ( ( (lv_variables_16_0= ruleVariable ) ) otherlv_17= ';' )* )? (otherlv_18= 'Preconditions' ( ( (lv_preconditions_19_0= ruleProposition ) ) otherlv_20= ';' )* )? (otherlv_21= 'Postconditions' ( ( (lv_postconditions_22_0= ruleProposition ) ) otherlv_23= ';' )* )? (otherlv_24= 'Obligations' ( ( (lv_obligations_25_0= ruleObligation ) ) otherlv_26= ';' )* )+ (otherlv_27= 'Surviving' otherlv_28= 'Obligations' ( ( (lv_survivingObligations_29_0= ruleObligation ) ) otherlv_30= ';' )* )? (otherlv_31= 'Powers' ( ( (lv_powers_32_0= rulePower ) ) otherlv_33= ';' )* )? (otherlv_34= 'ACPolicy' ( (lv_acpolicys_35_0= ruleACPolicy ) ) ( ( (lv_rules_36_0= ruleRule ) ) otherlv_37= ';' )* )? (otherlv_38= 'Constraints' ( ( (lv_constraints_39_0= ruleProposition ) ) otherlv_40= ';' )* )? otherlv_41= 'endContract' ) )
            // InternalSymboleo.g:78:2: (otherlv_0= 'Domain' ( (lv_domainName_1_0= RULE_ID ) ) ( ( (lv_domainTypes_2_0= ruleDomainType ) ) otherlv_3= ';' )+ otherlv_4= 'endDomain' (otherlv_5= 'TimeGranularity' otherlv_6= 'is' ( (lv_timeUnits_7_0= ruleTimeUnit ) ) )? otherlv_8= 'Contract' ( (lv_contractName_9_0= RULE_ID ) ) otherlv_10= '(' ( ( (lv_parameters_11_0= ruleParameter ) ) otherlv_12= ',' )+ ( (lv_parameters_13_0= ruleParameter ) ) otherlv_14= ')' (otherlv_15= 'Declarations' ( ( (lv_variables_16_0= ruleVariable ) ) otherlv_17= ';' )* )? (otherlv_18= 'Preconditions' ( ( (lv_preconditions_19_0= ruleProposition ) ) otherlv_20= ';' )* )? (otherlv_21= 'Postconditions' ( ( (lv_postconditions_22_0= ruleProposition ) ) otherlv_23= ';' )* )? (otherlv_24= 'Obligations' ( ( (lv_obligations_25_0= ruleObligation ) ) otherlv_26= ';' )* )+ (otherlv_27= 'Surviving' otherlv_28= 'Obligations' ( ( (lv_survivingObligations_29_0= ruleObligation ) ) otherlv_30= ';' )* )? (otherlv_31= 'Powers' ( ( (lv_powers_32_0= rulePower ) ) otherlv_33= ';' )* )? (otherlv_34= 'ACPolicy' ( (lv_acpolicys_35_0= ruleACPolicy ) ) ( ( (lv_rules_36_0= ruleRule ) ) otherlv_37= ';' )* )? (otherlv_38= 'Constraints' ( ( (lv_constraints_39_0= ruleProposition ) ) otherlv_40= ';' )* )? otherlv_41= 'endContract' )
            {
            // InternalSymboleo.g:78:2: (otherlv_0= 'Domain' ( (lv_domainName_1_0= RULE_ID ) ) ( ( (lv_domainTypes_2_0= ruleDomainType ) ) otherlv_3= ';' )+ otherlv_4= 'endDomain' (otherlv_5= 'TimeGranularity' otherlv_6= 'is' ( (lv_timeUnits_7_0= ruleTimeUnit ) ) )? otherlv_8= 'Contract' ( (lv_contractName_9_0= RULE_ID ) ) otherlv_10= '(' ( ( (lv_parameters_11_0= ruleParameter ) ) otherlv_12= ',' )+ ( (lv_parameters_13_0= ruleParameter ) ) otherlv_14= ')' (otherlv_15= 'Declarations' ( ( (lv_variables_16_0= ruleVariable ) ) otherlv_17= ';' )* )? (otherlv_18= 'Preconditions' ( ( (lv_preconditions_19_0= ruleProposition ) ) otherlv_20= ';' )* )? (otherlv_21= 'Postconditions' ( ( (lv_postconditions_22_0= ruleProposition ) ) otherlv_23= ';' )* )? (otherlv_24= 'Obligations' ( ( (lv_obligations_25_0= ruleObligation ) ) otherlv_26= ';' )* )+ (otherlv_27= 'Surviving' otherlv_28= 'Obligations' ( ( (lv_survivingObligations_29_0= ruleObligation ) ) otherlv_30= ';' )* )? (otherlv_31= 'Powers' ( ( (lv_powers_32_0= rulePower ) ) otherlv_33= ';' )* )? (otherlv_34= 'ACPolicy' ( (lv_acpolicys_35_0= ruleACPolicy ) ) ( ( (lv_rules_36_0= ruleRule ) ) otherlv_37= ';' )* )? (otherlv_38= 'Constraints' ( ( (lv_constraints_39_0= ruleProposition ) ) otherlv_40= ';' )* )? otherlv_41= 'endContract' )
            // InternalSymboleo.g:79:3: otherlv_0= 'Domain' ( (lv_domainName_1_0= RULE_ID ) ) ( ( (lv_domainTypes_2_0= ruleDomainType ) ) otherlv_3= ';' )+ otherlv_4= 'endDomain' (otherlv_5= 'TimeGranularity' otherlv_6= 'is' ( (lv_timeUnits_7_0= ruleTimeUnit ) ) )? otherlv_8= 'Contract' ( (lv_contractName_9_0= RULE_ID ) ) otherlv_10= '(' ( ( (lv_parameters_11_0= ruleParameter ) ) otherlv_12= ',' )+ ( (lv_parameters_13_0= ruleParameter ) ) otherlv_14= ')' (otherlv_15= 'Declarations' ( ( (lv_variables_16_0= ruleVariable ) ) otherlv_17= ';' )* )? (otherlv_18= 'Preconditions' ( ( (lv_preconditions_19_0= ruleProposition ) ) otherlv_20= ';' )* )? (otherlv_21= 'Postconditions' ( ( (lv_postconditions_22_0= ruleProposition ) ) otherlv_23= ';' )* )? (otherlv_24= 'Obligations' ( ( (lv_obligations_25_0= ruleObligation ) ) otherlv_26= ';' )* )+ (otherlv_27= 'Surviving' otherlv_28= 'Obligations' ( ( (lv_survivingObligations_29_0= ruleObligation ) ) otherlv_30= ';' )* )? (otherlv_31= 'Powers' ( ( (lv_powers_32_0= rulePower ) ) otherlv_33= ';' )* )? (otherlv_34= 'ACPolicy' ( (lv_acpolicys_35_0= ruleACPolicy ) ) ( ( (lv_rules_36_0= ruleRule ) ) otherlv_37= ';' )* )? (otherlv_38= 'Constraints' ( ( (lv_constraints_39_0= ruleProposition ) ) otherlv_40= ';' )* )? otherlv_41= 'endContract'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getModelAccess().getDomainKeyword_0());
            		
            // InternalSymboleo.g:83:3: ( (lv_domainName_1_0= RULE_ID ) )
            // InternalSymboleo.g:84:4: (lv_domainName_1_0= RULE_ID )
            {
            // InternalSymboleo.g:84:4: (lv_domainName_1_0= RULE_ID )
            // InternalSymboleo.g:85:5: lv_domainName_1_0= RULE_ID
            {
            lv_domainName_1_0=(Token)match(input,RULE_ID,FOLLOW_3); 

            					newLeafNode(lv_domainName_1_0, grammarAccess.getModelAccess().getDomainNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getModelRule());
            					}
            					setWithLastConsumed(
            						current,
            						"domainName",
            						lv_domainName_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalSymboleo.g:101:3: ( ( (lv_domainTypes_2_0= ruleDomainType ) ) otherlv_3= ';' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalSymboleo.g:102:4: ( (lv_domainTypes_2_0= ruleDomainType ) ) otherlv_3= ';'
            	    {
            	    // InternalSymboleo.g:102:4: ( (lv_domainTypes_2_0= ruleDomainType ) )
            	    // InternalSymboleo.g:103:5: (lv_domainTypes_2_0= ruleDomainType )
            	    {
            	    // InternalSymboleo.g:103:5: (lv_domainTypes_2_0= ruleDomainType )
            	    // InternalSymboleo.g:104:6: lv_domainTypes_2_0= ruleDomainType
            	    {

            	    						newCompositeNode(grammarAccess.getModelAccess().getDomainTypesDomainTypeParserRuleCall_2_0_0());
            	    					
            	    pushFollow(FOLLOW_4);
            	    lv_domainTypes_2_0=ruleDomainType();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getModelRule());
            	    						}
            	    						add(
            	    							current,
            	    							"domainTypes",
            	    							lv_domainTypes_2_0,
            	    							"ca.uottawa.csmlab.symboleo.Symboleo.DomainType");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    otherlv_3=(Token)match(input,12,FOLLOW_5); 

            	    				newLeafNode(otherlv_3, grammarAccess.getModelAccess().getSemicolonKeyword_2_1());
            	    			

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

            otherlv_4=(Token)match(input,13,FOLLOW_6); 

            			newLeafNode(otherlv_4, grammarAccess.getModelAccess().getEndDomainKeyword_3());
            		
            // InternalSymboleo.g:130:3: (otherlv_5= 'TimeGranularity' otherlv_6= 'is' ( (lv_timeUnits_7_0= ruleTimeUnit ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==14) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalSymboleo.g:131:4: otherlv_5= 'TimeGranularity' otherlv_6= 'is' ( (lv_timeUnits_7_0= ruleTimeUnit ) )
                    {
                    otherlv_5=(Token)match(input,14,FOLLOW_7); 

                    				newLeafNode(otherlv_5, grammarAccess.getModelAccess().getTimeGranularityKeyword_4_0());
                    			
                    otherlv_6=(Token)match(input,15,FOLLOW_8); 

                    				newLeafNode(otherlv_6, grammarAccess.getModelAccess().getIsKeyword_4_1());
                    			
                    // InternalSymboleo.g:139:4: ( (lv_timeUnits_7_0= ruleTimeUnit ) )
                    // InternalSymboleo.g:140:5: (lv_timeUnits_7_0= ruleTimeUnit )
                    {
                    // InternalSymboleo.g:140:5: (lv_timeUnits_7_0= ruleTimeUnit )
                    // InternalSymboleo.g:141:6: lv_timeUnits_7_0= ruleTimeUnit
                    {

                    						newCompositeNode(grammarAccess.getModelAccess().getTimeUnitsTimeUnitParserRuleCall_4_2_0());
                    					
                    pushFollow(FOLLOW_9);
                    lv_timeUnits_7_0=ruleTimeUnit();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getModelRule());
                    						}
                    						set(
                    							current,
                    							"timeUnits",
                    							lv_timeUnits_7_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.TimeUnit");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,16,FOLLOW_3); 

            			newLeafNode(otherlv_8, grammarAccess.getModelAccess().getContractKeyword_5());
            		
            // InternalSymboleo.g:163:3: ( (lv_contractName_9_0= RULE_ID ) )
            // InternalSymboleo.g:164:4: (lv_contractName_9_0= RULE_ID )
            {
            // InternalSymboleo.g:164:4: (lv_contractName_9_0= RULE_ID )
            // InternalSymboleo.g:165:5: lv_contractName_9_0= RULE_ID
            {
            lv_contractName_9_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_contractName_9_0, grammarAccess.getModelAccess().getContractNameIDTerminalRuleCall_6_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getModelRule());
            					}
            					setWithLastConsumed(
            						current,
            						"contractName",
            						lv_contractName_9_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_10=(Token)match(input,17,FOLLOW_3); 

            			newLeafNode(otherlv_10, grammarAccess.getModelAccess().getLeftParenthesisKeyword_7());
            		
            // InternalSymboleo.g:185:3: ( ( (lv_parameters_11_0= ruleParameter ) ) otherlv_12= ',' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                alt3 = dfa3.predict(input);
                switch (alt3) {
            	case 1 :
            	    // InternalSymboleo.g:186:4: ( (lv_parameters_11_0= ruleParameter ) ) otherlv_12= ','
            	    {
            	    // InternalSymboleo.g:186:4: ( (lv_parameters_11_0= ruleParameter ) )
            	    // InternalSymboleo.g:187:5: (lv_parameters_11_0= ruleParameter )
            	    {
            	    // InternalSymboleo.g:187:5: (lv_parameters_11_0= ruleParameter )
            	    // InternalSymboleo.g:188:6: lv_parameters_11_0= ruleParameter
            	    {

            	    						newCompositeNode(grammarAccess.getModelAccess().getParametersParameterParserRuleCall_8_0_0());
            	    					
            	    pushFollow(FOLLOW_11);
            	    lv_parameters_11_0=ruleParameter();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getModelRule());
            	    						}
            	    						add(
            	    							current,
            	    							"parameters",
            	    							lv_parameters_11_0,
            	    							"ca.uottawa.csmlab.symboleo.Symboleo.Parameter");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    otherlv_12=(Token)match(input,18,FOLLOW_3); 

            	    				newLeafNode(otherlv_12, grammarAccess.getModelAccess().getCommaKeyword_8_1());
            	    			

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

            // InternalSymboleo.g:210:3: ( (lv_parameters_13_0= ruleParameter ) )
            // InternalSymboleo.g:211:4: (lv_parameters_13_0= ruleParameter )
            {
            // InternalSymboleo.g:211:4: (lv_parameters_13_0= ruleParameter )
            // InternalSymboleo.g:212:5: lv_parameters_13_0= ruleParameter
            {

            					newCompositeNode(grammarAccess.getModelAccess().getParametersParameterParserRuleCall_9_0());
            				
            pushFollow(FOLLOW_12);
            lv_parameters_13_0=ruleParameter();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getModelRule());
            					}
            					add(
            						current,
            						"parameters",
            						lv_parameters_13_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.Parameter");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_14=(Token)match(input,19,FOLLOW_13); 

            			newLeafNode(otherlv_14, grammarAccess.getModelAccess().getRightParenthesisKeyword_10());
            		
            // InternalSymboleo.g:233:3: (otherlv_15= 'Declarations' ( ( (lv_variables_16_0= ruleVariable ) ) otherlv_17= ';' )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==20) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalSymboleo.g:234:4: otherlv_15= 'Declarations' ( ( (lv_variables_16_0= ruleVariable ) ) otherlv_17= ';' )*
                    {
                    otherlv_15=(Token)match(input,20,FOLLOW_14); 

                    				newLeafNode(otherlv_15, grammarAccess.getModelAccess().getDeclarationsKeyword_11_0());
                    			
                    // InternalSymboleo.g:238:4: ( ( (lv_variables_16_0= ruleVariable ) ) otherlv_17= ';' )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==RULE_ID) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalSymboleo.g:239:5: ( (lv_variables_16_0= ruleVariable ) ) otherlv_17= ';'
                    	    {
                    	    // InternalSymboleo.g:239:5: ( (lv_variables_16_0= ruleVariable ) )
                    	    // InternalSymboleo.g:240:6: (lv_variables_16_0= ruleVariable )
                    	    {
                    	    // InternalSymboleo.g:240:6: (lv_variables_16_0= ruleVariable )
                    	    // InternalSymboleo.g:241:7: lv_variables_16_0= ruleVariable
                    	    {

                    	    							newCompositeNode(grammarAccess.getModelAccess().getVariablesVariableParserRuleCall_11_1_0_0());
                    	    						
                    	    pushFollow(FOLLOW_4);
                    	    lv_variables_16_0=ruleVariable();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getModelRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"variables",
                    	    								lv_variables_16_0,
                    	    								"ca.uottawa.csmlab.symboleo.Symboleo.Variable");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }

                    	    otherlv_17=(Token)match(input,12,FOLLOW_14); 

                    	    					newLeafNode(otherlv_17, grammarAccess.getModelAccess().getSemicolonKeyword_11_1_1());
                    	    				

                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalSymboleo.g:264:3: (otherlv_18= 'Preconditions' ( ( (lv_preconditions_19_0= ruleProposition ) ) otherlv_20= ';' )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==21) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalSymboleo.g:265:4: otherlv_18= 'Preconditions' ( ( (lv_preconditions_19_0= ruleProposition ) ) otherlv_20= ';' )*
                    {
                    otherlv_18=(Token)match(input,21,FOLLOW_15); 

                    				newLeafNode(otherlv_18, grammarAccess.getModelAccess().getPreconditionsKeyword_12_0());
                    			
                    // InternalSymboleo.g:269:4: ( ( (lv_preconditions_19_0= ruleProposition ) ) otherlv_20= ';' )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>=RULE_ID && LA6_0<=RULE_STRING)||LA6_0==17||LA6_0==38||(LA6_0>=74 && LA6_0<=76)||(LA6_0>=107 && LA6_0<=119)) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalSymboleo.g:270:5: ( (lv_preconditions_19_0= ruleProposition ) ) otherlv_20= ';'
                    	    {
                    	    // InternalSymboleo.g:270:5: ( (lv_preconditions_19_0= ruleProposition ) )
                    	    // InternalSymboleo.g:271:6: (lv_preconditions_19_0= ruleProposition )
                    	    {
                    	    // InternalSymboleo.g:271:6: (lv_preconditions_19_0= ruleProposition )
                    	    // InternalSymboleo.g:272:7: lv_preconditions_19_0= ruleProposition
                    	    {

                    	    							newCompositeNode(grammarAccess.getModelAccess().getPreconditionsPropositionParserRuleCall_12_1_0_0());
                    	    						
                    	    pushFollow(FOLLOW_4);
                    	    lv_preconditions_19_0=ruleProposition();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getModelRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"preconditions",
                    	    								lv_preconditions_19_0,
                    	    								"ca.uottawa.csmlab.symboleo.Symboleo.Proposition");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }

                    	    otherlv_20=(Token)match(input,12,FOLLOW_15); 

                    	    					newLeafNode(otherlv_20, grammarAccess.getModelAccess().getSemicolonKeyword_12_1_1());
                    	    				

                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalSymboleo.g:295:3: (otherlv_21= 'Postconditions' ( ( (lv_postconditions_22_0= ruleProposition ) ) otherlv_23= ';' )* )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==22) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalSymboleo.g:296:4: otherlv_21= 'Postconditions' ( ( (lv_postconditions_22_0= ruleProposition ) ) otherlv_23= ';' )*
                    {
                    otherlv_21=(Token)match(input,22,FOLLOW_16); 

                    				newLeafNode(otherlv_21, grammarAccess.getModelAccess().getPostconditionsKeyword_13_0());
                    			
                    // InternalSymboleo.g:300:4: ( ( (lv_postconditions_22_0= ruleProposition ) ) otherlv_23= ';' )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( ((LA8_0>=RULE_ID && LA8_0<=RULE_STRING)||LA8_0==17||LA8_0==38||(LA8_0>=74 && LA8_0<=76)||(LA8_0>=107 && LA8_0<=119)) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalSymboleo.g:301:5: ( (lv_postconditions_22_0= ruleProposition ) ) otherlv_23= ';'
                    	    {
                    	    // InternalSymboleo.g:301:5: ( (lv_postconditions_22_0= ruleProposition ) )
                    	    // InternalSymboleo.g:302:6: (lv_postconditions_22_0= ruleProposition )
                    	    {
                    	    // InternalSymboleo.g:302:6: (lv_postconditions_22_0= ruleProposition )
                    	    // InternalSymboleo.g:303:7: lv_postconditions_22_0= ruleProposition
                    	    {

                    	    							newCompositeNode(grammarAccess.getModelAccess().getPostconditionsPropositionParserRuleCall_13_1_0_0());
                    	    						
                    	    pushFollow(FOLLOW_4);
                    	    lv_postconditions_22_0=ruleProposition();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getModelRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"postconditions",
                    	    								lv_postconditions_22_0,
                    	    								"ca.uottawa.csmlab.symboleo.Symboleo.Proposition");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }

                    	    otherlv_23=(Token)match(input,12,FOLLOW_16); 

                    	    					newLeafNode(otherlv_23, grammarAccess.getModelAccess().getSemicolonKeyword_13_1_1());
                    	    				

                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalSymboleo.g:326:3: (otherlv_24= 'Obligations' ( ( (lv_obligations_25_0= ruleObligation ) ) otherlv_26= ';' )* )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==23) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalSymboleo.g:327:4: otherlv_24= 'Obligations' ( ( (lv_obligations_25_0= ruleObligation ) ) otherlv_26= ';' )*
            	    {
            	    otherlv_24=(Token)match(input,23,FOLLOW_17); 

            	    				newLeafNode(otherlv_24, grammarAccess.getModelAccess().getObligationsKeyword_14_0());
            	    			
            	    // InternalSymboleo.g:331:4: ( ( (lv_obligations_25_0= ruleObligation ) ) otherlv_26= ';' )*
            	    loop10:
            	    do {
            	        int alt10=2;
            	        int LA10_0 = input.LA(1);

            	        if ( (LA10_0==RULE_ID) ) {
            	            alt10=1;
            	        }


            	        switch (alt10) {
            	    	case 1 :
            	    	    // InternalSymboleo.g:332:5: ( (lv_obligations_25_0= ruleObligation ) ) otherlv_26= ';'
            	    	    {
            	    	    // InternalSymboleo.g:332:5: ( (lv_obligations_25_0= ruleObligation ) )
            	    	    // InternalSymboleo.g:333:6: (lv_obligations_25_0= ruleObligation )
            	    	    {
            	    	    // InternalSymboleo.g:333:6: (lv_obligations_25_0= ruleObligation )
            	    	    // InternalSymboleo.g:334:7: lv_obligations_25_0= ruleObligation
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getModelAccess().getObligationsObligationParserRuleCall_14_1_0_0());
            	    	    						
            	    	    pushFollow(FOLLOW_4);
            	    	    lv_obligations_25_0=ruleObligation();

            	    	    state._fsp--;


            	    	    							if (current==null) {
            	    	    								current = createModelElementForParent(grammarAccess.getModelRule());
            	    	    							}
            	    	    							add(
            	    	    								current,
            	    	    								"obligations",
            	    	    								lv_obligations_25_0,
            	    	    								"ca.uottawa.csmlab.symboleo.Symboleo.Obligation");
            	    	    							afterParserOrEnumRuleCall();
            	    	    						

            	    	    }


            	    	    }

            	    	    otherlv_26=(Token)match(input,12,FOLLOW_17); 

            	    	    					newLeafNode(otherlv_26, grammarAccess.getModelAccess().getSemicolonKeyword_14_1_1());
            	    	    				

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop10;
            	        }
            	    } while (true);


            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);

            // InternalSymboleo.g:357:3: (otherlv_27= 'Surviving' otherlv_28= 'Obligations' ( ( (lv_survivingObligations_29_0= ruleObligation ) ) otherlv_30= ';' )* )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==24) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalSymboleo.g:358:4: otherlv_27= 'Surviving' otherlv_28= 'Obligations' ( ( (lv_survivingObligations_29_0= ruleObligation ) ) otherlv_30= ';' )*
                    {
                    otherlv_27=(Token)match(input,24,FOLLOW_18); 

                    				newLeafNode(otherlv_27, grammarAccess.getModelAccess().getSurvivingKeyword_15_0());
                    			
                    otherlv_28=(Token)match(input,23,FOLLOW_19); 

                    				newLeafNode(otherlv_28, grammarAccess.getModelAccess().getObligationsKeyword_15_1());
                    			
                    // InternalSymboleo.g:366:4: ( ( (lv_survivingObligations_29_0= ruleObligation ) ) otherlv_30= ';' )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==RULE_ID) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalSymboleo.g:367:5: ( (lv_survivingObligations_29_0= ruleObligation ) ) otherlv_30= ';'
                    	    {
                    	    // InternalSymboleo.g:367:5: ( (lv_survivingObligations_29_0= ruleObligation ) )
                    	    // InternalSymboleo.g:368:6: (lv_survivingObligations_29_0= ruleObligation )
                    	    {
                    	    // InternalSymboleo.g:368:6: (lv_survivingObligations_29_0= ruleObligation )
                    	    // InternalSymboleo.g:369:7: lv_survivingObligations_29_0= ruleObligation
                    	    {

                    	    							newCompositeNode(grammarAccess.getModelAccess().getSurvivingObligationsObligationParserRuleCall_15_2_0_0());
                    	    						
                    	    pushFollow(FOLLOW_4);
                    	    lv_survivingObligations_29_0=ruleObligation();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getModelRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"survivingObligations",
                    	    								lv_survivingObligations_29_0,
                    	    								"ca.uottawa.csmlab.symboleo.Symboleo.Obligation");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }

                    	    otherlv_30=(Token)match(input,12,FOLLOW_19); 

                    	    					newLeafNode(otherlv_30, grammarAccess.getModelAccess().getSemicolonKeyword_15_2_1());
                    	    				

                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalSymboleo.g:392:3: (otherlv_31= 'Powers' ( ( (lv_powers_32_0= rulePower ) ) otherlv_33= ';' )* )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==25) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalSymboleo.g:393:4: otherlv_31= 'Powers' ( ( (lv_powers_32_0= rulePower ) ) otherlv_33= ';' )*
                    {
                    otherlv_31=(Token)match(input,25,FOLLOW_20); 

                    				newLeafNode(otherlv_31, grammarAccess.getModelAccess().getPowersKeyword_16_0());
                    			
                    // InternalSymboleo.g:397:4: ( ( (lv_powers_32_0= rulePower ) ) otherlv_33= ';' )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==RULE_ID) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalSymboleo.g:398:5: ( (lv_powers_32_0= rulePower ) ) otherlv_33= ';'
                    	    {
                    	    // InternalSymboleo.g:398:5: ( (lv_powers_32_0= rulePower ) )
                    	    // InternalSymboleo.g:399:6: (lv_powers_32_0= rulePower )
                    	    {
                    	    // InternalSymboleo.g:399:6: (lv_powers_32_0= rulePower )
                    	    // InternalSymboleo.g:400:7: lv_powers_32_0= rulePower
                    	    {

                    	    							newCompositeNode(grammarAccess.getModelAccess().getPowersPowerParserRuleCall_16_1_0_0());
                    	    						
                    	    pushFollow(FOLLOW_4);
                    	    lv_powers_32_0=rulePower();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getModelRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"powers",
                    	    								lv_powers_32_0,
                    	    								"ca.uottawa.csmlab.symboleo.Symboleo.Power");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }

                    	    otherlv_33=(Token)match(input,12,FOLLOW_20); 

                    	    					newLeafNode(otherlv_33, grammarAccess.getModelAccess().getSemicolonKeyword_16_1_1());
                    	    				

                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalSymboleo.g:423:3: (otherlv_34= 'ACPolicy' ( (lv_acpolicys_35_0= ruleACPolicy ) ) ( ( (lv_rules_36_0= ruleRule ) ) otherlv_37= ';' )* )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==26) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalSymboleo.g:424:4: otherlv_34= 'ACPolicy' ( (lv_acpolicys_35_0= ruleACPolicy ) ) ( ( (lv_rules_36_0= ruleRule ) ) otherlv_37= ';' )*
                    {
                    otherlv_34=(Token)match(input,26,FOLLOW_21); 

                    				newLeafNode(otherlv_34, grammarAccess.getModelAccess().getACPolicyKeyword_17_0());
                    			
                    // InternalSymboleo.g:428:4: ( (lv_acpolicys_35_0= ruleACPolicy ) )
                    // InternalSymboleo.g:429:5: (lv_acpolicys_35_0= ruleACPolicy )
                    {
                    // InternalSymboleo.g:429:5: (lv_acpolicys_35_0= ruleACPolicy )
                    // InternalSymboleo.g:430:6: lv_acpolicys_35_0= ruleACPolicy
                    {

                    						newCompositeNode(grammarAccess.getModelAccess().getAcpolicysACPolicyParserRuleCall_17_1_0());
                    					
                    pushFollow(FOLLOW_22);
                    lv_acpolicys_35_0=ruleACPolicy();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getModelRule());
                    						}
                    						set(
                    							current,
                    							"acpolicys",
                    							lv_acpolicys_35_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.ACPolicy");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSymboleo.g:447:4: ( ( (lv_rules_36_0= ruleRule ) ) otherlv_37= ';' )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==RULE_ID) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // InternalSymboleo.g:448:5: ( (lv_rules_36_0= ruleRule ) ) otherlv_37= ';'
                    	    {
                    	    // InternalSymboleo.g:448:5: ( (lv_rules_36_0= ruleRule ) )
                    	    // InternalSymboleo.g:449:6: (lv_rules_36_0= ruleRule )
                    	    {
                    	    // InternalSymboleo.g:449:6: (lv_rules_36_0= ruleRule )
                    	    // InternalSymboleo.g:450:7: lv_rules_36_0= ruleRule
                    	    {

                    	    							newCompositeNode(grammarAccess.getModelAccess().getRulesRuleParserRuleCall_17_2_0_0());
                    	    						
                    	    pushFollow(FOLLOW_4);
                    	    lv_rules_36_0=ruleRule();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getModelRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"rules",
                    	    								lv_rules_36_0,
                    	    								"ca.uottawa.csmlab.symboleo.Symboleo.Rule");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }

                    	    otherlv_37=(Token)match(input,12,FOLLOW_22); 

                    	    					newLeafNode(otherlv_37, grammarAccess.getModelAccess().getSemicolonKeyword_17_2_1());
                    	    				

                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalSymboleo.g:473:3: (otherlv_38= 'Constraints' ( ( (lv_constraints_39_0= ruleProposition ) ) otherlv_40= ';' )* )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==27) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalSymboleo.g:474:4: otherlv_38= 'Constraints' ( ( (lv_constraints_39_0= ruleProposition ) ) otherlv_40= ';' )*
                    {
                    otherlv_38=(Token)match(input,27,FOLLOW_23); 

                    				newLeafNode(otherlv_38, grammarAccess.getModelAccess().getConstraintsKeyword_18_0());
                    			
                    // InternalSymboleo.g:478:4: ( ( (lv_constraints_39_0= ruleProposition ) ) otherlv_40= ';' )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( ((LA18_0>=RULE_ID && LA18_0<=RULE_STRING)||LA18_0==17||LA18_0==38||(LA18_0>=74 && LA18_0<=76)||(LA18_0>=107 && LA18_0<=119)) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // InternalSymboleo.g:479:5: ( (lv_constraints_39_0= ruleProposition ) ) otherlv_40= ';'
                    	    {
                    	    // InternalSymboleo.g:479:5: ( (lv_constraints_39_0= ruleProposition ) )
                    	    // InternalSymboleo.g:480:6: (lv_constraints_39_0= ruleProposition )
                    	    {
                    	    // InternalSymboleo.g:480:6: (lv_constraints_39_0= ruleProposition )
                    	    // InternalSymboleo.g:481:7: lv_constraints_39_0= ruleProposition
                    	    {

                    	    							newCompositeNode(grammarAccess.getModelAccess().getConstraintsPropositionParserRuleCall_18_1_0_0());
                    	    						
                    	    pushFollow(FOLLOW_4);
                    	    lv_constraints_39_0=ruleProposition();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getModelRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"constraints",
                    	    								lv_constraints_39_0,
                    	    								"ca.uottawa.csmlab.symboleo.Symboleo.Proposition");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }

                    	    otherlv_40=(Token)match(input,12,FOLLOW_23); 

                    	    					newLeafNode(otherlv_40, grammarAccess.getModelAccess().getSemicolonKeyword_18_1_1());
                    	    				

                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_41=(Token)match(input,28,FOLLOW_2); 

            			newLeafNode(otherlv_41, grammarAccess.getModelAccess().getEndContractKeyword_19());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleDomainType"
    // InternalSymboleo.g:512:1: entryRuleDomainType returns [EObject current=null] : iv_ruleDomainType= ruleDomainType EOF ;
    public final EObject entryRuleDomainType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDomainType = null;


        try {
            // InternalSymboleo.g:512:51: (iv_ruleDomainType= ruleDomainType EOF )
            // InternalSymboleo.g:513:2: iv_ruleDomainType= ruleDomainType EOF
            {
             newCompositeNode(grammarAccess.getDomainTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDomainType=ruleDomainType();

            state._fsp--;

             current =iv_ruleDomainType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDomainType"


    // $ANTLR start "ruleDomainType"
    // InternalSymboleo.g:519:1: ruleDomainType returns [EObject current=null] : (this_Alias_0= ruleAlias | this_RegularType_1= ruleRegularType | this_Enumeration_2= ruleEnumeration ) ;
    public final EObject ruleDomainType() throws RecognitionException {
        EObject current = null;

        EObject this_Alias_0 = null;

        EObject this_RegularType_1 = null;

        EObject this_Enumeration_2 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:525:2: ( (this_Alias_0= ruleAlias | this_RegularType_1= ruleRegularType | this_Enumeration_2= ruleEnumeration ) )
            // InternalSymboleo.g:526:2: (this_Alias_0= ruleAlias | this_RegularType_1= ruleRegularType | this_Enumeration_2= ruleEnumeration )
            {
            // InternalSymboleo.g:526:2: (this_Alias_0= ruleAlias | this_RegularType_1= ruleRegularType | this_Enumeration_2= ruleEnumeration )
            int alt20=3;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_ID) ) {
                int LA20_1 = input.LA(2);

                if ( (LA20_1==30) ) {
                    int LA20_2 = input.LA(3);

                    if ( (LA20_2==RULE_ID||LA20_2==16||(LA20_2>=40 && LA20_2<=44)) ) {
                        alt20=2;
                    }
                    else if ( (LA20_2==31) ) {
                        alt20=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 20, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA20_1==29) ) {
                    int LA20_3 = input.LA(3);

                    if ( (LA20_3==RULE_ID||LA20_3==16||(LA20_3>=40 && LA20_3<=44)) ) {
                        alt20=2;
                    }
                    else if ( ((LA20_3>=36 && LA20_3<=39)) ) {
                        alt20=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 20, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 20, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // InternalSymboleo.g:527:3: this_Alias_0= ruleAlias
                    {

                    			newCompositeNode(grammarAccess.getDomainTypeAccess().getAliasParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Alias_0=ruleAlias();

                    state._fsp--;


                    			current = this_Alias_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:536:3: this_RegularType_1= ruleRegularType
                    {

                    			newCompositeNode(grammarAccess.getDomainTypeAccess().getRegularTypeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_RegularType_1=ruleRegularType();

                    state._fsp--;


                    			current = this_RegularType_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:545:3: this_Enumeration_2= ruleEnumeration
                    {

                    			newCompositeNode(grammarAccess.getDomainTypeAccess().getEnumerationParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Enumeration_2=ruleEnumeration();

                    state._fsp--;


                    			current = this_Enumeration_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDomainType"


    // $ANTLR start "entryRuleAlias"
    // InternalSymboleo.g:557:1: entryRuleAlias returns [EObject current=null] : iv_ruleAlias= ruleAlias EOF ;
    public final EObject entryRuleAlias() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlias = null;


        try {
            // InternalSymboleo.g:557:46: (iv_ruleAlias= ruleAlias EOF )
            // InternalSymboleo.g:558:2: iv_ruleAlias= ruleAlias EOF
            {
             newCompositeNode(grammarAccess.getAliasRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAlias=ruleAlias();

            state._fsp--;

             current =iv_ruleAlias; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAlias"


    // $ANTLR start "ruleAlias"
    // InternalSymboleo.g:564:1: ruleAlias returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'isA' ( (lv_type_2_0= ruleBaseType ) ) ) ;
    public final EObject ruleAlias() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_type_2_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:570:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'isA' ( (lv_type_2_0= ruleBaseType ) ) ) )
            // InternalSymboleo.g:571:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'isA' ( (lv_type_2_0= ruleBaseType ) ) )
            {
            // InternalSymboleo.g:571:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'isA' ( (lv_type_2_0= ruleBaseType ) ) )
            // InternalSymboleo.g:572:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'isA' ( (lv_type_2_0= ruleBaseType ) )
            {
            // InternalSymboleo.g:572:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalSymboleo.g:573:4: (lv_name_0_0= RULE_ID )
            {
            // InternalSymboleo.g:573:4: (lv_name_0_0= RULE_ID )
            // InternalSymboleo.g:574:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_24); 

            					newLeafNode(lv_name_0_0, grammarAccess.getAliasAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAliasRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,29,FOLLOW_25); 

            			newLeafNode(otherlv_1, grammarAccess.getAliasAccess().getIsAKeyword_1());
            		
            // InternalSymboleo.g:594:3: ( (lv_type_2_0= ruleBaseType ) )
            // InternalSymboleo.g:595:4: (lv_type_2_0= ruleBaseType )
            {
            // InternalSymboleo.g:595:4: (lv_type_2_0= ruleBaseType )
            // InternalSymboleo.g:596:5: lv_type_2_0= ruleBaseType
            {

            					newCompositeNode(grammarAccess.getAliasAccess().getTypeBaseTypeParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_type_2_0=ruleBaseType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAliasRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_2_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.BaseType");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAlias"


    // $ANTLR start "entryRuleEnumeration"
    // InternalSymboleo.g:617:1: entryRuleEnumeration returns [EObject current=null] : iv_ruleEnumeration= ruleEnumeration EOF ;
    public final EObject entryRuleEnumeration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumeration = null;


        try {
            // InternalSymboleo.g:617:52: (iv_ruleEnumeration= ruleEnumeration EOF )
            // InternalSymboleo.g:618:2: iv_ruleEnumeration= ruleEnumeration EOF
            {
             newCompositeNode(grammarAccess.getEnumerationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnumeration=ruleEnumeration();

            state._fsp--;

             current =iv_ruleEnumeration; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumeration"


    // $ANTLR start "ruleEnumeration"
    // InternalSymboleo.g:624:1: ruleEnumeration returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'isAn' otherlv_2= 'Enumeration' otherlv_3= '(' ( ( (lv_enumerationItems_4_0= ruleEnumItem ) ) otherlv_5= ',' )* ( (lv_enumerationItems_6_0= ruleEnumItem ) ) otherlv_7= ')' ) ;
    public final EObject ruleEnumeration() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_enumerationItems_4_0 = null;

        EObject lv_enumerationItems_6_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:630:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'isAn' otherlv_2= 'Enumeration' otherlv_3= '(' ( ( (lv_enumerationItems_4_0= ruleEnumItem ) ) otherlv_5= ',' )* ( (lv_enumerationItems_6_0= ruleEnumItem ) ) otherlv_7= ')' ) )
            // InternalSymboleo.g:631:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'isAn' otherlv_2= 'Enumeration' otherlv_3= '(' ( ( (lv_enumerationItems_4_0= ruleEnumItem ) ) otherlv_5= ',' )* ( (lv_enumerationItems_6_0= ruleEnumItem ) ) otherlv_7= ')' )
            {
            // InternalSymboleo.g:631:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'isAn' otherlv_2= 'Enumeration' otherlv_3= '(' ( ( (lv_enumerationItems_4_0= ruleEnumItem ) ) otherlv_5= ',' )* ( (lv_enumerationItems_6_0= ruleEnumItem ) ) otherlv_7= ')' )
            // InternalSymboleo.g:632:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'isAn' otherlv_2= 'Enumeration' otherlv_3= '(' ( ( (lv_enumerationItems_4_0= ruleEnumItem ) ) otherlv_5= ',' )* ( (lv_enumerationItems_6_0= ruleEnumItem ) ) otherlv_7= ')'
            {
            // InternalSymboleo.g:632:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalSymboleo.g:633:4: (lv_name_0_0= RULE_ID )
            {
            // InternalSymboleo.g:633:4: (lv_name_0_0= RULE_ID )
            // InternalSymboleo.g:634:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_26); 

            					newLeafNode(lv_name_0_0, grammarAccess.getEnumerationAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEnumerationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,30,FOLLOW_27); 

            			newLeafNode(otherlv_1, grammarAccess.getEnumerationAccess().getIsAnKeyword_1());
            		
            otherlv_2=(Token)match(input,31,FOLLOW_10); 

            			newLeafNode(otherlv_2, grammarAccess.getEnumerationAccess().getEnumerationKeyword_2());
            		
            otherlv_3=(Token)match(input,17,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getEnumerationAccess().getLeftParenthesisKeyword_3());
            		
            // InternalSymboleo.g:662:3: ( ( (lv_enumerationItems_4_0= ruleEnumItem ) ) otherlv_5= ',' )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_ID) ) {
                    int LA21_1 = input.LA(2);

                    if ( (LA21_1==18) ) {
                        alt21=1;
                    }


                }


                switch (alt21) {
            	case 1 :
            	    // InternalSymboleo.g:663:4: ( (lv_enumerationItems_4_0= ruleEnumItem ) ) otherlv_5= ','
            	    {
            	    // InternalSymboleo.g:663:4: ( (lv_enumerationItems_4_0= ruleEnumItem ) )
            	    // InternalSymboleo.g:664:5: (lv_enumerationItems_4_0= ruleEnumItem )
            	    {
            	    // InternalSymboleo.g:664:5: (lv_enumerationItems_4_0= ruleEnumItem )
            	    // InternalSymboleo.g:665:6: lv_enumerationItems_4_0= ruleEnumItem
            	    {

            	    						newCompositeNode(grammarAccess.getEnumerationAccess().getEnumerationItemsEnumItemParserRuleCall_4_0_0());
            	    					
            	    pushFollow(FOLLOW_11);
            	    lv_enumerationItems_4_0=ruleEnumItem();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getEnumerationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"enumerationItems",
            	    							lv_enumerationItems_4_0,
            	    							"ca.uottawa.csmlab.symboleo.Symboleo.EnumItem");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    otherlv_5=(Token)match(input,18,FOLLOW_3); 

            	    				newLeafNode(otherlv_5, grammarAccess.getEnumerationAccess().getCommaKeyword_4_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            // InternalSymboleo.g:687:3: ( (lv_enumerationItems_6_0= ruleEnumItem ) )
            // InternalSymboleo.g:688:4: (lv_enumerationItems_6_0= ruleEnumItem )
            {
            // InternalSymboleo.g:688:4: (lv_enumerationItems_6_0= ruleEnumItem )
            // InternalSymboleo.g:689:5: lv_enumerationItems_6_0= ruleEnumItem
            {

            					newCompositeNode(grammarAccess.getEnumerationAccess().getEnumerationItemsEnumItemParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_12);
            lv_enumerationItems_6_0=ruleEnumItem();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEnumerationRule());
            					}
            					add(
            						current,
            						"enumerationItems",
            						lv_enumerationItems_6_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.EnumItem");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getEnumerationAccess().getRightParenthesisKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumeration"


    // $ANTLR start "entryRuleEnumItem"
    // InternalSymboleo.g:714:1: entryRuleEnumItem returns [EObject current=null] : iv_ruleEnumItem= ruleEnumItem EOF ;
    public final EObject entryRuleEnumItem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumItem = null;


        try {
            // InternalSymboleo.g:714:49: (iv_ruleEnumItem= ruleEnumItem EOF )
            // InternalSymboleo.g:715:2: iv_ruleEnumItem= ruleEnumItem EOF
            {
             newCompositeNode(grammarAccess.getEnumItemRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnumItem=ruleEnumItem();

            state._fsp--;

             current =iv_ruleEnumItem; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumItem"


    // $ANTLR start "ruleEnumItem"
    // InternalSymboleo.g:721:1: ruleEnumItem returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleEnumItem() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalSymboleo.g:727:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalSymboleo.g:728:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalSymboleo.g:728:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalSymboleo.g:729:3: (lv_name_0_0= RULE_ID )
            {
            // InternalSymboleo.g:729:3: (lv_name_0_0= RULE_ID )
            // InternalSymboleo.g:730:4: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getEnumItemAccess().getNameIDTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getEnumItemRule());
            				}
            				setWithLastConsumed(
            					current,
            					"name",
            					lv_name_0_0,
            					"org.eclipse.xtext.common.Terminals.ID");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumItem"


    // $ANTLR start "entryRuleRegularType"
    // InternalSymboleo.g:749:1: entryRuleRegularType returns [EObject current=null] : iv_ruleRegularType= ruleRegularType EOF ;
    public final EObject entryRuleRegularType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegularType = null;


        try {
            // InternalSymboleo.g:749:52: (iv_ruleRegularType= ruleRegularType EOF )
            // InternalSymboleo.g:750:2: iv_ruleRegularType= ruleRegularType EOF
            {
             newCompositeNode(grammarAccess.getRegularTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRegularType=ruleRegularType();

            state._fsp--;

             current =iv_ruleRegularType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRegularType"


    // $ANTLR start "ruleRegularType"
    // InternalSymboleo.g:756:1: ruleRegularType returns [EObject current=null] : ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'isA' | otherlv_2= 'isAn' ) ( (lv_ontologyType_3_0= ruleOntologyType ) ) ( (lv_thirdParty_4_0= ruleThirdParty ) )? (otherlv_5= 'with' ( ( (lv_attributes_6_0= ruleAttribute ) ) otherlv_7= ',' )* ( (lv_attributes_8_0= ruleAttribute ) ) )? ) | ( ( (lv_name_9_0= RULE_ID ) ) (otherlv_10= 'isA' | otherlv_11= 'isAn' ) ( (otherlv_12= RULE_ID ) ) (otherlv_13= 'with' ( ( (lv_attributes_14_0= ruleAttribute ) ) otherlv_15= ',' )* ( (lv_attributes_16_0= ruleAttribute ) ) )? ) | ( ( (lv_name_17_0= RULE_ID ) ) (otherlv_18= 'isA' | otherlv_19= 'isAn' ) ( (lv_aResource_20_0= ruleAResource ) ) (otherlv_21= 'with' ( ( (lv_attributes_22_0= ruleAttribute ) ) otherlv_23= ',' )* ( (lv_attributes_24_0= ruleAttribute ) ) )? ) ) ;
    public final EObject ruleRegularType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token lv_name_9_0=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token lv_name_17_0=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        EObject lv_ontologyType_3_0 = null;

        EObject lv_thirdParty_4_0 = null;

        EObject lv_attributes_6_0 = null;

        EObject lv_attributes_8_0 = null;

        EObject lv_attributes_14_0 = null;

        EObject lv_attributes_16_0 = null;

        EObject lv_aResource_20_0 = null;

        EObject lv_attributes_22_0 = null;

        EObject lv_attributes_24_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:762:2: ( ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'isA' | otherlv_2= 'isAn' ) ( (lv_ontologyType_3_0= ruleOntologyType ) ) ( (lv_thirdParty_4_0= ruleThirdParty ) )? (otherlv_5= 'with' ( ( (lv_attributes_6_0= ruleAttribute ) ) otherlv_7= ',' )* ( (lv_attributes_8_0= ruleAttribute ) ) )? ) | ( ( (lv_name_9_0= RULE_ID ) ) (otherlv_10= 'isA' | otherlv_11= 'isAn' ) ( (otherlv_12= RULE_ID ) ) (otherlv_13= 'with' ( ( (lv_attributes_14_0= ruleAttribute ) ) otherlv_15= ',' )* ( (lv_attributes_16_0= ruleAttribute ) ) )? ) | ( ( (lv_name_17_0= RULE_ID ) ) (otherlv_18= 'isA' | otherlv_19= 'isAn' ) ( (lv_aResource_20_0= ruleAResource ) ) (otherlv_21= 'with' ( ( (lv_attributes_22_0= ruleAttribute ) ) otherlv_23= ',' )* ( (lv_attributes_24_0= ruleAttribute ) ) )? ) ) )
            // InternalSymboleo.g:763:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'isA' | otherlv_2= 'isAn' ) ( (lv_ontologyType_3_0= ruleOntologyType ) ) ( (lv_thirdParty_4_0= ruleThirdParty ) )? (otherlv_5= 'with' ( ( (lv_attributes_6_0= ruleAttribute ) ) otherlv_7= ',' )* ( (lv_attributes_8_0= ruleAttribute ) ) )? ) | ( ( (lv_name_9_0= RULE_ID ) ) (otherlv_10= 'isA' | otherlv_11= 'isAn' ) ( (otherlv_12= RULE_ID ) ) (otherlv_13= 'with' ( ( (lv_attributes_14_0= ruleAttribute ) ) otherlv_15= ',' )* ( (lv_attributes_16_0= ruleAttribute ) ) )? ) | ( ( (lv_name_17_0= RULE_ID ) ) (otherlv_18= 'isA' | otherlv_19= 'isAn' ) ( (lv_aResource_20_0= ruleAResource ) ) (otherlv_21= 'with' ( ( (lv_attributes_22_0= ruleAttribute ) ) otherlv_23= ',' )* ( (lv_attributes_24_0= ruleAttribute ) ) )? ) )
            {
            // InternalSymboleo.g:763:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'isA' | otherlv_2= 'isAn' ) ( (lv_ontologyType_3_0= ruleOntologyType ) ) ( (lv_thirdParty_4_0= ruleThirdParty ) )? (otherlv_5= 'with' ( ( (lv_attributes_6_0= ruleAttribute ) ) otherlv_7= ',' )* ( (lv_attributes_8_0= ruleAttribute ) ) )? ) | ( ( (lv_name_9_0= RULE_ID ) ) (otherlv_10= 'isA' | otherlv_11= 'isAn' ) ( (otherlv_12= RULE_ID ) ) (otherlv_13= 'with' ( ( (lv_attributes_14_0= ruleAttribute ) ) otherlv_15= ',' )* ( (lv_attributes_16_0= ruleAttribute ) ) )? ) | ( ( (lv_name_17_0= RULE_ID ) ) (otherlv_18= 'isA' | otherlv_19= 'isAn' ) ( (lv_aResource_20_0= ruleAResource ) ) (otherlv_21= 'with' ( ( (lv_attributes_22_0= ruleAttribute ) ) otherlv_23= ',' )* ( (lv_attributes_24_0= ruleAttribute ) ) )? ) )
            int alt32=3;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==RULE_ID) ) {
                int LA32_1 = input.LA(2);

                if ( (LA32_1==29) ) {
                    switch ( input.LA(3) ) {
                    case RULE_ID:
                        {
                        alt32=2;
                        }
                        break;
                    case 16:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                        {
                        alt32=1;
                        }
                        break;
                    case 44:
                        {
                        alt32=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 32, 2, input);

                        throw nvae;
                    }

                }
                else if ( (LA32_1==30) ) {
                    switch ( input.LA(3) ) {
                    case 44:
                        {
                        alt32=3;
                        }
                        break;
                    case RULE_ID:
                        {
                        alt32=2;
                        }
                        break;
                    case 16:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                        {
                        alt32=1;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 32, 3, input);

                        throw nvae;
                    }

                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 32, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // InternalSymboleo.g:764:3: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'isA' | otherlv_2= 'isAn' ) ( (lv_ontologyType_3_0= ruleOntologyType ) ) ( (lv_thirdParty_4_0= ruleThirdParty ) )? (otherlv_5= 'with' ( ( (lv_attributes_6_0= ruleAttribute ) ) otherlv_7= ',' )* ( (lv_attributes_8_0= ruleAttribute ) ) )? )
                    {
                    // InternalSymboleo.g:764:3: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'isA' | otherlv_2= 'isAn' ) ( (lv_ontologyType_3_0= ruleOntologyType ) ) ( (lv_thirdParty_4_0= ruleThirdParty ) )? (otherlv_5= 'with' ( ( (lv_attributes_6_0= ruleAttribute ) ) otherlv_7= ',' )* ( (lv_attributes_8_0= ruleAttribute ) ) )? )
                    // InternalSymboleo.g:765:4: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'isA' | otherlv_2= 'isAn' ) ( (lv_ontologyType_3_0= ruleOntologyType ) ) ( (lv_thirdParty_4_0= ruleThirdParty ) )? (otherlv_5= 'with' ( ( (lv_attributes_6_0= ruleAttribute ) ) otherlv_7= ',' )* ( (lv_attributes_8_0= ruleAttribute ) ) )?
                    {
                    // InternalSymboleo.g:765:4: ( (lv_name_0_0= RULE_ID ) )
                    // InternalSymboleo.g:766:5: (lv_name_0_0= RULE_ID )
                    {
                    // InternalSymboleo.g:766:5: (lv_name_0_0= RULE_ID )
                    // InternalSymboleo.g:767:6: lv_name_0_0= RULE_ID
                    {
                    lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_28); 

                    						newLeafNode(lv_name_0_0, grammarAccess.getRegularTypeAccess().getNameIDTerminalRuleCall_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRegularTypeRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"name",
                    							lv_name_0_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    // InternalSymboleo.g:783:4: (otherlv_1= 'isA' | otherlv_2= 'isAn' )
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==29) ) {
                        alt22=1;
                    }
                    else if ( (LA22_0==30) ) {
                        alt22=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 22, 0, input);

                        throw nvae;
                    }
                    switch (alt22) {
                        case 1 :
                            // InternalSymboleo.g:784:5: otherlv_1= 'isA'
                            {
                            otherlv_1=(Token)match(input,29,FOLLOW_29); 

                            					newLeafNode(otherlv_1, grammarAccess.getRegularTypeAccess().getIsAKeyword_0_1_0());
                            				

                            }
                            break;
                        case 2 :
                            // InternalSymboleo.g:789:5: otherlv_2= 'isAn'
                            {
                            otherlv_2=(Token)match(input,30,FOLLOW_29); 

                            					newLeafNode(otherlv_2, grammarAccess.getRegularTypeAccess().getIsAnKeyword_0_1_1());
                            				

                            }
                            break;

                    }

                    // InternalSymboleo.g:794:4: ( (lv_ontologyType_3_0= ruleOntologyType ) )
                    // InternalSymboleo.g:795:5: (lv_ontologyType_3_0= ruleOntologyType )
                    {
                    // InternalSymboleo.g:795:5: (lv_ontologyType_3_0= ruleOntologyType )
                    // InternalSymboleo.g:796:6: lv_ontologyType_3_0= ruleOntologyType
                    {

                    						newCompositeNode(grammarAccess.getRegularTypeAccess().getOntologyTypeOntologyTypeParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_30);
                    lv_ontologyType_3_0=ruleOntologyType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRegularTypeRule());
                    						}
                    						set(
                    							current,
                    							"ontologyType",
                    							lv_ontologyType_3_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.OntologyType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSymboleo.g:813:4: ( (lv_thirdParty_4_0= ruleThirdParty ) )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==57) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // InternalSymboleo.g:814:5: (lv_thirdParty_4_0= ruleThirdParty )
                            {
                            // InternalSymboleo.g:814:5: (lv_thirdParty_4_0= ruleThirdParty )
                            // InternalSymboleo.g:815:6: lv_thirdParty_4_0= ruleThirdParty
                            {

                            						newCompositeNode(grammarAccess.getRegularTypeAccess().getThirdPartyThirdPartyParserRuleCall_0_3_0());
                            					
                            pushFollow(FOLLOW_31);
                            lv_thirdParty_4_0=ruleThirdParty();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getRegularTypeRule());
                            						}
                            						set(
                            							current,
                            							"thirdParty",
                            							lv_thirdParty_4_0,
                            							"ca.uottawa.csmlab.symboleo.Symboleo.ThirdParty");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }

                    // InternalSymboleo.g:832:4: (otherlv_5= 'with' ( ( (lv_attributes_6_0= ruleAttribute ) ) otherlv_7= ',' )* ( (lv_attributes_8_0= ruleAttribute ) ) )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==32) ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // InternalSymboleo.g:833:5: otherlv_5= 'with' ( ( (lv_attributes_6_0= ruleAttribute ) ) otherlv_7= ',' )* ( (lv_attributes_8_0= ruleAttribute ) )
                            {
                            otherlv_5=(Token)match(input,32,FOLLOW_32); 

                            					newLeafNode(otherlv_5, grammarAccess.getRegularTypeAccess().getWithKeyword_0_4_0());
                            				
                            // InternalSymboleo.g:837:5: ( ( (lv_attributes_6_0= ruleAttribute ) ) otherlv_7= ',' )*
                            loop24:
                            do {
                                int alt24=2;
                                alt24 = dfa24.predict(input);
                                switch (alt24) {
                            	case 1 :
                            	    // InternalSymboleo.g:838:6: ( (lv_attributes_6_0= ruleAttribute ) ) otherlv_7= ','
                            	    {
                            	    // InternalSymboleo.g:838:6: ( (lv_attributes_6_0= ruleAttribute ) )
                            	    // InternalSymboleo.g:839:7: (lv_attributes_6_0= ruleAttribute )
                            	    {
                            	    // InternalSymboleo.g:839:7: (lv_attributes_6_0= ruleAttribute )
                            	    // InternalSymboleo.g:840:8: lv_attributes_6_0= ruleAttribute
                            	    {

                            	    								newCompositeNode(grammarAccess.getRegularTypeAccess().getAttributesAttributeParserRuleCall_0_4_1_0_0());
                            	    							
                            	    pushFollow(FOLLOW_11);
                            	    lv_attributes_6_0=ruleAttribute();

                            	    state._fsp--;


                            	    								if (current==null) {
                            	    									current = createModelElementForParent(grammarAccess.getRegularTypeRule());
                            	    								}
                            	    								add(
                            	    									current,
                            	    									"attributes",
                            	    									lv_attributes_6_0,
                            	    									"ca.uottawa.csmlab.symboleo.Symboleo.Attribute");
                            	    								afterParserOrEnumRuleCall();
                            	    							

                            	    }


                            	    }

                            	    otherlv_7=(Token)match(input,18,FOLLOW_32); 

                            	    						newLeafNode(otherlv_7, grammarAccess.getRegularTypeAccess().getCommaKeyword_0_4_1_1());
                            	    					

                            	    }
                            	    break;

                            	default :
                            	    break loop24;
                                }
                            } while (true);

                            // InternalSymboleo.g:862:5: ( (lv_attributes_8_0= ruleAttribute ) )
                            // InternalSymboleo.g:863:6: (lv_attributes_8_0= ruleAttribute )
                            {
                            // InternalSymboleo.g:863:6: (lv_attributes_8_0= ruleAttribute )
                            // InternalSymboleo.g:864:7: lv_attributes_8_0= ruleAttribute
                            {

                            							newCompositeNode(grammarAccess.getRegularTypeAccess().getAttributesAttributeParserRuleCall_0_4_2_0());
                            						
                            pushFollow(FOLLOW_2);
                            lv_attributes_8_0=ruleAttribute();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getRegularTypeRule());
                            							}
                            							add(
                            								current,
                            								"attributes",
                            								lv_attributes_8_0,
                            								"ca.uottawa.csmlab.symboleo.Symboleo.Attribute");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:884:3: ( ( (lv_name_9_0= RULE_ID ) ) (otherlv_10= 'isA' | otherlv_11= 'isAn' ) ( (otherlv_12= RULE_ID ) ) (otherlv_13= 'with' ( ( (lv_attributes_14_0= ruleAttribute ) ) otherlv_15= ',' )* ( (lv_attributes_16_0= ruleAttribute ) ) )? )
                    {
                    // InternalSymboleo.g:884:3: ( ( (lv_name_9_0= RULE_ID ) ) (otherlv_10= 'isA' | otherlv_11= 'isAn' ) ( (otherlv_12= RULE_ID ) ) (otherlv_13= 'with' ( ( (lv_attributes_14_0= ruleAttribute ) ) otherlv_15= ',' )* ( (lv_attributes_16_0= ruleAttribute ) ) )? )
                    // InternalSymboleo.g:885:4: ( (lv_name_9_0= RULE_ID ) ) (otherlv_10= 'isA' | otherlv_11= 'isAn' ) ( (otherlv_12= RULE_ID ) ) (otherlv_13= 'with' ( ( (lv_attributes_14_0= ruleAttribute ) ) otherlv_15= ',' )* ( (lv_attributes_16_0= ruleAttribute ) ) )?
                    {
                    // InternalSymboleo.g:885:4: ( (lv_name_9_0= RULE_ID ) )
                    // InternalSymboleo.g:886:5: (lv_name_9_0= RULE_ID )
                    {
                    // InternalSymboleo.g:886:5: (lv_name_9_0= RULE_ID )
                    // InternalSymboleo.g:887:6: lv_name_9_0= RULE_ID
                    {
                    lv_name_9_0=(Token)match(input,RULE_ID,FOLLOW_28); 

                    						newLeafNode(lv_name_9_0, grammarAccess.getRegularTypeAccess().getNameIDTerminalRuleCall_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRegularTypeRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"name",
                    							lv_name_9_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    // InternalSymboleo.g:903:4: (otherlv_10= 'isA' | otherlv_11= 'isAn' )
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==29) ) {
                        alt26=1;
                    }
                    else if ( (LA26_0==30) ) {
                        alt26=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 26, 0, input);

                        throw nvae;
                    }
                    switch (alt26) {
                        case 1 :
                            // InternalSymboleo.g:904:5: otherlv_10= 'isA'
                            {
                            otherlv_10=(Token)match(input,29,FOLLOW_3); 

                            					newLeafNode(otherlv_10, grammarAccess.getRegularTypeAccess().getIsAKeyword_1_1_0());
                            				

                            }
                            break;
                        case 2 :
                            // InternalSymboleo.g:909:5: otherlv_11= 'isAn'
                            {
                            otherlv_11=(Token)match(input,30,FOLLOW_3); 

                            					newLeafNode(otherlv_11, grammarAccess.getRegularTypeAccess().getIsAnKeyword_1_1_1());
                            				

                            }
                            break;

                    }

                    // InternalSymboleo.g:914:4: ( (otherlv_12= RULE_ID ) )
                    // InternalSymboleo.g:915:5: (otherlv_12= RULE_ID )
                    {
                    // InternalSymboleo.g:915:5: (otherlv_12= RULE_ID )
                    // InternalSymboleo.g:916:6: otherlv_12= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRegularTypeRule());
                    						}
                    					
                    otherlv_12=(Token)match(input,RULE_ID,FOLLOW_31); 

                    						newLeafNode(otherlv_12, grammarAccess.getRegularTypeAccess().getRegularTypeRegularTypeCrossReference_1_2_0());
                    					

                    }


                    }

                    // InternalSymboleo.g:927:4: (otherlv_13= 'with' ( ( (lv_attributes_14_0= ruleAttribute ) ) otherlv_15= ',' )* ( (lv_attributes_16_0= ruleAttribute ) ) )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==32) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // InternalSymboleo.g:928:5: otherlv_13= 'with' ( ( (lv_attributes_14_0= ruleAttribute ) ) otherlv_15= ',' )* ( (lv_attributes_16_0= ruleAttribute ) )
                            {
                            otherlv_13=(Token)match(input,32,FOLLOW_32); 

                            					newLeafNode(otherlv_13, grammarAccess.getRegularTypeAccess().getWithKeyword_1_3_0());
                            				
                            // InternalSymboleo.g:932:5: ( ( (lv_attributes_14_0= ruleAttribute ) ) otherlv_15= ',' )*
                            loop27:
                            do {
                                int alt27=2;
                                alt27 = dfa27.predict(input);
                                switch (alt27) {
                            	case 1 :
                            	    // InternalSymboleo.g:933:6: ( (lv_attributes_14_0= ruleAttribute ) ) otherlv_15= ','
                            	    {
                            	    // InternalSymboleo.g:933:6: ( (lv_attributes_14_0= ruleAttribute ) )
                            	    // InternalSymboleo.g:934:7: (lv_attributes_14_0= ruleAttribute )
                            	    {
                            	    // InternalSymboleo.g:934:7: (lv_attributes_14_0= ruleAttribute )
                            	    // InternalSymboleo.g:935:8: lv_attributes_14_0= ruleAttribute
                            	    {

                            	    								newCompositeNode(grammarAccess.getRegularTypeAccess().getAttributesAttributeParserRuleCall_1_3_1_0_0());
                            	    							
                            	    pushFollow(FOLLOW_11);
                            	    lv_attributes_14_0=ruleAttribute();

                            	    state._fsp--;


                            	    								if (current==null) {
                            	    									current = createModelElementForParent(grammarAccess.getRegularTypeRule());
                            	    								}
                            	    								add(
                            	    									current,
                            	    									"attributes",
                            	    									lv_attributes_14_0,
                            	    									"ca.uottawa.csmlab.symboleo.Symboleo.Attribute");
                            	    								afterParserOrEnumRuleCall();
                            	    							

                            	    }


                            	    }

                            	    otherlv_15=(Token)match(input,18,FOLLOW_32); 

                            	    						newLeafNode(otherlv_15, grammarAccess.getRegularTypeAccess().getCommaKeyword_1_3_1_1());
                            	    					

                            	    }
                            	    break;

                            	default :
                            	    break loop27;
                                }
                            } while (true);

                            // InternalSymboleo.g:957:5: ( (lv_attributes_16_0= ruleAttribute ) )
                            // InternalSymboleo.g:958:6: (lv_attributes_16_0= ruleAttribute )
                            {
                            // InternalSymboleo.g:958:6: (lv_attributes_16_0= ruleAttribute )
                            // InternalSymboleo.g:959:7: lv_attributes_16_0= ruleAttribute
                            {

                            							newCompositeNode(grammarAccess.getRegularTypeAccess().getAttributesAttributeParserRuleCall_1_3_2_0());
                            						
                            pushFollow(FOLLOW_2);
                            lv_attributes_16_0=ruleAttribute();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getRegularTypeRule());
                            							}
                            							add(
                            								current,
                            								"attributes",
                            								lv_attributes_16_0,
                            								"ca.uottawa.csmlab.symboleo.Symboleo.Attribute");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:979:3: ( ( (lv_name_17_0= RULE_ID ) ) (otherlv_18= 'isA' | otherlv_19= 'isAn' ) ( (lv_aResource_20_0= ruleAResource ) ) (otherlv_21= 'with' ( ( (lv_attributes_22_0= ruleAttribute ) ) otherlv_23= ',' )* ( (lv_attributes_24_0= ruleAttribute ) ) )? )
                    {
                    // InternalSymboleo.g:979:3: ( ( (lv_name_17_0= RULE_ID ) ) (otherlv_18= 'isA' | otherlv_19= 'isAn' ) ( (lv_aResource_20_0= ruleAResource ) ) (otherlv_21= 'with' ( ( (lv_attributes_22_0= ruleAttribute ) ) otherlv_23= ',' )* ( (lv_attributes_24_0= ruleAttribute ) ) )? )
                    // InternalSymboleo.g:980:4: ( (lv_name_17_0= RULE_ID ) ) (otherlv_18= 'isA' | otherlv_19= 'isAn' ) ( (lv_aResource_20_0= ruleAResource ) ) (otherlv_21= 'with' ( ( (lv_attributes_22_0= ruleAttribute ) ) otherlv_23= ',' )* ( (lv_attributes_24_0= ruleAttribute ) ) )?
                    {
                    // InternalSymboleo.g:980:4: ( (lv_name_17_0= RULE_ID ) )
                    // InternalSymboleo.g:981:5: (lv_name_17_0= RULE_ID )
                    {
                    // InternalSymboleo.g:981:5: (lv_name_17_0= RULE_ID )
                    // InternalSymboleo.g:982:6: lv_name_17_0= RULE_ID
                    {
                    lv_name_17_0=(Token)match(input,RULE_ID,FOLLOW_28); 

                    						newLeafNode(lv_name_17_0, grammarAccess.getRegularTypeAccess().getNameIDTerminalRuleCall_2_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRegularTypeRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"name",
                    							lv_name_17_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    // InternalSymboleo.g:998:4: (otherlv_18= 'isA' | otherlv_19= 'isAn' )
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==29) ) {
                        alt29=1;
                    }
                    else if ( (LA29_0==30) ) {
                        alt29=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 29, 0, input);

                        throw nvae;
                    }
                    switch (alt29) {
                        case 1 :
                            // InternalSymboleo.g:999:5: otherlv_18= 'isA'
                            {
                            otherlv_18=(Token)match(input,29,FOLLOW_33); 

                            					newLeafNode(otherlv_18, grammarAccess.getRegularTypeAccess().getIsAKeyword_2_1_0());
                            				

                            }
                            break;
                        case 2 :
                            // InternalSymboleo.g:1004:5: otherlv_19= 'isAn'
                            {
                            otherlv_19=(Token)match(input,30,FOLLOW_33); 

                            					newLeafNode(otherlv_19, grammarAccess.getRegularTypeAccess().getIsAnKeyword_2_1_1());
                            				

                            }
                            break;

                    }

                    // InternalSymboleo.g:1009:4: ( (lv_aResource_20_0= ruleAResource ) )
                    // InternalSymboleo.g:1010:5: (lv_aResource_20_0= ruleAResource )
                    {
                    // InternalSymboleo.g:1010:5: (lv_aResource_20_0= ruleAResource )
                    // InternalSymboleo.g:1011:6: lv_aResource_20_0= ruleAResource
                    {

                    						newCompositeNode(grammarAccess.getRegularTypeAccess().getAResourceAResourceParserRuleCall_2_2_0());
                    					
                    pushFollow(FOLLOW_31);
                    lv_aResource_20_0=ruleAResource();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRegularTypeRule());
                    						}
                    						set(
                    							current,
                    							"aResource",
                    							lv_aResource_20_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.AResource");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSymboleo.g:1028:4: (otherlv_21= 'with' ( ( (lv_attributes_22_0= ruleAttribute ) ) otherlv_23= ',' )* ( (lv_attributes_24_0= ruleAttribute ) ) )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==32) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // InternalSymboleo.g:1029:5: otherlv_21= 'with' ( ( (lv_attributes_22_0= ruleAttribute ) ) otherlv_23= ',' )* ( (lv_attributes_24_0= ruleAttribute ) )
                            {
                            otherlv_21=(Token)match(input,32,FOLLOW_32); 

                            					newLeafNode(otherlv_21, grammarAccess.getRegularTypeAccess().getWithKeyword_2_3_0());
                            				
                            // InternalSymboleo.g:1033:5: ( ( (lv_attributes_22_0= ruleAttribute ) ) otherlv_23= ',' )*
                            loop30:
                            do {
                                int alt30=2;
                                alt30 = dfa30.predict(input);
                                switch (alt30) {
                            	case 1 :
                            	    // InternalSymboleo.g:1034:6: ( (lv_attributes_22_0= ruleAttribute ) ) otherlv_23= ','
                            	    {
                            	    // InternalSymboleo.g:1034:6: ( (lv_attributes_22_0= ruleAttribute ) )
                            	    // InternalSymboleo.g:1035:7: (lv_attributes_22_0= ruleAttribute )
                            	    {
                            	    // InternalSymboleo.g:1035:7: (lv_attributes_22_0= ruleAttribute )
                            	    // InternalSymboleo.g:1036:8: lv_attributes_22_0= ruleAttribute
                            	    {

                            	    								newCompositeNode(grammarAccess.getRegularTypeAccess().getAttributesAttributeParserRuleCall_2_3_1_0_0());
                            	    							
                            	    pushFollow(FOLLOW_11);
                            	    lv_attributes_22_0=ruleAttribute();

                            	    state._fsp--;


                            	    								if (current==null) {
                            	    									current = createModelElementForParent(grammarAccess.getRegularTypeRule());
                            	    								}
                            	    								add(
                            	    									current,
                            	    									"attributes",
                            	    									lv_attributes_22_0,
                            	    									"ca.uottawa.csmlab.symboleo.Symboleo.Attribute");
                            	    								afterParserOrEnumRuleCall();
                            	    							

                            	    }


                            	    }

                            	    otherlv_23=(Token)match(input,18,FOLLOW_32); 

                            	    						newLeafNode(otherlv_23, grammarAccess.getRegularTypeAccess().getCommaKeyword_2_3_1_1());
                            	    					

                            	    }
                            	    break;

                            	default :
                            	    break loop30;
                                }
                            } while (true);

                            // InternalSymboleo.g:1058:5: ( (lv_attributes_24_0= ruleAttribute ) )
                            // InternalSymboleo.g:1059:6: (lv_attributes_24_0= ruleAttribute )
                            {
                            // InternalSymboleo.g:1059:6: (lv_attributes_24_0= ruleAttribute )
                            // InternalSymboleo.g:1060:7: lv_attributes_24_0= ruleAttribute
                            {

                            							newCompositeNode(grammarAccess.getRegularTypeAccess().getAttributesAttributeParserRuleCall_2_3_2_0());
                            						
                            pushFollow(FOLLOW_2);
                            lv_attributes_24_0=ruleAttribute();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getRegularTypeRule());
                            							}
                            							add(
                            								current,
                            								"attributes",
                            								lv_attributes_24_0,
                            								"ca.uottawa.csmlab.symboleo.Symboleo.Attribute");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRegularType"


    // $ANTLR start "entryRuleAttribute"
    // InternalSymboleo.g:1083:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // InternalSymboleo.g:1083:50: (iv_ruleAttribute= ruleAttribute EOF )
            // InternalSymboleo.g:1084:2: iv_ruleAttribute= ruleAttribute EOF
            {
             newCompositeNode(grammarAccess.getAttributeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttribute=ruleAttribute();

            state._fsp--;

             current =iv_ruleAttribute; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // InternalSymboleo.g:1090:1: ruleAttribute returns [EObject current=null] : ( ( ( (lv_attributeModifier_0_0= ruleAttributeModifier ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_baseType_3_0= ruleBaseType ) ) ) | ( ( (lv_attributeModifier_4_0= ruleAttributeModifier ) )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= ':' ( (otherlv_7= RULE_ID ) ) ) ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_name_5_0=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_attributeModifier_0_0 = null;

        EObject lv_baseType_3_0 = null;

        EObject lv_attributeModifier_4_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:1096:2: ( ( ( ( (lv_attributeModifier_0_0= ruleAttributeModifier ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_baseType_3_0= ruleBaseType ) ) ) | ( ( (lv_attributeModifier_4_0= ruleAttributeModifier ) )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= ':' ( (otherlv_7= RULE_ID ) ) ) ) )
            // InternalSymboleo.g:1097:2: ( ( ( (lv_attributeModifier_0_0= ruleAttributeModifier ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_baseType_3_0= ruleBaseType ) ) ) | ( ( (lv_attributeModifier_4_0= ruleAttributeModifier ) )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= ':' ( (otherlv_7= RULE_ID ) ) ) )
            {
            // InternalSymboleo.g:1097:2: ( ( ( (lv_attributeModifier_0_0= ruleAttributeModifier ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_baseType_3_0= ruleBaseType ) ) ) | ( ( (lv_attributeModifier_4_0= ruleAttributeModifier ) )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= ':' ( (otherlv_7= RULE_ID ) ) ) )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==58) ) {
                int LA35_1 = input.LA(2);

                if ( (LA35_1==RULE_ID) ) {
                    int LA35_2 = input.LA(3);

                    if ( (LA35_2==33) ) {
                        int LA35_3 = input.LA(4);

                        if ( ((LA35_3>=36 && LA35_3<=39)) ) {
                            alt35=1;
                        }
                        else if ( (LA35_3==RULE_ID) ) {
                            alt35=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 35, 3, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 35, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 35, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA35_0==RULE_ID) ) {
                int LA35_2 = input.LA(2);

                if ( (LA35_2==33) ) {
                    int LA35_3 = input.LA(3);

                    if ( ((LA35_3>=36 && LA35_3<=39)) ) {
                        alt35=1;
                    }
                    else if ( (LA35_3==RULE_ID) ) {
                        alt35=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 35, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 35, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // InternalSymboleo.g:1098:3: ( ( (lv_attributeModifier_0_0= ruleAttributeModifier ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_baseType_3_0= ruleBaseType ) ) )
                    {
                    // InternalSymboleo.g:1098:3: ( ( (lv_attributeModifier_0_0= ruleAttributeModifier ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_baseType_3_0= ruleBaseType ) ) )
                    // InternalSymboleo.g:1099:4: ( (lv_attributeModifier_0_0= ruleAttributeModifier ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_baseType_3_0= ruleBaseType ) )
                    {
                    // InternalSymboleo.g:1099:4: ( (lv_attributeModifier_0_0= ruleAttributeModifier ) )?
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( (LA33_0==58) ) {
                        alt33=1;
                    }
                    switch (alt33) {
                        case 1 :
                            // InternalSymboleo.g:1100:5: (lv_attributeModifier_0_0= ruleAttributeModifier )
                            {
                            // InternalSymboleo.g:1100:5: (lv_attributeModifier_0_0= ruleAttributeModifier )
                            // InternalSymboleo.g:1101:6: lv_attributeModifier_0_0= ruleAttributeModifier
                            {

                            						newCompositeNode(grammarAccess.getAttributeAccess().getAttributeModifierAttributeModifierParserRuleCall_0_0_0());
                            					
                            pushFollow(FOLLOW_3);
                            lv_attributeModifier_0_0=ruleAttributeModifier();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getAttributeRule());
                            						}
                            						set(
                            							current,
                            							"attributeModifier",
                            							lv_attributeModifier_0_0,
                            							"ca.uottawa.csmlab.symboleo.Symboleo.AttributeModifier");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }

                    // InternalSymboleo.g:1118:4: ( (lv_name_1_0= RULE_ID ) )
                    // InternalSymboleo.g:1119:5: (lv_name_1_0= RULE_ID )
                    {
                    // InternalSymboleo.g:1119:5: (lv_name_1_0= RULE_ID )
                    // InternalSymboleo.g:1120:6: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_34); 

                    						newLeafNode(lv_name_1_0, grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAttributeRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"name",
                    							lv_name_1_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    otherlv_2=(Token)match(input,33,FOLLOW_25); 

                    				newLeafNode(otherlv_2, grammarAccess.getAttributeAccess().getColonKeyword_0_2());
                    			
                    // InternalSymboleo.g:1140:4: ( (lv_baseType_3_0= ruleBaseType ) )
                    // InternalSymboleo.g:1141:5: (lv_baseType_3_0= ruleBaseType )
                    {
                    // InternalSymboleo.g:1141:5: (lv_baseType_3_0= ruleBaseType )
                    // InternalSymboleo.g:1142:6: lv_baseType_3_0= ruleBaseType
                    {

                    						newCompositeNode(grammarAccess.getAttributeAccess().getBaseTypeBaseTypeParserRuleCall_0_3_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_baseType_3_0=ruleBaseType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAttributeRule());
                    						}
                    						set(
                    							current,
                    							"baseType",
                    							lv_baseType_3_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.BaseType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:1161:3: ( ( (lv_attributeModifier_4_0= ruleAttributeModifier ) )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= ':' ( (otherlv_7= RULE_ID ) ) )
                    {
                    // InternalSymboleo.g:1161:3: ( ( (lv_attributeModifier_4_0= ruleAttributeModifier ) )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= ':' ( (otherlv_7= RULE_ID ) ) )
                    // InternalSymboleo.g:1162:4: ( (lv_attributeModifier_4_0= ruleAttributeModifier ) )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= ':' ( (otherlv_7= RULE_ID ) )
                    {
                    // InternalSymboleo.g:1162:4: ( (lv_attributeModifier_4_0= ruleAttributeModifier ) )?
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==58) ) {
                        alt34=1;
                    }
                    switch (alt34) {
                        case 1 :
                            // InternalSymboleo.g:1163:5: (lv_attributeModifier_4_0= ruleAttributeModifier )
                            {
                            // InternalSymboleo.g:1163:5: (lv_attributeModifier_4_0= ruleAttributeModifier )
                            // InternalSymboleo.g:1164:6: lv_attributeModifier_4_0= ruleAttributeModifier
                            {

                            						newCompositeNode(grammarAccess.getAttributeAccess().getAttributeModifierAttributeModifierParserRuleCall_1_0_0());
                            					
                            pushFollow(FOLLOW_3);
                            lv_attributeModifier_4_0=ruleAttributeModifier();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getAttributeRule());
                            						}
                            						set(
                            							current,
                            							"attributeModifier",
                            							lv_attributeModifier_4_0,
                            							"ca.uottawa.csmlab.symboleo.Symboleo.AttributeModifier");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }

                    // InternalSymboleo.g:1181:4: ( (lv_name_5_0= RULE_ID ) )
                    // InternalSymboleo.g:1182:5: (lv_name_5_0= RULE_ID )
                    {
                    // InternalSymboleo.g:1182:5: (lv_name_5_0= RULE_ID )
                    // InternalSymboleo.g:1183:6: lv_name_5_0= RULE_ID
                    {
                    lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_34); 

                    						newLeafNode(lv_name_5_0, grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAttributeRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"name",
                    							lv_name_5_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    otherlv_6=(Token)match(input,33,FOLLOW_3); 

                    				newLeafNode(otherlv_6, grammarAccess.getAttributeAccess().getColonKeyword_1_2());
                    			
                    // InternalSymboleo.g:1203:4: ( (otherlv_7= RULE_ID ) )
                    // InternalSymboleo.g:1204:5: (otherlv_7= RULE_ID )
                    {
                    // InternalSymboleo.g:1204:5: (otherlv_7= RULE_ID )
                    // InternalSymboleo.g:1205:6: otherlv_7= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAttributeRule());
                    						}
                    					
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_2); 

                    						newLeafNode(otherlv_7, grammarAccess.getAttributeAccess().getDomainTypeDomainTypeCrossReference_1_3_0());
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleOperation"
    // InternalSymboleo.g:1221:1: entryRuleOperation returns [EObject current=null] : iv_ruleOperation= ruleOperation EOF ;
    public final EObject entryRuleOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation = null;


        try {
            // InternalSymboleo.g:1221:50: (iv_ruleOperation= ruleOperation EOF )
            // InternalSymboleo.g:1222:2: iv_ruleOperation= ruleOperation EOF
            {
             newCompositeNode(grammarAccess.getOperationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOperation=ruleOperation();

            state._fsp--;

             current =iv_ruleOperation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOperation"


    // $ANTLR start "ruleOperation"
    // InternalSymboleo.g:1228:1: ruleOperation returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* )? otherlv_5= ')' otherlv_6= ':' ( (lv_returnType_7_0= ruleReturnType ) ) (otherlv_8= 'precondition' ( (lv_precondition_9_0= ruleCondition ) ) )? (otherlv_10= 'postcondition' ( (lv_postcondition_11_0= ruleCondition ) ) )? ) ;
    public final EObject ruleOperation() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_parameters_2_0 = null;

        EObject lv_parameters_4_0 = null;

        EObject lv_returnType_7_0 = null;

        EObject lv_precondition_9_0 = null;

        EObject lv_postcondition_11_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:1234:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* )? otherlv_5= ')' otherlv_6= ':' ( (lv_returnType_7_0= ruleReturnType ) ) (otherlv_8= 'precondition' ( (lv_precondition_9_0= ruleCondition ) ) )? (otherlv_10= 'postcondition' ( (lv_postcondition_11_0= ruleCondition ) ) )? ) )
            // InternalSymboleo.g:1235:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* )? otherlv_5= ')' otherlv_6= ':' ( (lv_returnType_7_0= ruleReturnType ) ) (otherlv_8= 'precondition' ( (lv_precondition_9_0= ruleCondition ) ) )? (otherlv_10= 'postcondition' ( (lv_postcondition_11_0= ruleCondition ) ) )? )
            {
            // InternalSymboleo.g:1235:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* )? otherlv_5= ')' otherlv_6= ':' ( (lv_returnType_7_0= ruleReturnType ) ) (otherlv_8= 'precondition' ( (lv_precondition_9_0= ruleCondition ) ) )? (otherlv_10= 'postcondition' ( (lv_postcondition_11_0= ruleCondition ) ) )? )
            // InternalSymboleo.g:1236:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* )? otherlv_5= ')' otherlv_6= ':' ( (lv_returnType_7_0= ruleReturnType ) ) (otherlv_8= 'precondition' ( (lv_precondition_9_0= ruleCondition ) ) )? (otherlv_10= 'postcondition' ( (lv_postcondition_11_0= ruleCondition ) ) )?
            {
            // InternalSymboleo.g:1236:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalSymboleo.g:1237:4: (lv_name_0_0= RULE_ID )
            {
            // InternalSymboleo.g:1237:4: (lv_name_0_0= RULE_ID )
            // InternalSymboleo.g:1238:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_0_0, grammarAccess.getOperationAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOperationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,17,FOLLOW_35); 

            			newLeafNode(otherlv_1, grammarAccess.getOperationAccess().getLeftParenthesisKeyword_1());
            		
            // InternalSymboleo.g:1258:3: ( ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )* )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==RULE_ID) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalSymboleo.g:1259:4: ( (lv_parameters_2_0= ruleParameter ) ) (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )*
                    {
                    // InternalSymboleo.g:1259:4: ( (lv_parameters_2_0= ruleParameter ) )
                    // InternalSymboleo.g:1260:5: (lv_parameters_2_0= ruleParameter )
                    {
                    // InternalSymboleo.g:1260:5: (lv_parameters_2_0= ruleParameter )
                    // InternalSymboleo.g:1261:6: lv_parameters_2_0= ruleParameter
                    {

                    						newCompositeNode(grammarAccess.getOperationAccess().getParametersParameterParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_36);
                    lv_parameters_2_0=ruleParameter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getOperationRule());
                    						}
                    						add(
                    							current,
                    							"parameters",
                    							lv_parameters_2_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Parameter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSymboleo.g:1278:4: (otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) ) )*
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( (LA36_0==18) ) {
                            alt36=1;
                        }


                        switch (alt36) {
                    	case 1 :
                    	    // InternalSymboleo.g:1279:5: otherlv_3= ',' ( (lv_parameters_4_0= ruleParameter ) )
                    	    {
                    	    otherlv_3=(Token)match(input,18,FOLLOW_3); 

                    	    					newLeafNode(otherlv_3, grammarAccess.getOperationAccess().getCommaKeyword_2_1_0());
                    	    				
                    	    // InternalSymboleo.g:1283:5: ( (lv_parameters_4_0= ruleParameter ) )
                    	    // InternalSymboleo.g:1284:6: (lv_parameters_4_0= ruleParameter )
                    	    {
                    	    // InternalSymboleo.g:1284:6: (lv_parameters_4_0= ruleParameter )
                    	    // InternalSymboleo.g:1285:7: lv_parameters_4_0= ruleParameter
                    	    {

                    	    							newCompositeNode(grammarAccess.getOperationAccess().getParametersParameterParserRuleCall_2_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_36);
                    	    lv_parameters_4_0=ruleParameter();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getOperationRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"parameters",
                    	    								lv_parameters_4_0,
                    	    								"ca.uottawa.csmlab.symboleo.Symboleo.Parameter");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop36;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,19,FOLLOW_34); 

            			newLeafNode(otherlv_5, grammarAccess.getOperationAccess().getRightParenthesisKeyword_3());
            		
            otherlv_6=(Token)match(input,33,FOLLOW_37); 

            			newLeafNode(otherlv_6, grammarAccess.getOperationAccess().getColonKeyword_4());
            		
            // InternalSymboleo.g:1312:3: ( (lv_returnType_7_0= ruleReturnType ) )
            // InternalSymboleo.g:1313:4: (lv_returnType_7_0= ruleReturnType )
            {
            // InternalSymboleo.g:1313:4: (lv_returnType_7_0= ruleReturnType )
            // InternalSymboleo.g:1314:5: lv_returnType_7_0= ruleReturnType
            {

            					newCompositeNode(grammarAccess.getOperationAccess().getReturnTypeReturnTypeParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_38);
            lv_returnType_7_0=ruleReturnType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOperationRule());
            					}
            					set(
            						current,
            						"returnType",
            						lv_returnType_7_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.ReturnType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSymboleo.g:1331:3: (otherlv_8= 'precondition' ( (lv_precondition_9_0= ruleCondition ) ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==34) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalSymboleo.g:1332:4: otherlv_8= 'precondition' ( (lv_precondition_9_0= ruleCondition ) )
                    {
                    otherlv_8=(Token)match(input,34,FOLLOW_39); 

                    				newLeafNode(otherlv_8, grammarAccess.getOperationAccess().getPreconditionKeyword_6_0());
                    			
                    // InternalSymboleo.g:1336:4: ( (lv_precondition_9_0= ruleCondition ) )
                    // InternalSymboleo.g:1337:5: (lv_precondition_9_0= ruleCondition )
                    {
                    // InternalSymboleo.g:1337:5: (lv_precondition_9_0= ruleCondition )
                    // InternalSymboleo.g:1338:6: lv_precondition_9_0= ruleCondition
                    {

                    						newCompositeNode(grammarAccess.getOperationAccess().getPreconditionConditionParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_40);
                    lv_precondition_9_0=ruleCondition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getOperationRule());
                    						}
                    						set(
                    							current,
                    							"precondition",
                    							lv_precondition_9_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Condition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalSymboleo.g:1356:3: (otherlv_10= 'postcondition' ( (lv_postcondition_11_0= ruleCondition ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==35) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalSymboleo.g:1357:4: otherlv_10= 'postcondition' ( (lv_postcondition_11_0= ruleCondition ) )
                    {
                    otherlv_10=(Token)match(input,35,FOLLOW_39); 

                    				newLeafNode(otherlv_10, grammarAccess.getOperationAccess().getPostconditionKeyword_7_0());
                    			
                    // InternalSymboleo.g:1361:4: ( (lv_postcondition_11_0= ruleCondition ) )
                    // InternalSymboleo.g:1362:5: (lv_postcondition_11_0= ruleCondition )
                    {
                    // InternalSymboleo.g:1362:5: (lv_postcondition_11_0= ruleCondition )
                    // InternalSymboleo.g:1363:6: lv_postcondition_11_0= ruleCondition
                    {

                    						newCompositeNode(grammarAccess.getOperationAccess().getPostconditionConditionParserRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_postcondition_11_0=ruleCondition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getOperationRule());
                    						}
                    						set(
                    							current,
                    							"postcondition",
                    							lv_postcondition_11_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Condition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOperation"


    // $ANTLR start "entryRuleReturnType"
    // InternalSymboleo.g:1385:1: entryRuleReturnType returns [EObject current=null] : iv_ruleReturnType= ruleReturnType EOF ;
    public final EObject entryRuleReturnType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReturnType = null;


        try {
            // InternalSymboleo.g:1385:51: (iv_ruleReturnType= ruleReturnType EOF )
            // InternalSymboleo.g:1386:2: iv_ruleReturnType= ruleReturnType EOF
            {
             newCompositeNode(grammarAccess.getReturnTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleReturnType=ruleReturnType();

            state._fsp--;

             current =iv_ruleReturnType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReturnType"


    // $ANTLR start "ruleReturnType"
    // InternalSymboleo.g:1392:1: ruleReturnType returns [EObject current=null] : ( (lv_type_0_0= ruleParameterType ) ) ;
    public final EObject ruleReturnType() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:1398:2: ( ( (lv_type_0_0= ruleParameterType ) ) )
            // InternalSymboleo.g:1399:2: ( (lv_type_0_0= ruleParameterType ) )
            {
            // InternalSymboleo.g:1399:2: ( (lv_type_0_0= ruleParameterType ) )
            // InternalSymboleo.g:1400:3: (lv_type_0_0= ruleParameterType )
            {
            // InternalSymboleo.g:1400:3: (lv_type_0_0= ruleParameterType )
            // InternalSymboleo.g:1401:4: lv_type_0_0= ruleParameterType
            {

            				newCompositeNode(grammarAccess.getReturnTypeAccess().getTypeParameterTypeParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_type_0_0=ruleParameterType();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getReturnTypeRule());
            				}
            				set(
            					current,
            					"type",
            					lv_type_0_0,
            					"ca.uottawa.csmlab.symboleo.Symboleo.ParameterType");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReturnType"


    // $ANTLR start "entryRuleCondition"
    // InternalSymboleo.g:1421:1: entryRuleCondition returns [EObject current=null] : iv_ruleCondition= ruleCondition EOF ;
    public final EObject entryRuleCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCondition = null;


        try {
            // InternalSymboleo.g:1421:50: (iv_ruleCondition= ruleCondition EOF )
            // InternalSymboleo.g:1422:2: iv_ruleCondition= ruleCondition EOF
            {
             newCompositeNode(grammarAccess.getConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCondition=ruleCondition();

            state._fsp--;

             current =iv_ruleCondition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCondition"


    // $ANTLR start "ruleCondition"
    // InternalSymboleo.g:1428:1: ruleCondition returns [EObject current=null] : ( () ( (lv_condition_1_0= ruleExpression ) ) ) ;
    public final EObject ruleCondition() throws RecognitionException {
        EObject current = null;

        EObject lv_condition_1_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:1434:2: ( ( () ( (lv_condition_1_0= ruleExpression ) ) ) )
            // InternalSymboleo.g:1435:2: ( () ( (lv_condition_1_0= ruleExpression ) ) )
            {
            // InternalSymboleo.g:1435:2: ( () ( (lv_condition_1_0= ruleExpression ) ) )
            // InternalSymboleo.g:1436:3: () ( (lv_condition_1_0= ruleExpression ) )
            {
            // InternalSymboleo.g:1436:3: ()
            // InternalSymboleo.g:1437:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getConditionAccess().getConditionAction_0(),
            					current);
            			

            }

            // InternalSymboleo.g:1443:3: ( (lv_condition_1_0= ruleExpression ) )
            // InternalSymboleo.g:1444:4: (lv_condition_1_0= ruleExpression )
            {
            // InternalSymboleo.g:1444:4: (lv_condition_1_0= ruleExpression )
            // InternalSymboleo.g:1445:5: lv_condition_1_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getConditionAccess().getConditionExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_condition_1_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConditionRule());
            					}
            					set(
            						current,
            						"condition",
            						lv_condition_1_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCondition"


    // $ANTLR start "entryRuleBaseType"
    // InternalSymboleo.g:1466:1: entryRuleBaseType returns [EObject current=null] : iv_ruleBaseType= ruleBaseType EOF ;
    public final EObject entryRuleBaseType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBaseType = null;


        try {
            // InternalSymboleo.g:1466:49: (iv_ruleBaseType= ruleBaseType EOF )
            // InternalSymboleo.g:1467:2: iv_ruleBaseType= ruleBaseType EOF
            {
             newCompositeNode(grammarAccess.getBaseTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBaseType=ruleBaseType();

            state._fsp--;

             current =iv_ruleBaseType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBaseType"


    // $ANTLR start "ruleBaseType"
    // InternalSymboleo.g:1473:1: ruleBaseType returns [EObject current=null] : ( ( (lv_name_0_1= 'Number' | lv_name_0_2= 'String' | lv_name_0_3= 'Date' | lv_name_0_4= 'Boolean' ) ) ) ;
    public final EObject ruleBaseType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;
        Token lv_name_0_3=null;
        Token lv_name_0_4=null;


        	enterRule();

        try {
            // InternalSymboleo.g:1479:2: ( ( ( (lv_name_0_1= 'Number' | lv_name_0_2= 'String' | lv_name_0_3= 'Date' | lv_name_0_4= 'Boolean' ) ) ) )
            // InternalSymboleo.g:1480:2: ( ( (lv_name_0_1= 'Number' | lv_name_0_2= 'String' | lv_name_0_3= 'Date' | lv_name_0_4= 'Boolean' ) ) )
            {
            // InternalSymboleo.g:1480:2: ( ( (lv_name_0_1= 'Number' | lv_name_0_2= 'String' | lv_name_0_3= 'Date' | lv_name_0_4= 'Boolean' ) ) )
            // InternalSymboleo.g:1481:3: ( (lv_name_0_1= 'Number' | lv_name_0_2= 'String' | lv_name_0_3= 'Date' | lv_name_0_4= 'Boolean' ) )
            {
            // InternalSymboleo.g:1481:3: ( (lv_name_0_1= 'Number' | lv_name_0_2= 'String' | lv_name_0_3= 'Date' | lv_name_0_4= 'Boolean' ) )
            // InternalSymboleo.g:1482:4: (lv_name_0_1= 'Number' | lv_name_0_2= 'String' | lv_name_0_3= 'Date' | lv_name_0_4= 'Boolean' )
            {
            // InternalSymboleo.g:1482:4: (lv_name_0_1= 'Number' | lv_name_0_2= 'String' | lv_name_0_3= 'Date' | lv_name_0_4= 'Boolean' )
            int alt40=4;
            switch ( input.LA(1) ) {
            case 36:
                {
                alt40=1;
                }
                break;
            case 37:
                {
                alt40=2;
                }
                break;
            case 38:
                {
                alt40=3;
                }
                break;
            case 39:
                {
                alt40=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // InternalSymboleo.g:1483:5: lv_name_0_1= 'Number'
                    {
                    lv_name_0_1=(Token)match(input,36,FOLLOW_2); 

                    					newLeafNode(lv_name_0_1, grammarAccess.getBaseTypeAccess().getNameNumberKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBaseTypeRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:1494:5: lv_name_0_2= 'String'
                    {
                    lv_name_0_2=(Token)match(input,37,FOLLOW_2); 

                    					newLeafNode(lv_name_0_2, grammarAccess.getBaseTypeAccess().getNameStringKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBaseTypeRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_2, null);
                    				

                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:1505:5: lv_name_0_3= 'Date'
                    {
                    lv_name_0_3=(Token)match(input,38,FOLLOW_2); 

                    					newLeafNode(lv_name_0_3, grammarAccess.getBaseTypeAccess().getNameDateKeyword_0_2());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBaseTypeRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_3, null);
                    				

                    }
                    break;
                case 4 :
                    // InternalSymboleo.g:1516:5: lv_name_0_4= 'Boolean'
                    {
                    lv_name_0_4=(Token)match(input,39,FOLLOW_2); 

                    					newLeafNode(lv_name_0_4, grammarAccess.getBaseTypeAccess().getNameBooleanKeyword_0_3());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBaseTypeRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_4, null);
                    				

                    }
                    break;

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBaseType"


    // $ANTLR start "entryRuleOntologyType"
    // InternalSymboleo.g:1532:1: entryRuleOntologyType returns [EObject current=null] : iv_ruleOntologyType= ruleOntologyType EOF ;
    public final EObject entryRuleOntologyType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOntologyType = null;


        try {
            // InternalSymboleo.g:1532:53: (iv_ruleOntologyType= ruleOntologyType EOF )
            // InternalSymboleo.g:1533:2: iv_ruleOntologyType= ruleOntologyType EOF
            {
             newCompositeNode(grammarAccess.getOntologyTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOntologyType=ruleOntologyType();

            state._fsp--;

             current =iv_ruleOntologyType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOntologyType"


    // $ANTLR start "ruleOntologyType"
    // InternalSymboleo.g:1539:1: ruleOntologyType returns [EObject current=null] : ( ( (lv_name_0_1= 'Asset' | lv_name_0_2= 'Event' | lv_name_0_3= 'Role' | lv_name_0_4= 'Contract' | lv_name_0_5= 'DataTransfer' ) ) ) ;
    public final EObject ruleOntologyType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;
        Token lv_name_0_3=null;
        Token lv_name_0_4=null;
        Token lv_name_0_5=null;


        	enterRule();

        try {
            // InternalSymboleo.g:1545:2: ( ( ( (lv_name_0_1= 'Asset' | lv_name_0_2= 'Event' | lv_name_0_3= 'Role' | lv_name_0_4= 'Contract' | lv_name_0_5= 'DataTransfer' ) ) ) )
            // InternalSymboleo.g:1546:2: ( ( (lv_name_0_1= 'Asset' | lv_name_0_2= 'Event' | lv_name_0_3= 'Role' | lv_name_0_4= 'Contract' | lv_name_0_5= 'DataTransfer' ) ) )
            {
            // InternalSymboleo.g:1546:2: ( ( (lv_name_0_1= 'Asset' | lv_name_0_2= 'Event' | lv_name_0_3= 'Role' | lv_name_0_4= 'Contract' | lv_name_0_5= 'DataTransfer' ) ) )
            // InternalSymboleo.g:1547:3: ( (lv_name_0_1= 'Asset' | lv_name_0_2= 'Event' | lv_name_0_3= 'Role' | lv_name_0_4= 'Contract' | lv_name_0_5= 'DataTransfer' ) )
            {
            // InternalSymboleo.g:1547:3: ( (lv_name_0_1= 'Asset' | lv_name_0_2= 'Event' | lv_name_0_3= 'Role' | lv_name_0_4= 'Contract' | lv_name_0_5= 'DataTransfer' ) )
            // InternalSymboleo.g:1548:4: (lv_name_0_1= 'Asset' | lv_name_0_2= 'Event' | lv_name_0_3= 'Role' | lv_name_0_4= 'Contract' | lv_name_0_5= 'DataTransfer' )
            {
            // InternalSymboleo.g:1548:4: (lv_name_0_1= 'Asset' | lv_name_0_2= 'Event' | lv_name_0_3= 'Role' | lv_name_0_4= 'Contract' | lv_name_0_5= 'DataTransfer' )
            int alt41=5;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt41=1;
                }
                break;
            case 41:
                {
                alt41=2;
                }
                break;
            case 42:
                {
                alt41=3;
                }
                break;
            case 16:
                {
                alt41=4;
                }
                break;
            case 43:
                {
                alt41=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // InternalSymboleo.g:1549:5: lv_name_0_1= 'Asset'
                    {
                    lv_name_0_1=(Token)match(input,40,FOLLOW_2); 

                    					newLeafNode(lv_name_0_1, grammarAccess.getOntologyTypeAccess().getNameAssetKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOntologyTypeRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:1560:5: lv_name_0_2= 'Event'
                    {
                    lv_name_0_2=(Token)match(input,41,FOLLOW_2); 

                    					newLeafNode(lv_name_0_2, grammarAccess.getOntologyTypeAccess().getNameEventKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOntologyTypeRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_2, null);
                    				

                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:1571:5: lv_name_0_3= 'Role'
                    {
                    lv_name_0_3=(Token)match(input,42,FOLLOW_2); 

                    					newLeafNode(lv_name_0_3, grammarAccess.getOntologyTypeAccess().getNameRoleKeyword_0_2());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOntologyTypeRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_3, null);
                    				

                    }
                    break;
                case 4 :
                    // InternalSymboleo.g:1582:5: lv_name_0_4= 'Contract'
                    {
                    lv_name_0_4=(Token)match(input,16,FOLLOW_2); 

                    					newLeafNode(lv_name_0_4, grammarAccess.getOntologyTypeAccess().getNameContractKeyword_0_3());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOntologyTypeRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_4, null);
                    				

                    }
                    break;
                case 5 :
                    // InternalSymboleo.g:1593:5: lv_name_0_5= 'DataTransfer'
                    {
                    lv_name_0_5=(Token)match(input,43,FOLLOW_2); 

                    					newLeafNode(lv_name_0_5, grammarAccess.getOntologyTypeAccess().getNameDataTransferKeyword_0_4());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOntologyTypeRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_5, null);
                    				

                    }
                    break;

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOntologyType"


    // $ANTLR start "entryRuleAResource"
    // InternalSymboleo.g:1609:1: entryRuleAResource returns [EObject current=null] : iv_ruleAResource= ruleAResource EOF ;
    public final EObject entryRuleAResource() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAResource = null;


        try {
            // InternalSymboleo.g:1609:50: (iv_ruleAResource= ruleAResource EOF )
            // InternalSymboleo.g:1610:2: iv_ruleAResource= ruleAResource EOF
            {
             newCompositeNode(grammarAccess.getAResourceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAResource=ruleAResource();

            state._fsp--;

             current =iv_ruleAResource; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAResource"


    // $ANTLR start "ruleAResource"
    // InternalSymboleo.g:1616:1: ruleAResource returns [EObject current=null] : ( (lv_name_0_0= 'Resource' ) ) ;
    public final EObject ruleAResource() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalSymboleo.g:1622:2: ( ( (lv_name_0_0= 'Resource' ) ) )
            // InternalSymboleo.g:1623:2: ( (lv_name_0_0= 'Resource' ) )
            {
            // InternalSymboleo.g:1623:2: ( (lv_name_0_0= 'Resource' ) )
            // InternalSymboleo.g:1624:3: (lv_name_0_0= 'Resource' )
            {
            // InternalSymboleo.g:1624:3: (lv_name_0_0= 'Resource' )
            // InternalSymboleo.g:1625:4: lv_name_0_0= 'Resource'
            {
            lv_name_0_0=(Token)match(input,44,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getAResourceAccess().getNameResourceKeyword_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getAResourceRule());
            				}
            				setWithLastConsumed(current, "name", lv_name_0_0, "Resource");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAResource"


    // $ANTLR start "entryRuleACPolicy"
    // InternalSymboleo.g:1640:1: entryRuleACPolicy returns [EObject current=null] : iv_ruleACPolicy= ruleACPolicy EOF ;
    public final EObject entryRuleACPolicy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleACPolicy = null;


        try {
            // InternalSymboleo.g:1640:49: (iv_ruleACPolicy= ruleACPolicy EOF )
            // InternalSymboleo.g:1641:2: iv_ruleACPolicy= ruleACPolicy EOF
            {
             newCompositeNode(grammarAccess.getACPolicyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleACPolicy=ruleACPolicy();

            state._fsp--;

             current =iv_ruleACPolicy; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleACPolicy"


    // $ANTLR start "ruleACPolicy"
    // InternalSymboleo.g:1647:1: ruleACPolicy returns [EObject current=null] : (otherlv_0= 'with' otherlv_1= 'Controller' ( ( (lv_controller_2_0= ruleController ) ) otherlv_3= ',' )* ( (lv_controller_4_0= ruleController ) ) ) ;
    public final EObject ruleACPolicy() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_controller_2_0 = null;

        EObject lv_controller_4_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:1653:2: ( (otherlv_0= 'with' otherlv_1= 'Controller' ( ( (lv_controller_2_0= ruleController ) ) otherlv_3= ',' )* ( (lv_controller_4_0= ruleController ) ) ) )
            // InternalSymboleo.g:1654:2: (otherlv_0= 'with' otherlv_1= 'Controller' ( ( (lv_controller_2_0= ruleController ) ) otherlv_3= ',' )* ( (lv_controller_4_0= ruleController ) ) )
            {
            // InternalSymboleo.g:1654:2: (otherlv_0= 'with' otherlv_1= 'Controller' ( ( (lv_controller_2_0= ruleController ) ) otherlv_3= ',' )* ( (lv_controller_4_0= ruleController ) ) )
            // InternalSymboleo.g:1655:3: otherlv_0= 'with' otherlv_1= 'Controller' ( ( (lv_controller_2_0= ruleController ) ) otherlv_3= ',' )* ( (lv_controller_4_0= ruleController ) )
            {
            otherlv_0=(Token)match(input,32,FOLLOW_41); 

            			newLeafNode(otherlv_0, grammarAccess.getACPolicyAccess().getWithKeyword_0());
            		
            otherlv_1=(Token)match(input,45,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getACPolicyAccess().getControllerKeyword_1());
            		
            // InternalSymboleo.g:1663:3: ( ( (lv_controller_2_0= ruleController ) ) otherlv_3= ',' )*
            loop42:
            do {
                int alt42=2;
                alt42 = dfa42.predict(input);
                switch (alt42) {
            	case 1 :
            	    // InternalSymboleo.g:1664:4: ( (lv_controller_2_0= ruleController ) ) otherlv_3= ','
            	    {
            	    // InternalSymboleo.g:1664:4: ( (lv_controller_2_0= ruleController ) )
            	    // InternalSymboleo.g:1665:5: (lv_controller_2_0= ruleController )
            	    {
            	    // InternalSymboleo.g:1665:5: (lv_controller_2_0= ruleController )
            	    // InternalSymboleo.g:1666:6: lv_controller_2_0= ruleController
            	    {

            	    						newCompositeNode(grammarAccess.getACPolicyAccess().getControllerControllerParserRuleCall_2_0_0());
            	    					
            	    pushFollow(FOLLOW_11);
            	    lv_controller_2_0=ruleController();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getACPolicyRule());
            	    						}
            	    						add(
            	    							current,
            	    							"controller",
            	    							lv_controller_2_0,
            	    							"ca.uottawa.csmlab.symboleo.Symboleo.Controller");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    otherlv_3=(Token)match(input,18,FOLLOW_3); 

            	    				newLeafNode(otherlv_3, grammarAccess.getACPolicyAccess().getCommaKeyword_2_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

            // InternalSymboleo.g:1688:3: ( (lv_controller_4_0= ruleController ) )
            // InternalSymboleo.g:1689:4: (lv_controller_4_0= ruleController )
            {
            // InternalSymboleo.g:1689:4: (lv_controller_4_0= ruleController )
            // InternalSymboleo.g:1690:5: lv_controller_4_0= ruleController
            {

            					newCompositeNode(grammarAccess.getACPolicyAccess().getControllerControllerParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_controller_4_0=ruleController();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getACPolicyRule());
            					}
            					add(
            						current,
            						"controller",
            						lv_controller_4_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.Controller");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleACPolicy"


    // $ANTLR start "entryRuleController"
    // InternalSymboleo.g:1711:1: entryRuleController returns [EObject current=null] : iv_ruleController= ruleController EOF ;
    public final EObject entryRuleController() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleController = null;


        try {
            // InternalSymboleo.g:1711:51: (iv_ruleController= ruleController EOF )
            // InternalSymboleo.g:1712:2: iv_ruleController= ruleController EOF
            {
             newCompositeNode(grammarAccess.getControllerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleController=ruleController();

            state._fsp--;

             current =iv_ruleController; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleController"


    // $ANTLR start "ruleController"
    // InternalSymboleo.g:1718:1: ruleController returns [EObject current=null] : ( (lv_controllerType_0_0= ruleVariableDotExpression ) ) ;
    public final EObject ruleController() throws RecognitionException {
        EObject current = null;

        EObject lv_controllerType_0_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:1724:2: ( ( (lv_controllerType_0_0= ruleVariableDotExpression ) ) )
            // InternalSymboleo.g:1725:2: ( (lv_controllerType_0_0= ruleVariableDotExpression ) )
            {
            // InternalSymboleo.g:1725:2: ( (lv_controllerType_0_0= ruleVariableDotExpression ) )
            // InternalSymboleo.g:1726:3: (lv_controllerType_0_0= ruleVariableDotExpression )
            {
            // InternalSymboleo.g:1726:3: (lv_controllerType_0_0= ruleVariableDotExpression )
            // InternalSymboleo.g:1727:4: lv_controllerType_0_0= ruleVariableDotExpression
            {

            				newCompositeNode(grammarAccess.getControllerAccess().getControllerTypeVariableDotExpressionParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_controllerType_0_0=ruleVariableDotExpression();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getControllerRule());
            				}
            				set(
            					current,
            					"controllerType",
            					lv_controllerType_0_0,
            					"ca.uottawa.csmlab.symboleo.Symboleo.VariableDotExpression");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleController"


    // $ANTLR start "entryRuleRule"
    // InternalSymboleo.g:1747:1: entryRuleRule returns [EObject current=null] : iv_ruleRule= ruleRule EOF ;
    public final EObject entryRuleRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRule = null;


        try {
            // InternalSymboleo.g:1747:45: (iv_ruleRule= ruleRule EOF )
            // InternalSymboleo.g:1748:2: iv_ruleRule= ruleRule EOF
            {
             newCompositeNode(grammarAccess.getRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRule=ruleRule();

            state._fsp--;

             current =iv_ruleRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRule"


    // $ANTLR start "ruleRule"
    // InternalSymboleo.g:1754:1: ruleRule returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( ( (lv_action_2_1= 'Grant' | lv_action_2_2= 'Revoke' ) ) ) ( (lv_permission_3_0= rulePermission ) ) otherlv_4= 'To' ( (lv_accessedRole_5_0= ruleVariableDotExpression ) ) otherlv_6= 'On' ( (lv_accessedResource_7_0= ruleResource ) ) otherlv_8= 'by' ( (lv_controller_9_0= ruleVariableDotExpression ) ) ) ) ;
    public final EObject ruleRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_action_2_1=null;
        Token lv_action_2_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_permission_3_0 = null;

        EObject lv_accessedRole_5_0 = null;

        EObject lv_accessedResource_7_0 = null;

        EObject lv_controller_9_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:1760:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( ( (lv_action_2_1= 'Grant' | lv_action_2_2= 'Revoke' ) ) ) ( (lv_permission_3_0= rulePermission ) ) otherlv_4= 'To' ( (lv_accessedRole_5_0= ruleVariableDotExpression ) ) otherlv_6= 'On' ( (lv_accessedResource_7_0= ruleResource ) ) otherlv_8= 'by' ( (lv_controller_9_0= ruleVariableDotExpression ) ) ) ) )
            // InternalSymboleo.g:1761:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( ( (lv_action_2_1= 'Grant' | lv_action_2_2= 'Revoke' ) ) ) ( (lv_permission_3_0= rulePermission ) ) otherlv_4= 'To' ( (lv_accessedRole_5_0= ruleVariableDotExpression ) ) otherlv_6= 'On' ( (lv_accessedResource_7_0= ruleResource ) ) otherlv_8= 'by' ( (lv_controller_9_0= ruleVariableDotExpression ) ) ) )
            {
            // InternalSymboleo.g:1761:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( ( (lv_action_2_1= 'Grant' | lv_action_2_2= 'Revoke' ) ) ) ( (lv_permission_3_0= rulePermission ) ) otherlv_4= 'To' ( (lv_accessedRole_5_0= ruleVariableDotExpression ) ) otherlv_6= 'On' ( (lv_accessedResource_7_0= ruleResource ) ) otherlv_8= 'by' ( (lv_controller_9_0= ruleVariableDotExpression ) ) ) )
            // InternalSymboleo.g:1762:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( ( (lv_action_2_1= 'Grant' | lv_action_2_2= 'Revoke' ) ) ) ( (lv_permission_3_0= rulePermission ) ) otherlv_4= 'To' ( (lv_accessedRole_5_0= ruleVariableDotExpression ) ) otherlv_6= 'On' ( (lv_accessedResource_7_0= ruleResource ) ) otherlv_8= 'by' ( (lv_controller_9_0= ruleVariableDotExpression ) ) )
            {
            // InternalSymboleo.g:1762:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalSymboleo.g:1763:4: (lv_name_0_0= RULE_ID )
            {
            // InternalSymboleo.g:1763:4: (lv_name_0_0= RULE_ID )
            // InternalSymboleo.g:1764:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_34); 

            					newLeafNode(lv_name_0_0, grammarAccess.getRuleAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRuleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,33,FOLLOW_42); 

            			newLeafNode(otherlv_1, grammarAccess.getRuleAccess().getColonKeyword_1());
            		
            // InternalSymboleo.g:1784:3: ( ( ( (lv_action_2_1= 'Grant' | lv_action_2_2= 'Revoke' ) ) ) ( (lv_permission_3_0= rulePermission ) ) otherlv_4= 'To' ( (lv_accessedRole_5_0= ruleVariableDotExpression ) ) otherlv_6= 'On' ( (lv_accessedResource_7_0= ruleResource ) ) otherlv_8= 'by' ( (lv_controller_9_0= ruleVariableDotExpression ) ) )
            // InternalSymboleo.g:1785:4: ( ( (lv_action_2_1= 'Grant' | lv_action_2_2= 'Revoke' ) ) ) ( (lv_permission_3_0= rulePermission ) ) otherlv_4= 'To' ( (lv_accessedRole_5_0= ruleVariableDotExpression ) ) otherlv_6= 'On' ( (lv_accessedResource_7_0= ruleResource ) ) otherlv_8= 'by' ( (lv_controller_9_0= ruleVariableDotExpression ) )
            {
            // InternalSymboleo.g:1785:4: ( ( (lv_action_2_1= 'Grant' | lv_action_2_2= 'Revoke' ) ) )
            // InternalSymboleo.g:1786:5: ( (lv_action_2_1= 'Grant' | lv_action_2_2= 'Revoke' ) )
            {
            // InternalSymboleo.g:1786:5: ( (lv_action_2_1= 'Grant' | lv_action_2_2= 'Revoke' ) )
            // InternalSymboleo.g:1787:6: (lv_action_2_1= 'Grant' | lv_action_2_2= 'Revoke' )
            {
            // InternalSymboleo.g:1787:6: (lv_action_2_1= 'Grant' | lv_action_2_2= 'Revoke' )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==46) ) {
                alt43=1;
            }
            else if ( (LA43_0==47) ) {
                alt43=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // InternalSymboleo.g:1788:7: lv_action_2_1= 'Grant'
                    {
                    lv_action_2_1=(Token)match(input,46,FOLLOW_43); 

                    							newLeafNode(lv_action_2_1, grammarAccess.getRuleAccess().getActionGrantKeyword_2_0_0_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getRuleRule());
                    							}
                    							setWithLastConsumed(current, "action", lv_action_2_1, null);
                    						

                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:1799:7: lv_action_2_2= 'Revoke'
                    {
                    lv_action_2_2=(Token)match(input,47,FOLLOW_43); 

                    							newLeafNode(lv_action_2_2, grammarAccess.getRuleAccess().getActionRevokeKeyword_2_0_0_1());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getRuleRule());
                    							}
                    							setWithLastConsumed(current, "action", lv_action_2_2, null);
                    						

                    }
                    break;

            }


            }


            }

            // InternalSymboleo.g:1812:4: ( (lv_permission_3_0= rulePermission ) )
            // InternalSymboleo.g:1813:5: (lv_permission_3_0= rulePermission )
            {
            // InternalSymboleo.g:1813:5: (lv_permission_3_0= rulePermission )
            // InternalSymboleo.g:1814:6: lv_permission_3_0= rulePermission
            {

            						newCompositeNode(grammarAccess.getRuleAccess().getPermissionPermissionParserRuleCall_2_1_0());
            					
            pushFollow(FOLLOW_44);
            lv_permission_3_0=rulePermission();

            state._fsp--;


            						if (current==null) {
            							current = createModelElementForParent(grammarAccess.getRuleRule());
            						}
            						set(
            							current,
            							"permission",
            							lv_permission_3_0,
            							"ca.uottawa.csmlab.symboleo.Symboleo.Permission");
            						afterParserOrEnumRuleCall();
            					

            }


            }

            otherlv_4=(Token)match(input,48,FOLLOW_3); 

            				newLeafNode(otherlv_4, grammarAccess.getRuleAccess().getToKeyword_2_2());
            			
            // InternalSymboleo.g:1835:4: ( (lv_accessedRole_5_0= ruleVariableDotExpression ) )
            // InternalSymboleo.g:1836:5: (lv_accessedRole_5_0= ruleVariableDotExpression )
            {
            // InternalSymboleo.g:1836:5: (lv_accessedRole_5_0= ruleVariableDotExpression )
            // InternalSymboleo.g:1837:6: lv_accessedRole_5_0= ruleVariableDotExpression
            {

            						newCompositeNode(grammarAccess.getRuleAccess().getAccessedRoleVariableDotExpressionParserRuleCall_2_3_0());
            					
            pushFollow(FOLLOW_45);
            lv_accessedRole_5_0=ruleVariableDotExpression();

            state._fsp--;


            						if (current==null) {
            							current = createModelElementForParent(grammarAccess.getRuleRule());
            						}
            						set(
            							current,
            							"accessedRole",
            							lv_accessedRole_5_0,
            							"ca.uottawa.csmlab.symboleo.Symboleo.VariableDotExpression");
            						afterParserOrEnumRuleCall();
            					

            }


            }

            otherlv_6=(Token)match(input,49,FOLLOW_46); 

            				newLeafNode(otherlv_6, grammarAccess.getRuleAccess().getOnKeyword_2_4());
            			
            // InternalSymboleo.g:1858:4: ( (lv_accessedResource_7_0= ruleResource ) )
            // InternalSymboleo.g:1859:5: (lv_accessedResource_7_0= ruleResource )
            {
            // InternalSymboleo.g:1859:5: (lv_accessedResource_7_0= ruleResource )
            // InternalSymboleo.g:1860:6: lv_accessedResource_7_0= ruleResource
            {

            						newCompositeNode(grammarAccess.getRuleAccess().getAccessedResourceResourceParserRuleCall_2_5_0());
            					
            pushFollow(FOLLOW_47);
            lv_accessedResource_7_0=ruleResource();

            state._fsp--;


            						if (current==null) {
            							current = createModelElementForParent(grammarAccess.getRuleRule());
            						}
            						set(
            							current,
            							"accessedResource",
            							lv_accessedResource_7_0,
            							"ca.uottawa.csmlab.symboleo.Symboleo.Resource");
            						afterParserOrEnumRuleCall();
            					

            }


            }

            otherlv_8=(Token)match(input,50,FOLLOW_3); 

            				newLeafNode(otherlv_8, grammarAccess.getRuleAccess().getByKeyword_2_6());
            			
            // InternalSymboleo.g:1881:4: ( (lv_controller_9_0= ruleVariableDotExpression ) )
            // InternalSymboleo.g:1882:5: (lv_controller_9_0= ruleVariableDotExpression )
            {
            // InternalSymboleo.g:1882:5: (lv_controller_9_0= ruleVariableDotExpression )
            // InternalSymboleo.g:1883:6: lv_controller_9_0= ruleVariableDotExpression
            {

            						newCompositeNode(grammarAccess.getRuleAccess().getControllerVariableDotExpressionParserRuleCall_2_7_0());
            					
            pushFollow(FOLLOW_2);
            lv_controller_9_0=ruleVariableDotExpression();

            state._fsp--;


            						if (current==null) {
            							current = createModelElementForParent(grammarAccess.getRuleRule());
            						}
            						set(
            							current,
            							"controller",
            							lv_controller_9_0,
            							"ca.uottawa.csmlab.symboleo.Symboleo.VariableDotExpression");
            						afterParserOrEnumRuleCall();
            					

            }


            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRule"


    // $ANTLR start "entryRuleResource"
    // InternalSymboleo.g:1905:1: entryRuleResource returns [EObject current=null] : iv_ruleResource= ruleResource EOF ;
    public final EObject entryRuleResource() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResource = null;


        try {
            // InternalSymboleo.g:1905:49: (iv_ruleResource= ruleResource EOF )
            // InternalSymboleo.g:1906:2: iv_ruleResource= ruleResource EOF
            {
             newCompositeNode(grammarAccess.getResourceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleResource=ruleResource();

            state._fsp--;

             current =iv_ruleResource; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleResource"


    // $ANTLR start "ruleResource"
    // InternalSymboleo.g:1912:1: ruleResource returns [EObject current=null] : ( ( () (otherlv_1= 'obligations.' ( (otherlv_2= RULE_ID ) ) ) ) | ( () (otherlv_4= 'powers.' ( (otherlv_5= RULE_ID ) ) ) ) | ( () ( (lv_resourceOn_7_0= ruleOntologyType ) ) ) | ( () ( (lv_resourceAc_9_0= ruleACPolicy ) ) ) | ( () ( (lv_resourceAt_11_0= ruleAttribute ) ) ) | ( () ( (lv_resourceDot_13_0= ruleVariableDotExpression ) ) ) | ( () ( (lv_resourceOpe_15_0= ruleOperation ) ) ) ) ;
    public final EObject ruleResource() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_resourceOn_7_0 = null;

        EObject lv_resourceAc_9_0 = null;

        EObject lv_resourceAt_11_0 = null;

        EObject lv_resourceDot_13_0 = null;

        EObject lv_resourceOpe_15_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:1918:2: ( ( ( () (otherlv_1= 'obligations.' ( (otherlv_2= RULE_ID ) ) ) ) | ( () (otherlv_4= 'powers.' ( (otherlv_5= RULE_ID ) ) ) ) | ( () ( (lv_resourceOn_7_0= ruleOntologyType ) ) ) | ( () ( (lv_resourceAc_9_0= ruleACPolicy ) ) ) | ( () ( (lv_resourceAt_11_0= ruleAttribute ) ) ) | ( () ( (lv_resourceDot_13_0= ruleVariableDotExpression ) ) ) | ( () ( (lv_resourceOpe_15_0= ruleOperation ) ) ) ) )
            // InternalSymboleo.g:1919:2: ( ( () (otherlv_1= 'obligations.' ( (otherlv_2= RULE_ID ) ) ) ) | ( () (otherlv_4= 'powers.' ( (otherlv_5= RULE_ID ) ) ) ) | ( () ( (lv_resourceOn_7_0= ruleOntologyType ) ) ) | ( () ( (lv_resourceAc_9_0= ruleACPolicy ) ) ) | ( () ( (lv_resourceAt_11_0= ruleAttribute ) ) ) | ( () ( (lv_resourceDot_13_0= ruleVariableDotExpression ) ) ) | ( () ( (lv_resourceOpe_15_0= ruleOperation ) ) ) )
            {
            // InternalSymboleo.g:1919:2: ( ( () (otherlv_1= 'obligations.' ( (otherlv_2= RULE_ID ) ) ) ) | ( () (otherlv_4= 'powers.' ( (otherlv_5= RULE_ID ) ) ) ) | ( () ( (lv_resourceOn_7_0= ruleOntologyType ) ) ) | ( () ( (lv_resourceAc_9_0= ruleACPolicy ) ) ) | ( () ( (lv_resourceAt_11_0= ruleAttribute ) ) ) | ( () ( (lv_resourceDot_13_0= ruleVariableDotExpression ) ) ) | ( () ( (lv_resourceOpe_15_0= ruleOperation ) ) ) )
            int alt44=7;
            switch ( input.LA(1) ) {
            case 51:
                {
                alt44=1;
                }
                break;
            case 52:
                {
                alt44=2;
                }
                break;
            case 16:
            case 40:
            case 41:
            case 42:
            case 43:
                {
                alt44=3;
                }
                break;
            case 32:
                {
                alt44=4;
                }
                break;
            case 58:
                {
                alt44=5;
                }
                break;
            case RULE_ID:
                {
                switch ( input.LA(2) ) {
                case 33:
                    {
                    alt44=5;
                    }
                    break;
                case EOF:
                case 50:
                case 59:
                    {
                    alt44=6;
                    }
                    break;
                case 17:
                    {
                    alt44=7;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 44, 6, input);

                    throw nvae;
                }

                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // InternalSymboleo.g:1920:3: ( () (otherlv_1= 'obligations.' ( (otherlv_2= RULE_ID ) ) ) )
                    {
                    // InternalSymboleo.g:1920:3: ( () (otherlv_1= 'obligations.' ( (otherlv_2= RULE_ID ) ) ) )
                    // InternalSymboleo.g:1921:4: () (otherlv_1= 'obligations.' ( (otherlv_2= RULE_ID ) ) )
                    {
                    // InternalSymboleo.g:1921:4: ()
                    // InternalSymboleo.g:1922:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getResourceAccess().getResourceObligationAction_0_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:1928:4: (otherlv_1= 'obligations.' ( (otherlv_2= RULE_ID ) ) )
                    // InternalSymboleo.g:1929:5: otherlv_1= 'obligations.' ( (otherlv_2= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,51,FOLLOW_3); 

                    					newLeafNode(otherlv_1, grammarAccess.getResourceAccess().getObligationsKeyword_0_1_0());
                    				
                    // InternalSymboleo.g:1933:5: ( (otherlv_2= RULE_ID ) )
                    // InternalSymboleo.g:1934:6: (otherlv_2= RULE_ID )
                    {
                    // InternalSymboleo.g:1934:6: (otherlv_2= RULE_ID )
                    // InternalSymboleo.g:1935:7: otherlv_2= RULE_ID
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getResourceRule());
                    							}
                    						
                    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_2); 

                    							newLeafNode(otherlv_2, grammarAccess.getResourceAccess().getResourceOpObligationCrossReference_0_1_1_0());
                    						

                    }


                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:1949:3: ( () (otherlv_4= 'powers.' ( (otherlv_5= RULE_ID ) ) ) )
                    {
                    // InternalSymboleo.g:1949:3: ( () (otherlv_4= 'powers.' ( (otherlv_5= RULE_ID ) ) ) )
                    // InternalSymboleo.g:1950:4: () (otherlv_4= 'powers.' ( (otherlv_5= RULE_ID ) ) )
                    {
                    // InternalSymboleo.g:1950:4: ()
                    // InternalSymboleo.g:1951:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getResourceAccess().getResourcePowerAction_1_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:1957:4: (otherlv_4= 'powers.' ( (otherlv_5= RULE_ID ) ) )
                    // InternalSymboleo.g:1958:5: otherlv_4= 'powers.' ( (otherlv_5= RULE_ID ) )
                    {
                    otherlv_4=(Token)match(input,52,FOLLOW_3); 

                    					newLeafNode(otherlv_4, grammarAccess.getResourceAccess().getPowersKeyword_1_1_0());
                    				
                    // InternalSymboleo.g:1962:5: ( (otherlv_5= RULE_ID ) )
                    // InternalSymboleo.g:1963:6: (otherlv_5= RULE_ID )
                    {
                    // InternalSymboleo.g:1963:6: (otherlv_5= RULE_ID )
                    // InternalSymboleo.g:1964:7: otherlv_5= RULE_ID
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getResourceRule());
                    							}
                    						
                    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_2); 

                    							newLeafNode(otherlv_5, grammarAccess.getResourceAccess().getResourcePoPowerCrossReference_1_1_1_0());
                    						

                    }


                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:1978:3: ( () ( (lv_resourceOn_7_0= ruleOntologyType ) ) )
                    {
                    // InternalSymboleo.g:1978:3: ( () ( (lv_resourceOn_7_0= ruleOntologyType ) ) )
                    // InternalSymboleo.g:1979:4: () ( (lv_resourceOn_7_0= ruleOntologyType ) )
                    {
                    // InternalSymboleo.g:1979:4: ()
                    // InternalSymboleo.g:1980:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getResourceAccess().getResourceOntologyTypeAction_2_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:1986:4: ( (lv_resourceOn_7_0= ruleOntologyType ) )
                    // InternalSymboleo.g:1987:5: (lv_resourceOn_7_0= ruleOntologyType )
                    {
                    // InternalSymboleo.g:1987:5: (lv_resourceOn_7_0= ruleOntologyType )
                    // InternalSymboleo.g:1988:6: lv_resourceOn_7_0= ruleOntologyType
                    {

                    						newCompositeNode(grammarAccess.getResourceAccess().getResourceOnOntologyTypeParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_resourceOn_7_0=ruleOntologyType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getResourceRule());
                    						}
                    						set(
                    							current,
                    							"resourceOn",
                    							lv_resourceOn_7_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.OntologyType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalSymboleo.g:2007:3: ( () ( (lv_resourceAc_9_0= ruleACPolicy ) ) )
                    {
                    // InternalSymboleo.g:2007:3: ( () ( (lv_resourceAc_9_0= ruleACPolicy ) ) )
                    // InternalSymboleo.g:2008:4: () ( (lv_resourceAc_9_0= ruleACPolicy ) )
                    {
                    // InternalSymboleo.g:2008:4: ()
                    // InternalSymboleo.g:2009:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getResourceAccess().getResourceACPolicyAction_3_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:2015:4: ( (lv_resourceAc_9_0= ruleACPolicy ) )
                    // InternalSymboleo.g:2016:5: (lv_resourceAc_9_0= ruleACPolicy )
                    {
                    // InternalSymboleo.g:2016:5: (lv_resourceAc_9_0= ruleACPolicy )
                    // InternalSymboleo.g:2017:6: lv_resourceAc_9_0= ruleACPolicy
                    {

                    						newCompositeNode(grammarAccess.getResourceAccess().getResourceAcACPolicyParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_resourceAc_9_0=ruleACPolicy();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getResourceRule());
                    						}
                    						set(
                    							current,
                    							"resourceAc",
                    							lv_resourceAc_9_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.ACPolicy");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalSymboleo.g:2036:3: ( () ( (lv_resourceAt_11_0= ruleAttribute ) ) )
                    {
                    // InternalSymboleo.g:2036:3: ( () ( (lv_resourceAt_11_0= ruleAttribute ) ) )
                    // InternalSymboleo.g:2037:4: () ( (lv_resourceAt_11_0= ruleAttribute ) )
                    {
                    // InternalSymboleo.g:2037:4: ()
                    // InternalSymboleo.g:2038:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getResourceAccess().getResourceAttributeAction_4_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:2044:4: ( (lv_resourceAt_11_0= ruleAttribute ) )
                    // InternalSymboleo.g:2045:5: (lv_resourceAt_11_0= ruleAttribute )
                    {
                    // InternalSymboleo.g:2045:5: (lv_resourceAt_11_0= ruleAttribute )
                    // InternalSymboleo.g:2046:6: lv_resourceAt_11_0= ruleAttribute
                    {

                    						newCompositeNode(grammarAccess.getResourceAccess().getResourceAtAttributeParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_resourceAt_11_0=ruleAttribute();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getResourceRule());
                    						}
                    						set(
                    							current,
                    							"resourceAt",
                    							lv_resourceAt_11_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Attribute");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalSymboleo.g:2065:3: ( () ( (lv_resourceDot_13_0= ruleVariableDotExpression ) ) )
                    {
                    // InternalSymboleo.g:2065:3: ( () ( (lv_resourceDot_13_0= ruleVariableDotExpression ) ) )
                    // InternalSymboleo.g:2066:4: () ( (lv_resourceDot_13_0= ruleVariableDotExpression ) )
                    {
                    // InternalSymboleo.g:2066:4: ()
                    // InternalSymboleo.g:2067:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getResourceAccess().getResourceDotAction_5_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:2073:4: ( (lv_resourceDot_13_0= ruleVariableDotExpression ) )
                    // InternalSymboleo.g:2074:5: (lv_resourceDot_13_0= ruleVariableDotExpression )
                    {
                    // InternalSymboleo.g:2074:5: (lv_resourceDot_13_0= ruleVariableDotExpression )
                    // InternalSymboleo.g:2075:6: lv_resourceDot_13_0= ruleVariableDotExpression
                    {

                    						newCompositeNode(grammarAccess.getResourceAccess().getResourceDotVariableDotExpressionParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_resourceDot_13_0=ruleVariableDotExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getResourceRule());
                    						}
                    						set(
                    							current,
                    							"resourceDot",
                    							lv_resourceDot_13_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.VariableDotExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalSymboleo.g:2094:3: ( () ( (lv_resourceOpe_15_0= ruleOperation ) ) )
                    {
                    // InternalSymboleo.g:2094:3: ( () ( (lv_resourceOpe_15_0= ruleOperation ) ) )
                    // InternalSymboleo.g:2095:4: () ( (lv_resourceOpe_15_0= ruleOperation ) )
                    {
                    // InternalSymboleo.g:2095:4: ()
                    // InternalSymboleo.g:2096:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getResourceAccess().getResourceOperationAction_6_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:2102:4: ( (lv_resourceOpe_15_0= ruleOperation ) )
                    // InternalSymboleo.g:2103:5: (lv_resourceOpe_15_0= ruleOperation )
                    {
                    // InternalSymboleo.g:2103:5: (lv_resourceOpe_15_0= ruleOperation )
                    // InternalSymboleo.g:2104:6: lv_resourceOpe_15_0= ruleOperation
                    {

                    						newCompositeNode(grammarAccess.getResourceAccess().getResourceOpeOperationParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_resourceOpe_15_0=ruleOperation();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getResourceRule());
                    						}
                    						set(
                    							current,
                    							"resourceOpe",
                    							lv_resourceOpe_15_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Operation");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleResource"


    // $ANTLR start "entryRuleOperationRef"
    // InternalSymboleo.g:2126:1: entryRuleOperationRef returns [EObject current=null] : iv_ruleOperationRef= ruleOperationRef EOF ;
    public final EObject entryRuleOperationRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationRef = null;


        try {
            // InternalSymboleo.g:2126:53: (iv_ruleOperationRef= ruleOperationRef EOF )
            // InternalSymboleo.g:2127:2: iv_ruleOperationRef= ruleOperationRef EOF
            {
             newCompositeNode(grammarAccess.getOperationRefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOperationRef=ruleOperationRef();

            state._fsp--;

             current =iv_ruleOperationRef; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOperationRef"


    // $ANTLR start "ruleOperationRef"
    // InternalSymboleo.g:2133:1: ruleOperationRef returns [EObject current=null] : ( () ( (lv_operation_1_0= RULE_ID ) ) ) ;
    public final EObject ruleOperationRef() throws RecognitionException {
        EObject current = null;

        Token lv_operation_1_0=null;


        	enterRule();

        try {
            // InternalSymboleo.g:2139:2: ( ( () ( (lv_operation_1_0= RULE_ID ) ) ) )
            // InternalSymboleo.g:2140:2: ( () ( (lv_operation_1_0= RULE_ID ) ) )
            {
            // InternalSymboleo.g:2140:2: ( () ( (lv_operation_1_0= RULE_ID ) ) )
            // InternalSymboleo.g:2141:3: () ( (lv_operation_1_0= RULE_ID ) )
            {
            // InternalSymboleo.g:2141:3: ()
            // InternalSymboleo.g:2142:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getOperationRefAccess().getOperationRefAction_0(),
            					current);
            			

            }

            // InternalSymboleo.g:2148:3: ( (lv_operation_1_0= RULE_ID ) )
            // InternalSymboleo.g:2149:4: (lv_operation_1_0= RULE_ID )
            {
            // InternalSymboleo.g:2149:4: (lv_operation_1_0= RULE_ID )
            // InternalSymboleo.g:2150:5: lv_operation_1_0= RULE_ID
            {
            lv_operation_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_operation_1_0, grammarAccess.getOperationRefAccess().getOperationIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOperationRefRule());
            					}
            					setWithLastConsumed(
            						current,
            						"operation",
            						lv_operation_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOperationRef"


    // $ANTLR start "entryRulePermission"
    // InternalSymboleo.g:2170:1: entryRulePermission returns [EObject current=null] : iv_rulePermission= rulePermission EOF ;
    public final EObject entryRulePermission() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePermission = null;


        try {
            // InternalSymboleo.g:2170:51: (iv_rulePermission= rulePermission EOF )
            // InternalSymboleo.g:2171:2: iv_rulePermission= rulePermission EOF
            {
             newCompositeNode(grammarAccess.getPermissionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePermission=rulePermission();

            state._fsp--;

             current =iv_rulePermission; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePermission"


    // $ANTLR start "rulePermission"
    // InternalSymboleo.g:2177:1: rulePermission returns [EObject current=null] : ( ( (lv_name_0_1= 'read' | lv_name_0_2= 'write' | lv_name_0_3= 'all' | lv_name_0_4= 'transfer' ) ) ) ;
    public final EObject rulePermission() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;
        Token lv_name_0_3=null;
        Token lv_name_0_4=null;


        	enterRule();

        try {
            // InternalSymboleo.g:2183:2: ( ( ( (lv_name_0_1= 'read' | lv_name_0_2= 'write' | lv_name_0_3= 'all' | lv_name_0_4= 'transfer' ) ) ) )
            // InternalSymboleo.g:2184:2: ( ( (lv_name_0_1= 'read' | lv_name_0_2= 'write' | lv_name_0_3= 'all' | lv_name_0_4= 'transfer' ) ) )
            {
            // InternalSymboleo.g:2184:2: ( ( (lv_name_0_1= 'read' | lv_name_0_2= 'write' | lv_name_0_3= 'all' | lv_name_0_4= 'transfer' ) ) )
            // InternalSymboleo.g:2185:3: ( (lv_name_0_1= 'read' | lv_name_0_2= 'write' | lv_name_0_3= 'all' | lv_name_0_4= 'transfer' ) )
            {
            // InternalSymboleo.g:2185:3: ( (lv_name_0_1= 'read' | lv_name_0_2= 'write' | lv_name_0_3= 'all' | lv_name_0_4= 'transfer' ) )
            // InternalSymboleo.g:2186:4: (lv_name_0_1= 'read' | lv_name_0_2= 'write' | lv_name_0_3= 'all' | lv_name_0_4= 'transfer' )
            {
            // InternalSymboleo.g:2186:4: (lv_name_0_1= 'read' | lv_name_0_2= 'write' | lv_name_0_3= 'all' | lv_name_0_4= 'transfer' )
            int alt45=4;
            switch ( input.LA(1) ) {
            case 53:
                {
                alt45=1;
                }
                break;
            case 54:
                {
                alt45=2;
                }
                break;
            case 55:
                {
                alt45=3;
                }
                break;
            case 56:
                {
                alt45=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }

            switch (alt45) {
                case 1 :
                    // InternalSymboleo.g:2187:5: lv_name_0_1= 'read'
                    {
                    lv_name_0_1=(Token)match(input,53,FOLLOW_2); 

                    					newLeafNode(lv_name_0_1, grammarAccess.getPermissionAccess().getNameReadKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getPermissionRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:2198:5: lv_name_0_2= 'write'
                    {
                    lv_name_0_2=(Token)match(input,54,FOLLOW_2); 

                    					newLeafNode(lv_name_0_2, grammarAccess.getPermissionAccess().getNameWriteKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getPermissionRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_2, null);
                    				

                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:2209:5: lv_name_0_3= 'all'
                    {
                    lv_name_0_3=(Token)match(input,55,FOLLOW_2); 

                    					newLeafNode(lv_name_0_3, grammarAccess.getPermissionAccess().getNameAllKeyword_0_2());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getPermissionRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_3, null);
                    				

                    }
                    break;
                case 4 :
                    // InternalSymboleo.g:2220:5: lv_name_0_4= 'transfer'
                    {
                    lv_name_0_4=(Token)match(input,56,FOLLOW_2); 

                    					newLeafNode(lv_name_0_4, grammarAccess.getPermissionAccess().getNameTransferKeyword_0_3());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getPermissionRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_4, null);
                    				

                    }
                    break;

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePermission"


    // $ANTLR start "entryRuleThirdParty"
    // InternalSymboleo.g:2236:1: entryRuleThirdParty returns [EObject current=null] : iv_ruleThirdParty= ruleThirdParty EOF ;
    public final EObject entryRuleThirdParty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleThirdParty = null;


        try {
            // InternalSymboleo.g:2236:51: (iv_ruleThirdParty= ruleThirdParty EOF )
            // InternalSymboleo.g:2237:2: iv_ruleThirdParty= ruleThirdParty EOF
            {
             newCompositeNode(grammarAccess.getThirdPartyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleThirdParty=ruleThirdParty();

            state._fsp--;

             current =iv_ruleThirdParty; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleThirdParty"


    // $ANTLR start "ruleThirdParty"
    // InternalSymboleo.g:2243:1: ruleThirdParty returns [EObject current=null] : ( (lv_name_0_0= 'thirdParty' ) ) ;
    public final EObject ruleThirdParty() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalSymboleo.g:2249:2: ( ( (lv_name_0_0= 'thirdParty' ) ) )
            // InternalSymboleo.g:2250:2: ( (lv_name_0_0= 'thirdParty' ) )
            {
            // InternalSymboleo.g:2250:2: ( (lv_name_0_0= 'thirdParty' ) )
            // InternalSymboleo.g:2251:3: (lv_name_0_0= 'thirdParty' )
            {
            // InternalSymboleo.g:2251:3: (lv_name_0_0= 'thirdParty' )
            // InternalSymboleo.g:2252:4: lv_name_0_0= 'thirdParty'
            {
            lv_name_0_0=(Token)match(input,57,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getThirdPartyAccess().getNameThirdPartyKeyword_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getThirdPartyRule());
            				}
            				setWithLastConsumed(current, "name", lv_name_0_0, "thirdParty");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleThirdParty"


    // $ANTLR start "entryRuleAttributeModifier"
    // InternalSymboleo.g:2267:1: entryRuleAttributeModifier returns [EObject current=null] : iv_ruleAttributeModifier= ruleAttributeModifier EOF ;
    public final EObject entryRuleAttributeModifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeModifier = null;


        try {
            // InternalSymboleo.g:2267:58: (iv_ruleAttributeModifier= ruleAttributeModifier EOF )
            // InternalSymboleo.g:2268:2: iv_ruleAttributeModifier= ruleAttributeModifier EOF
            {
             newCompositeNode(grammarAccess.getAttributeModifierRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttributeModifier=ruleAttributeModifier();

            state._fsp--;

             current =iv_ruleAttributeModifier; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttributeModifier"


    // $ANTLR start "ruleAttributeModifier"
    // InternalSymboleo.g:2274:1: ruleAttributeModifier returns [EObject current=null] : ( (lv_name_0_0= 'Env' ) ) ;
    public final EObject ruleAttributeModifier() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalSymboleo.g:2280:2: ( ( (lv_name_0_0= 'Env' ) ) )
            // InternalSymboleo.g:2281:2: ( (lv_name_0_0= 'Env' ) )
            {
            // InternalSymboleo.g:2281:2: ( (lv_name_0_0= 'Env' ) )
            // InternalSymboleo.g:2282:3: (lv_name_0_0= 'Env' )
            {
            // InternalSymboleo.g:2282:3: (lv_name_0_0= 'Env' )
            // InternalSymboleo.g:2283:4: lv_name_0_0= 'Env'
            {
            lv_name_0_0=(Token)match(input,58,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getAttributeModifierAccess().getNameEnvKeyword_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getAttributeModifierRule());
            				}
            				setWithLastConsumed(current, "name", lv_name_0_0, "Env");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttributeModifier"


    // $ANTLR start "entryRuleParameter"
    // InternalSymboleo.g:2298:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalSymboleo.g:2298:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalSymboleo.g:2299:2: iv_ruleParameter= ruleParameter EOF
            {
             newCompositeNode(grammarAccess.getParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameter=ruleParameter();

            state._fsp--;

             current =iv_ruleParameter; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // InternalSymboleo.g:2305:1: ruleParameter returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleParameterType ) ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_type_2_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:2311:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleParameterType ) ) ) )
            // InternalSymboleo.g:2312:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleParameterType ) ) )
            {
            // InternalSymboleo.g:2312:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleParameterType ) ) )
            // InternalSymboleo.g:2313:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleParameterType ) )
            {
            // InternalSymboleo.g:2313:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalSymboleo.g:2314:4: (lv_name_0_0= RULE_ID )
            {
            // InternalSymboleo.g:2314:4: (lv_name_0_0= RULE_ID )
            // InternalSymboleo.g:2315:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_34); 

            					newLeafNode(lv_name_0_0, grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getParameterRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,33,FOLLOW_37); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterAccess().getColonKeyword_1());
            		
            // InternalSymboleo.g:2335:3: ( (lv_type_2_0= ruleParameterType ) )
            // InternalSymboleo.g:2336:4: (lv_type_2_0= ruleParameterType )
            {
            // InternalSymboleo.g:2336:4: (lv_type_2_0= ruleParameterType )
            // InternalSymboleo.g:2337:5: lv_type_2_0= ruleParameterType
            {

            					newCompositeNode(grammarAccess.getParameterAccess().getTypeParameterTypeParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_type_2_0=ruleParameterType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParameterRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_2_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.ParameterType");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleParameterType"
    // InternalSymboleo.g:2358:1: entryRuleParameterType returns [EObject current=null] : iv_ruleParameterType= ruleParameterType EOF ;
    public final EObject entryRuleParameterType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterType = null;


        try {
            // InternalSymboleo.g:2358:54: (iv_ruleParameterType= ruleParameterType EOF )
            // InternalSymboleo.g:2359:2: iv_ruleParameterType= ruleParameterType EOF
            {
             newCompositeNode(grammarAccess.getParameterTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterType=ruleParameterType();

            state._fsp--;

             current =iv_ruleParameterType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterType"


    // $ANTLR start "ruleParameterType"
    // InternalSymboleo.g:2365:1: ruleParameterType returns [EObject current=null] : ( ( (lv_baseType_0_0= ruleBaseType ) ) | ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleParameterType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_baseType_0_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:2371:2: ( ( ( (lv_baseType_0_0= ruleBaseType ) ) | ( (otherlv_1= RULE_ID ) ) ) )
            // InternalSymboleo.g:2372:2: ( ( (lv_baseType_0_0= ruleBaseType ) ) | ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalSymboleo.g:2372:2: ( ( (lv_baseType_0_0= ruleBaseType ) ) | ( (otherlv_1= RULE_ID ) ) )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( ((LA46_0>=36 && LA46_0<=39)) ) {
                alt46=1;
            }
            else if ( (LA46_0==RULE_ID) ) {
                alt46=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // InternalSymboleo.g:2373:3: ( (lv_baseType_0_0= ruleBaseType ) )
                    {
                    // InternalSymboleo.g:2373:3: ( (lv_baseType_0_0= ruleBaseType ) )
                    // InternalSymboleo.g:2374:4: (lv_baseType_0_0= ruleBaseType )
                    {
                    // InternalSymboleo.g:2374:4: (lv_baseType_0_0= ruleBaseType )
                    // InternalSymboleo.g:2375:5: lv_baseType_0_0= ruleBaseType
                    {

                    					newCompositeNode(grammarAccess.getParameterTypeAccess().getBaseTypeBaseTypeParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_baseType_0_0=ruleBaseType();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getParameterTypeRule());
                    					}
                    					set(
                    						current,
                    						"baseType",
                    						lv_baseType_0_0,
                    						"ca.uottawa.csmlab.symboleo.Symboleo.BaseType");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:2393:3: ( (otherlv_1= RULE_ID ) )
                    {
                    // InternalSymboleo.g:2393:3: ( (otherlv_1= RULE_ID ) )
                    // InternalSymboleo.g:2394:4: (otherlv_1= RULE_ID )
                    {
                    // InternalSymboleo.g:2394:4: (otherlv_1= RULE_ID )
                    // InternalSymboleo.g:2395:5: otherlv_1= RULE_ID
                    {

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getParameterTypeRule());
                    					}
                    				
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_2); 

                    					newLeafNode(otherlv_1, grammarAccess.getParameterTypeAccess().getDomainTypeDomainTypeCrossReference_1_0());
                    				

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterType"


    // $ANTLR start "entryRuleVariable"
    // InternalSymboleo.g:2410:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // InternalSymboleo.g:2410:49: (iv_ruleVariable= ruleVariable EOF )
            // InternalSymboleo.g:2411:2: iv_ruleVariable= ruleVariable EOF
            {
             newCompositeNode(grammarAccess.getVariableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariable=ruleVariable();

            state._fsp--;

             current =iv_ruleVariable; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariable"


    // $ANTLR start "ruleVariable"
    // InternalSymboleo.g:2417:1: ruleVariable returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'with' ( (lv_attributes_4_0= ruleAssignment ) ) (otherlv_5= ',' ( (lv_attributes_6_0= ruleAssignment ) ) )* )? ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_attributes_4_0 = null;

        EObject lv_attributes_6_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:2423:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'with' ( (lv_attributes_4_0= ruleAssignment ) ) (otherlv_5= ',' ( (lv_attributes_6_0= ruleAssignment ) ) )* )? ) )
            // InternalSymboleo.g:2424:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'with' ( (lv_attributes_4_0= ruleAssignment ) ) (otherlv_5= ',' ( (lv_attributes_6_0= ruleAssignment ) ) )* )? )
            {
            // InternalSymboleo.g:2424:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'with' ( (lv_attributes_4_0= ruleAssignment ) ) (otherlv_5= ',' ( (lv_attributes_6_0= ruleAssignment ) ) )* )? )
            // InternalSymboleo.g:2425:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'with' ( (lv_attributes_4_0= ruleAssignment ) ) (otherlv_5= ',' ( (lv_attributes_6_0= ruleAssignment ) ) )* )?
            {
            // InternalSymboleo.g:2425:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalSymboleo.g:2426:4: (lv_name_0_0= RULE_ID )
            {
            // InternalSymboleo.g:2426:4: (lv_name_0_0= RULE_ID )
            // InternalSymboleo.g:2427:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_34); 

            					newLeafNode(lv_name_0_0, grammarAccess.getVariableAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getVariableRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,33,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getVariableAccess().getColonKeyword_1());
            		
            // InternalSymboleo.g:2447:3: ( (otherlv_2= RULE_ID ) )
            // InternalSymboleo.g:2448:4: (otherlv_2= RULE_ID )
            {
            // InternalSymboleo.g:2448:4: (otherlv_2= RULE_ID )
            // InternalSymboleo.g:2449:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getVariableRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_31); 

            					newLeafNode(otherlv_2, grammarAccess.getVariableAccess().getTypeRegularTypeCrossReference_2_0());
            				

            }


            }

            // InternalSymboleo.g:2460:3: (otherlv_3= 'with' ( (lv_attributes_4_0= ruleAssignment ) ) (otherlv_5= ',' ( (lv_attributes_6_0= ruleAssignment ) ) )* )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==32) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalSymboleo.g:2461:4: otherlv_3= 'with' ( (lv_attributes_4_0= ruleAssignment ) ) (otherlv_5= ',' ( (lv_attributes_6_0= ruleAssignment ) ) )*
                    {
                    otherlv_3=(Token)match(input,32,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getVariableAccess().getWithKeyword_3_0());
                    			
                    // InternalSymboleo.g:2465:4: ( (lv_attributes_4_0= ruleAssignment ) )
                    // InternalSymboleo.g:2466:5: (lv_attributes_4_0= ruleAssignment )
                    {
                    // InternalSymboleo.g:2466:5: (lv_attributes_4_0= ruleAssignment )
                    // InternalSymboleo.g:2467:6: lv_attributes_4_0= ruleAssignment
                    {

                    						newCompositeNode(grammarAccess.getVariableAccess().getAttributesAssignmentParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_48);
                    lv_attributes_4_0=ruleAssignment();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getVariableRule());
                    						}
                    						add(
                    							current,
                    							"attributes",
                    							lv_attributes_4_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Assignment");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSymboleo.g:2484:4: (otherlv_5= ',' ( (lv_attributes_6_0= ruleAssignment ) ) )*
                    loop47:
                    do {
                        int alt47=2;
                        int LA47_0 = input.LA(1);

                        if ( (LA47_0==18) ) {
                            alt47=1;
                        }


                        switch (alt47) {
                    	case 1 :
                    	    // InternalSymboleo.g:2485:5: otherlv_5= ',' ( (lv_attributes_6_0= ruleAssignment ) )
                    	    {
                    	    otherlv_5=(Token)match(input,18,FOLLOW_3); 

                    	    					newLeafNode(otherlv_5, grammarAccess.getVariableAccess().getCommaKeyword_3_2_0());
                    	    				
                    	    // InternalSymboleo.g:2489:5: ( (lv_attributes_6_0= ruleAssignment ) )
                    	    // InternalSymboleo.g:2490:6: (lv_attributes_6_0= ruleAssignment )
                    	    {
                    	    // InternalSymboleo.g:2490:6: (lv_attributes_6_0= ruleAssignment )
                    	    // InternalSymboleo.g:2491:7: lv_attributes_6_0= ruleAssignment
                    	    {

                    	    							newCompositeNode(grammarAccess.getVariableAccess().getAttributesAssignmentParserRuleCall_3_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_48);
                    	    lv_attributes_6_0=ruleAssignment();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getVariableRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"attributes",
                    	    								lv_attributes_6_0,
                    	    								"ca.uottawa.csmlab.symboleo.Symboleo.Assignment");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop47;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariable"


    // $ANTLR start "entryRuleVariableDotExpression"
    // InternalSymboleo.g:2514:1: entryRuleVariableDotExpression returns [EObject current=null] : iv_ruleVariableDotExpression= ruleVariableDotExpression EOF ;
    public final EObject entryRuleVariableDotExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDotExpression = null;


        try {
            // InternalSymboleo.g:2514:62: (iv_ruleVariableDotExpression= ruleVariableDotExpression EOF )
            // InternalSymboleo.g:2515:2: iv_ruleVariableDotExpression= ruleVariableDotExpression EOF
            {
             newCompositeNode(grammarAccess.getVariableDotExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariableDotExpression=ruleVariableDotExpression();

            state._fsp--;

             current =iv_ruleVariableDotExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariableDotExpression"


    // $ANTLR start "ruleVariableDotExpression"
    // InternalSymboleo.g:2521:1: ruleVariableDotExpression returns [EObject current=null] : (this_VariableRef_0= ruleVariableRef ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )* ) ;
    public final EObject ruleVariableDotExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject this_VariableRef_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:2527:2: ( (this_VariableRef_0= ruleVariableRef ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )* ) )
            // InternalSymboleo.g:2528:2: (this_VariableRef_0= ruleVariableRef ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )* )
            {
            // InternalSymboleo.g:2528:2: (this_VariableRef_0= ruleVariableRef ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )* )
            // InternalSymboleo.g:2529:3: this_VariableRef_0= ruleVariableRef ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )*
            {

            			newCompositeNode(grammarAccess.getVariableDotExpressionAccess().getVariableRefParserRuleCall_0());
            		
            pushFollow(FOLLOW_49);
            this_VariableRef_0=ruleVariableRef();

            state._fsp--;


            			current = this_VariableRef_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSymboleo.g:2537:3: ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==59) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalSymboleo.g:2538:4: () otherlv_2= '.' ( (otherlv_3= RULE_ID ) )
            	    {
            	    // InternalSymboleo.g:2538:4: ()
            	    // InternalSymboleo.g:2539:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getVariableDotExpressionAccess().getVariableDotExpressionRefAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,59,FOLLOW_3); 

            	    				newLeafNode(otherlv_2, grammarAccess.getVariableDotExpressionAccess().getFullStopKeyword_1_1());
            	    			
            	    // InternalSymboleo.g:2549:4: ( (otherlv_3= RULE_ID ) )
            	    // InternalSymboleo.g:2550:5: (otherlv_3= RULE_ID )
            	    {
            	    // InternalSymboleo.g:2550:5: (otherlv_3= RULE_ID )
            	    // InternalSymboleo.g:2551:6: otherlv_3= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getVariableDotExpressionRule());
            	    						}
            	    					
            	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_49); 

            	    						newLeafNode(otherlv_3, grammarAccess.getVariableDotExpressionAccess().getTailAttributeCrossReference_1_2_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariableDotExpression"


    // $ANTLR start "entryRuleVariableRef"
    // InternalSymboleo.g:2567:1: entryRuleVariableRef returns [EObject current=null] : iv_ruleVariableRef= ruleVariableRef EOF ;
    public final EObject entryRuleVariableRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableRef = null;


        try {
            // InternalSymboleo.g:2567:52: (iv_ruleVariableRef= ruleVariableRef EOF )
            // InternalSymboleo.g:2568:2: iv_ruleVariableRef= ruleVariableRef EOF
            {
             newCompositeNode(grammarAccess.getVariableRefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariableRef=ruleVariableRef();

            state._fsp--;

             current =iv_ruleVariableRef; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariableRef"


    // $ANTLR start "ruleVariableRef"
    // InternalSymboleo.g:2574:1: ruleVariableRef returns [EObject current=null] : ( () ( (lv_variable_1_0= RULE_ID ) ) ) ;
    public final EObject ruleVariableRef() throws RecognitionException {
        EObject current = null;

        Token lv_variable_1_0=null;


        	enterRule();

        try {
            // InternalSymboleo.g:2580:2: ( ( () ( (lv_variable_1_0= RULE_ID ) ) ) )
            // InternalSymboleo.g:2581:2: ( () ( (lv_variable_1_0= RULE_ID ) ) )
            {
            // InternalSymboleo.g:2581:2: ( () ( (lv_variable_1_0= RULE_ID ) ) )
            // InternalSymboleo.g:2582:3: () ( (lv_variable_1_0= RULE_ID ) )
            {
            // InternalSymboleo.g:2582:3: ()
            // InternalSymboleo.g:2583:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getVariableRefAccess().getVariableRefAction_0(),
            					current);
            			

            }

            // InternalSymboleo.g:2589:3: ( (lv_variable_1_0= RULE_ID ) )
            // InternalSymboleo.g:2590:4: (lv_variable_1_0= RULE_ID )
            {
            // InternalSymboleo.g:2590:4: (lv_variable_1_0= RULE_ID )
            // InternalSymboleo.g:2591:5: lv_variable_1_0= RULE_ID
            {
            lv_variable_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_variable_1_0, grammarAccess.getVariableRefAccess().getVariableIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getVariableRefRule());
            					}
            					setWithLastConsumed(
            						current,
            						"variable",
            						lv_variable_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariableRef"


    // $ANTLR start "entryRuleAssignment"
    // InternalSymboleo.g:2611:1: entryRuleAssignment returns [EObject current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final EObject entryRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignment = null;


        try {
            // InternalSymboleo.g:2611:51: (iv_ruleAssignment= ruleAssignment EOF )
            // InternalSymboleo.g:2612:2: iv_ruleAssignment= ruleAssignment EOF
            {
             newCompositeNode(grammarAccess.getAssignmentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAssignment=ruleAssignment();

            state._fsp--;

             current =iv_ruleAssignment; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignment"


    // $ANTLR start "ruleAssignment"
    // InternalSymboleo.g:2618:1: ruleAssignment returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':=' ( (lv_value_3_0= ruleExpression ) ) ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:2624:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':=' ( (lv_value_3_0= ruleExpression ) ) ) )
            // InternalSymboleo.g:2625:2: ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':=' ( (lv_value_3_0= ruleExpression ) ) )
            {
            // InternalSymboleo.g:2625:2: ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':=' ( (lv_value_3_0= ruleExpression ) ) )
            // InternalSymboleo.g:2626:3: () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':=' ( (lv_value_3_0= ruleExpression ) )
            {
            // InternalSymboleo.g:2626:3: ()
            // InternalSymboleo.g:2627:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getAssignmentAccess().getAssignExpressionAction_0(),
            					current);
            			

            }

            // InternalSymboleo.g:2633:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSymboleo.g:2634:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSymboleo.g:2634:4: (lv_name_1_0= RULE_ID )
            // InternalSymboleo.g:2635:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_50); 

            					newLeafNode(lv_name_1_0, grammarAccess.getAssignmentAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAssignmentRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,60,FOLLOW_39); 

            			newLeafNode(otherlv_2, grammarAccess.getAssignmentAccess().getColonEqualsSignKeyword_2());
            		
            // InternalSymboleo.g:2655:3: ( (lv_value_3_0= ruleExpression ) )
            // InternalSymboleo.g:2656:4: (lv_value_3_0= ruleExpression )
            {
            // InternalSymboleo.g:2656:4: (lv_value_3_0= ruleExpression )
            // InternalSymboleo.g:2657:5: lv_value_3_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getAssignmentAccess().getValueExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_3_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAssignmentRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_3_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignment"


    // $ANTLR start "entryRuleOAssignment"
    // InternalSymboleo.g:2678:1: entryRuleOAssignment returns [EObject current=null] : iv_ruleOAssignment= ruleOAssignment EOF ;
    public final EObject entryRuleOAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOAssignment = null;


        try {
            // InternalSymboleo.g:2678:52: (iv_ruleOAssignment= ruleOAssignment EOF )
            // InternalSymboleo.g:2679:2: iv_ruleOAssignment= ruleOAssignment EOF
            {
             newCompositeNode(grammarAccess.getOAssignmentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOAssignment=ruleOAssignment();

            state._fsp--;

             current =iv_ruleOAssignment; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOAssignment"


    // $ANTLR start "ruleOAssignment"
    // InternalSymboleo.g:2685:1: ruleOAssignment returns [EObject current=null] : ( () ( (lv_name2_1_0= ruleVariableDotExpression ) ) ( (lv_op_2_0= ':=' ) ) ( (lv_value_3_0= ruleExpression ) ) ) ;
    public final EObject ruleOAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject lv_name2_1_0 = null;

        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:2691:2: ( ( () ( (lv_name2_1_0= ruleVariableDotExpression ) ) ( (lv_op_2_0= ':=' ) ) ( (lv_value_3_0= ruleExpression ) ) ) )
            // InternalSymboleo.g:2692:2: ( () ( (lv_name2_1_0= ruleVariableDotExpression ) ) ( (lv_op_2_0= ':=' ) ) ( (lv_value_3_0= ruleExpression ) ) )
            {
            // InternalSymboleo.g:2692:2: ( () ( (lv_name2_1_0= ruleVariableDotExpression ) ) ( (lv_op_2_0= ':=' ) ) ( (lv_value_3_0= ruleExpression ) ) )
            // InternalSymboleo.g:2693:3: () ( (lv_name2_1_0= ruleVariableDotExpression ) ) ( (lv_op_2_0= ':=' ) ) ( (lv_value_3_0= ruleExpression ) )
            {
            // InternalSymboleo.g:2693:3: ()
            // InternalSymboleo.g:2694:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getOAssignmentAccess().getOAssignExpressionAction_0(),
            					current);
            			

            }

            // InternalSymboleo.g:2700:3: ( (lv_name2_1_0= ruleVariableDotExpression ) )
            // InternalSymboleo.g:2701:4: (lv_name2_1_0= ruleVariableDotExpression )
            {
            // InternalSymboleo.g:2701:4: (lv_name2_1_0= ruleVariableDotExpression )
            // InternalSymboleo.g:2702:5: lv_name2_1_0= ruleVariableDotExpression
            {

            					newCompositeNode(grammarAccess.getOAssignmentAccess().getName2VariableDotExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_50);
            lv_name2_1_0=ruleVariableDotExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOAssignmentRule());
            					}
            					set(
            						current,
            						"name2",
            						lv_name2_1_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.VariableDotExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSymboleo.g:2719:3: ( (lv_op_2_0= ':=' ) )
            // InternalSymboleo.g:2720:4: (lv_op_2_0= ':=' )
            {
            // InternalSymboleo.g:2720:4: (lv_op_2_0= ':=' )
            // InternalSymboleo.g:2721:5: lv_op_2_0= ':='
            {
            lv_op_2_0=(Token)match(input,60,FOLLOW_39); 

            					newLeafNode(lv_op_2_0, grammarAccess.getOAssignmentAccess().getOpColonEqualsSignKeyword_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOAssignmentRule());
            					}
            					setWithLastConsumed(current, "op", lv_op_2_0, ":=");
            				

            }


            }

            // InternalSymboleo.g:2733:3: ( (lv_value_3_0= ruleExpression ) )
            // InternalSymboleo.g:2734:4: (lv_value_3_0= ruleExpression )
            {
            // InternalSymboleo.g:2734:4: (lv_value_3_0= ruleExpression )
            // InternalSymboleo.g:2735:5: lv_value_3_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getOAssignmentAccess().getValueExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_3_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOAssignmentRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_3_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOAssignment"


    // $ANTLR start "entryRuleDouble"
    // InternalSymboleo.g:2756:1: entryRuleDouble returns [String current=null] : iv_ruleDouble= ruleDouble EOF ;
    public final String entryRuleDouble() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDouble = null;


        try {
            // InternalSymboleo.g:2756:46: (iv_ruleDouble= ruleDouble EOF )
            // InternalSymboleo.g:2757:2: iv_ruleDouble= ruleDouble EOF
            {
             newCompositeNode(grammarAccess.getDoubleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDouble=ruleDouble();

            state._fsp--;

             current =iv_ruleDouble.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDouble"


    // $ANTLR start "ruleDouble"
    // InternalSymboleo.g:2763:1: ruleDouble returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDouble() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;


        	enterRule();

        try {
            // InternalSymboleo.g:2769:2: ( (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) )
            // InternalSymboleo.g:2770:2: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            {
            // InternalSymboleo.g:2770:2: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            // InternalSymboleo.g:2771:3: this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_51); 

            			current.merge(this_INT_0);
            		

            			newLeafNode(this_INT_0, grammarAccess.getDoubleAccess().getINTTerminalRuleCall_0());
            		
            kw=(Token)match(input,59,FOLLOW_52); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getDoubleAccess().getFullStopKeyword_1());
            		
            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_2); 

            			current.merge(this_INT_2);
            		

            			newLeafNode(this_INT_2, grammarAccess.getDoubleAccess().getINTTerminalRuleCall_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDouble"


    // $ANTLR start "entryRuleDate"
    // InternalSymboleo.g:2794:1: entryRuleDate returns [String current=null] : iv_ruleDate= ruleDate EOF ;
    public final String entryRuleDate() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDate = null;


        try {
            // InternalSymboleo.g:2794:44: (iv_ruleDate= ruleDate EOF )
            // InternalSymboleo.g:2795:2: iv_ruleDate= ruleDate EOF
            {
             newCompositeNode(grammarAccess.getDateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDate=ruleDate();

            state._fsp--;

             current =iv_ruleDate.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDate"


    // $ANTLR start "ruleDate"
    // InternalSymboleo.g:2801:1: ruleDate returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Date' kw= '(' this_STRING_2= RULE_STRING kw= ')' ) ;
    public final AntlrDatatypeRuleToken ruleDate() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_STRING_2=null;


        	enterRule();

        try {
            // InternalSymboleo.g:2807:2: ( (kw= 'Date' kw= '(' this_STRING_2= RULE_STRING kw= ')' ) )
            // InternalSymboleo.g:2808:2: (kw= 'Date' kw= '(' this_STRING_2= RULE_STRING kw= ')' )
            {
            // InternalSymboleo.g:2808:2: (kw= 'Date' kw= '(' this_STRING_2= RULE_STRING kw= ')' )
            // InternalSymboleo.g:2809:3: kw= 'Date' kw= '(' this_STRING_2= RULE_STRING kw= ')'
            {
            kw=(Token)match(input,38,FOLLOW_10); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getDateAccess().getDateKeyword_0());
            		
            kw=(Token)match(input,17,FOLLOW_53); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getDateAccess().getLeftParenthesisKeyword_1());
            		
            this_STRING_2=(Token)match(input,RULE_STRING,FOLLOW_12); 

            			current.merge(this_STRING_2);
            		

            			newLeafNode(this_STRING_2, grammarAccess.getDateAccess().getSTRINGTerminalRuleCall_2());
            		
            kw=(Token)match(input,19,FOLLOW_2); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getDateAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDate"


    // $ANTLR start "entryRuleExpression"
    // InternalSymboleo.g:2835:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalSymboleo.g:2835:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalSymboleo.g:2836:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalSymboleo.g:2842:1: ruleExpression returns [EObject current=null] : this_Or_0= ruleOr ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Or_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:2848:2: (this_Or_0= ruleOr )
            // InternalSymboleo.g:2849:2: this_Or_0= ruleOr
            {

            		newCompositeNode(grammarAccess.getExpressionAccess().getOrParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_Or_0=ruleOr();

            state._fsp--;


            		current = this_Or_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleOr"
    // InternalSymboleo.g:2860:1: entryRuleOr returns [EObject current=null] : iv_ruleOr= ruleOr EOF ;
    public final EObject entryRuleOr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOr = null;


        try {
            // InternalSymboleo.g:2860:43: (iv_ruleOr= ruleOr EOF )
            // InternalSymboleo.g:2861:2: iv_ruleOr= ruleOr EOF
            {
             newCompositeNode(grammarAccess.getOrRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOr=ruleOr();

            state._fsp--;

             current =iv_ruleOr; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOr"


    // $ANTLR start "ruleOr"
    // InternalSymboleo.g:2867:1: ruleOr returns [EObject current=null] : (this_And_0= ruleAnd ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )* ) ;
    public final EObject ruleOr() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_And_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:2873:2: ( (this_And_0= ruleAnd ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )* ) )
            // InternalSymboleo.g:2874:2: (this_And_0= ruleAnd ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )* )
            {
            // InternalSymboleo.g:2874:2: (this_And_0= ruleAnd ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )* )
            // InternalSymboleo.g:2875:3: this_And_0= ruleAnd ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )*
            {

            			newCompositeNode(grammarAccess.getOrAccess().getAndParserRuleCall_0());
            		
            pushFollow(FOLLOW_54);
            this_And_0=ruleAnd();

            state._fsp--;


            			current = this_And_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSymboleo.g:2883:3: ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==61) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalSymboleo.g:2884:4: () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) )
            	    {
            	    // InternalSymboleo.g:2884:4: ()
            	    // InternalSymboleo.g:2885:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getOrAccess().getOrLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,61,FOLLOW_39); 

            	    				newLeafNode(otherlv_2, grammarAccess.getOrAccess().getOrKeyword_1_1());
            	    			
            	    // InternalSymboleo.g:2895:4: ( (lv_right_3_0= ruleAnd ) )
            	    // InternalSymboleo.g:2896:5: (lv_right_3_0= ruleAnd )
            	    {
            	    // InternalSymboleo.g:2896:5: (lv_right_3_0= ruleAnd )
            	    // InternalSymboleo.g:2897:6: lv_right_3_0= ruleAnd
            	    {

            	    						newCompositeNode(grammarAccess.getOrAccess().getRightAndParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_54);
            	    lv_right_3_0=ruleAnd();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getOrRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"ca.uottawa.csmlab.symboleo.Symboleo.And");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOr"


    // $ANTLR start "entryRuleAnd"
    // InternalSymboleo.g:2919:1: entryRuleAnd returns [EObject current=null] : iv_ruleAnd= ruleAnd EOF ;
    public final EObject entryRuleAnd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnd = null;


        try {
            // InternalSymboleo.g:2919:44: (iv_ruleAnd= ruleAnd EOF )
            // InternalSymboleo.g:2920:2: iv_ruleAnd= ruleAnd EOF
            {
             newCompositeNode(grammarAccess.getAndRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAnd=ruleAnd();

            state._fsp--;

             current =iv_ruleAnd; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnd"


    // $ANTLR start "ruleAnd"
    // InternalSymboleo.g:2926:1: ruleAnd returns [EObject current=null] : (this_Equality_0= ruleEquality ( () otherlv_2= 'and' ( (lv_right_3_0= ruleEquality ) ) )* ) ;
    public final EObject ruleAnd() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Equality_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:2932:2: ( (this_Equality_0= ruleEquality ( () otherlv_2= 'and' ( (lv_right_3_0= ruleEquality ) ) )* ) )
            // InternalSymboleo.g:2933:2: (this_Equality_0= ruleEquality ( () otherlv_2= 'and' ( (lv_right_3_0= ruleEquality ) ) )* )
            {
            // InternalSymboleo.g:2933:2: (this_Equality_0= ruleEquality ( () otherlv_2= 'and' ( (lv_right_3_0= ruleEquality ) ) )* )
            // InternalSymboleo.g:2934:3: this_Equality_0= ruleEquality ( () otherlv_2= 'and' ( (lv_right_3_0= ruleEquality ) ) )*
            {

            			newCompositeNode(grammarAccess.getAndAccess().getEqualityParserRuleCall_0());
            		
            pushFollow(FOLLOW_55);
            this_Equality_0=ruleEquality();

            state._fsp--;


            			current = this_Equality_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSymboleo.g:2942:3: ( () otherlv_2= 'and' ( (lv_right_3_0= ruleEquality ) ) )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==62) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // InternalSymboleo.g:2943:4: () otherlv_2= 'and' ( (lv_right_3_0= ruleEquality ) )
            	    {
            	    // InternalSymboleo.g:2943:4: ()
            	    // InternalSymboleo.g:2944:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getAndAccess().getAndLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,62,FOLLOW_39); 

            	    				newLeafNode(otherlv_2, grammarAccess.getAndAccess().getAndKeyword_1_1());
            	    			
            	    // InternalSymboleo.g:2954:4: ( (lv_right_3_0= ruleEquality ) )
            	    // InternalSymboleo.g:2955:5: (lv_right_3_0= ruleEquality )
            	    {
            	    // InternalSymboleo.g:2955:5: (lv_right_3_0= ruleEquality )
            	    // InternalSymboleo.g:2956:6: lv_right_3_0= ruleEquality
            	    {

            	    						newCompositeNode(grammarAccess.getAndAccess().getRightEqualityParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_55);
            	    lv_right_3_0=ruleEquality();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAndRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"ca.uottawa.csmlab.symboleo.Symboleo.Equality");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnd"


    // $ANTLR start "entryRuleEquality"
    // InternalSymboleo.g:2978:1: entryRuleEquality returns [EObject current=null] : iv_ruleEquality= ruleEquality EOF ;
    public final EObject entryRuleEquality() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEquality = null;


        try {
            // InternalSymboleo.g:2978:49: (iv_ruleEquality= ruleEquality EOF )
            // InternalSymboleo.g:2979:2: iv_ruleEquality= ruleEquality EOF
            {
             newCompositeNode(grammarAccess.getEqualityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEquality=ruleEquality();

            state._fsp--;

             current =iv_ruleEquality; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEquality"


    // $ANTLR start "ruleEquality"
    // InternalSymboleo.g:2985:1: ruleEquality returns [EObject current=null] : (this_Comparison_0= ruleComparison ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* ) ;
    public final EObject ruleEquality() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_Comparison_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:2991:2: ( (this_Comparison_0= ruleComparison ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* ) )
            // InternalSymboleo.g:2992:2: (this_Comparison_0= ruleComparison ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* )
            {
            // InternalSymboleo.g:2992:2: (this_Comparison_0= ruleComparison ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* )
            // InternalSymboleo.g:2993:3: this_Comparison_0= ruleComparison ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleComparison ) ) )*
            {

            			newCompositeNode(grammarAccess.getEqualityAccess().getComparisonParserRuleCall_0());
            		
            pushFollow(FOLLOW_56);
            this_Comparison_0=ruleComparison();

            state._fsp--;


            			current = this_Comparison_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSymboleo.g:3001:3: ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleComparison ) ) )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( ((LA53_0>=63 && LA53_0<=64)) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // InternalSymboleo.g:3002:4: () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleComparison ) )
            	    {
            	    // InternalSymboleo.g:3002:4: ()
            	    // InternalSymboleo.g:3003:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getEqualityAccess().getEqualityLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalSymboleo.g:3009:4: ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) )
            	    // InternalSymboleo.g:3010:5: ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) )
            	    {
            	    // InternalSymboleo.g:3010:5: ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) )
            	    // InternalSymboleo.g:3011:6: (lv_op_2_1= '==' | lv_op_2_2= '!=' )
            	    {
            	    // InternalSymboleo.g:3011:6: (lv_op_2_1= '==' | lv_op_2_2= '!=' )
            	    int alt52=2;
            	    int LA52_0 = input.LA(1);

            	    if ( (LA52_0==63) ) {
            	        alt52=1;
            	    }
            	    else if ( (LA52_0==64) ) {
            	        alt52=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 52, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt52) {
            	        case 1 :
            	            // InternalSymboleo.g:3012:7: lv_op_2_1= '=='
            	            {
            	            lv_op_2_1=(Token)match(input,63,FOLLOW_39); 

            	            							newLeafNode(lv_op_2_1, grammarAccess.getEqualityAccess().getOpEqualsSignEqualsSignKeyword_1_1_0_0());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getEqualityRule());
            	            							}
            	            							setWithLastConsumed(current, "op", lv_op_2_1, null);
            	            						

            	            }
            	            break;
            	        case 2 :
            	            // InternalSymboleo.g:3023:7: lv_op_2_2= '!='
            	            {
            	            lv_op_2_2=(Token)match(input,64,FOLLOW_39); 

            	            							newLeafNode(lv_op_2_2, grammarAccess.getEqualityAccess().getOpExclamationMarkEqualsSignKeyword_1_1_0_1());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getEqualityRule());
            	            							}
            	            							setWithLastConsumed(current, "op", lv_op_2_2, null);
            	            						

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalSymboleo.g:3036:4: ( (lv_right_3_0= ruleComparison ) )
            	    // InternalSymboleo.g:3037:5: (lv_right_3_0= ruleComparison )
            	    {
            	    // InternalSymboleo.g:3037:5: (lv_right_3_0= ruleComparison )
            	    // InternalSymboleo.g:3038:6: lv_right_3_0= ruleComparison
            	    {

            	    						newCompositeNode(grammarAccess.getEqualityAccess().getRightComparisonParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_56);
            	    lv_right_3_0=ruleComparison();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getEqualityRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"ca.uottawa.csmlab.symboleo.Symboleo.Comparison");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEquality"


    // $ANTLR start "entryRuleComparison"
    // InternalSymboleo.g:3060:1: entryRuleComparison returns [EObject current=null] : iv_ruleComparison= ruleComparison EOF ;
    public final EObject entryRuleComparison() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparison = null;


        try {
            // InternalSymboleo.g:3060:51: (iv_ruleComparison= ruleComparison EOF )
            // InternalSymboleo.g:3061:2: iv_ruleComparison= ruleComparison EOF
            {
             newCompositeNode(grammarAccess.getComparisonRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComparison=ruleComparison();

            state._fsp--;

             current =iv_ruleComparison; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComparison"


    // $ANTLR start "ruleComparison"
    // InternalSymboleo.g:3067:1: ruleComparison returns [EObject current=null] : (this_Addition_0= ruleAddition ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= ruleAddition ) ) )* ) ;
    public final EObject ruleComparison() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        Token lv_op_2_3=null;
        Token lv_op_2_4=null;
        EObject this_Addition_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:3073:2: ( (this_Addition_0= ruleAddition ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= ruleAddition ) ) )* ) )
            // InternalSymboleo.g:3074:2: (this_Addition_0= ruleAddition ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= ruleAddition ) ) )* )
            {
            // InternalSymboleo.g:3074:2: (this_Addition_0= ruleAddition ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= ruleAddition ) ) )* )
            // InternalSymboleo.g:3075:3: this_Addition_0= ruleAddition ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= ruleAddition ) ) )*
            {

            			newCompositeNode(grammarAccess.getComparisonAccess().getAdditionParserRuleCall_0());
            		
            pushFollow(FOLLOW_57);
            this_Addition_0=ruleAddition();

            state._fsp--;


            			current = this_Addition_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSymboleo.g:3083:3: ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= ruleAddition ) ) )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( ((LA55_0>=65 && LA55_0<=68)) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // InternalSymboleo.g:3084:4: () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= ruleAddition ) )
            	    {
            	    // InternalSymboleo.g:3084:4: ()
            	    // InternalSymboleo.g:3085:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getComparisonAccess().getComparisonLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalSymboleo.g:3091:4: ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) )
            	    // InternalSymboleo.g:3092:5: ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) )
            	    {
            	    // InternalSymboleo.g:3092:5: ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) )
            	    // InternalSymboleo.g:3093:6: (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' )
            	    {
            	    // InternalSymboleo.g:3093:6: (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' )
            	    int alt54=4;
            	    switch ( input.LA(1) ) {
            	    case 65:
            	        {
            	        alt54=1;
            	        }
            	        break;
            	    case 66:
            	        {
            	        alt54=2;
            	        }
            	        break;
            	    case 67:
            	        {
            	        alt54=3;
            	        }
            	        break;
            	    case 68:
            	        {
            	        alt54=4;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 54, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt54) {
            	        case 1 :
            	            // InternalSymboleo.g:3094:7: lv_op_2_1= '>='
            	            {
            	            lv_op_2_1=(Token)match(input,65,FOLLOW_39); 

            	            							newLeafNode(lv_op_2_1, grammarAccess.getComparisonAccess().getOpGreaterThanSignEqualsSignKeyword_1_1_0_0());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getComparisonRule());
            	            							}
            	            							setWithLastConsumed(current, "op", lv_op_2_1, null);
            	            						

            	            }
            	            break;
            	        case 2 :
            	            // InternalSymboleo.g:3105:7: lv_op_2_2= '<='
            	            {
            	            lv_op_2_2=(Token)match(input,66,FOLLOW_39); 

            	            							newLeafNode(lv_op_2_2, grammarAccess.getComparisonAccess().getOpLessThanSignEqualsSignKeyword_1_1_0_1());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getComparisonRule());
            	            							}
            	            							setWithLastConsumed(current, "op", lv_op_2_2, null);
            	            						

            	            }
            	            break;
            	        case 3 :
            	            // InternalSymboleo.g:3116:7: lv_op_2_3= '>'
            	            {
            	            lv_op_2_3=(Token)match(input,67,FOLLOW_39); 

            	            							newLeafNode(lv_op_2_3, grammarAccess.getComparisonAccess().getOpGreaterThanSignKeyword_1_1_0_2());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getComparisonRule());
            	            							}
            	            							setWithLastConsumed(current, "op", lv_op_2_3, null);
            	            						

            	            }
            	            break;
            	        case 4 :
            	            // InternalSymboleo.g:3127:7: lv_op_2_4= '<'
            	            {
            	            lv_op_2_4=(Token)match(input,68,FOLLOW_39); 

            	            							newLeafNode(lv_op_2_4, grammarAccess.getComparisonAccess().getOpLessThanSignKeyword_1_1_0_3());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getComparisonRule());
            	            							}
            	            							setWithLastConsumed(current, "op", lv_op_2_4, null);
            	            						

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalSymboleo.g:3140:4: ( (lv_right_3_0= ruleAddition ) )
            	    // InternalSymboleo.g:3141:5: (lv_right_3_0= ruleAddition )
            	    {
            	    // InternalSymboleo.g:3141:5: (lv_right_3_0= ruleAddition )
            	    // InternalSymboleo.g:3142:6: lv_right_3_0= ruleAddition
            	    {

            	    						newCompositeNode(grammarAccess.getComparisonAccess().getRightAdditionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_57);
            	    lv_right_3_0=ruleAddition();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getComparisonRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"ca.uottawa.csmlab.symboleo.Symboleo.Addition");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop55;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComparison"


    // $ANTLR start "entryRuleAddition"
    // InternalSymboleo.g:3164:1: entryRuleAddition returns [EObject current=null] : iv_ruleAddition= ruleAddition EOF ;
    public final EObject entryRuleAddition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition = null;


        try {
            // InternalSymboleo.g:3164:49: (iv_ruleAddition= ruleAddition EOF )
            // InternalSymboleo.g:3165:2: iv_ruleAddition= ruleAddition EOF
            {
             newCompositeNode(grammarAccess.getAdditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAddition=ruleAddition();

            state._fsp--;

             current =iv_ruleAddition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAddition"


    // $ANTLR start "ruleAddition"
    // InternalSymboleo.g:3171:1: ruleAddition returns [EObject current=null] : (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* ) ;
    public final EObject ruleAddition() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Multiplication_0 = null;

        EObject lv_right_5_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:3177:2: ( (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* ) )
            // InternalSymboleo.g:3178:2: (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* )
            {
            // InternalSymboleo.g:3178:2: (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* )
            // InternalSymboleo.g:3179:3: this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )*
            {

            			newCompositeNode(grammarAccess.getAdditionAccess().getMultiplicationParserRuleCall_0());
            		
            pushFollow(FOLLOW_58);
            this_Multiplication_0=ruleMultiplication();

            state._fsp--;


            			current = this_Multiplication_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSymboleo.g:3187:3: ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( ((LA57_0>=69 && LA57_0<=70)) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // InternalSymboleo.g:3188:4: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) )
            	    {
            	    // InternalSymboleo.g:3188:4: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) )
            	    int alt56=2;
            	    int LA56_0 = input.LA(1);

            	    if ( (LA56_0==69) ) {
            	        alt56=1;
            	    }
            	    else if ( (LA56_0==70) ) {
            	        alt56=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 56, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt56) {
            	        case 1 :
            	            // InternalSymboleo.g:3189:5: ( () otherlv_2= '+' )
            	            {
            	            // InternalSymboleo.g:3189:5: ( () otherlv_2= '+' )
            	            // InternalSymboleo.g:3190:6: () otherlv_2= '+'
            	            {
            	            // InternalSymboleo.g:3190:6: ()
            	            // InternalSymboleo.g:3191:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_2=(Token)match(input,69,FOLLOW_39); 

            	            						newLeafNode(otherlv_2, grammarAccess.getAdditionAccess().getPlusSignKeyword_1_0_0_1());
            	            					

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalSymboleo.g:3203:5: ( () otherlv_4= '-' )
            	            {
            	            // InternalSymboleo.g:3203:5: ( () otherlv_4= '-' )
            	            // InternalSymboleo.g:3204:6: () otherlv_4= '-'
            	            {
            	            // InternalSymboleo.g:3204:6: ()
            	            // InternalSymboleo.g:3205:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_4=(Token)match(input,70,FOLLOW_39); 

            	            						newLeafNode(otherlv_4, grammarAccess.getAdditionAccess().getHyphenMinusKeyword_1_0_1_1());
            	            					

            	            }


            	            }
            	            break;

            	    }

            	    // InternalSymboleo.g:3217:4: ( (lv_right_5_0= ruleMultiplication ) )
            	    // InternalSymboleo.g:3218:5: (lv_right_5_0= ruleMultiplication )
            	    {
            	    // InternalSymboleo.g:3218:5: (lv_right_5_0= ruleMultiplication )
            	    // InternalSymboleo.g:3219:6: lv_right_5_0= ruleMultiplication
            	    {

            	    						newCompositeNode(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_58);
            	    lv_right_5_0=ruleMultiplication();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAdditionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_5_0,
            	    							"ca.uottawa.csmlab.symboleo.Symboleo.Multiplication");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop57;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAddition"


    // $ANTLR start "entryRuleMultiplication"
    // InternalSymboleo.g:3241:1: entryRuleMultiplication returns [EObject current=null] : iv_ruleMultiplication= ruleMultiplication EOF ;
    public final EObject entryRuleMultiplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplication = null;


        try {
            // InternalSymboleo.g:3241:55: (iv_ruleMultiplication= ruleMultiplication EOF )
            // InternalSymboleo.g:3242:2: iv_ruleMultiplication= ruleMultiplication EOF
            {
             newCompositeNode(grammarAccess.getMultiplicationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMultiplication=ruleMultiplication();

            state._fsp--;

             current =iv_ruleMultiplication; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplication"


    // $ANTLR start "ruleMultiplication"
    // InternalSymboleo.g:3248:1: ruleMultiplication returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) ) ( (lv_right_7_0= rulePrimaryExpression ) ) )* ) ;
    public final EObject ruleMultiplication() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject this_PrimaryExpression_0 = null;

        EObject lv_right_7_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:3254:2: ( (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) ) ( (lv_right_7_0= rulePrimaryExpression ) ) )* ) )
            // InternalSymboleo.g:3255:2: (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) ) ( (lv_right_7_0= rulePrimaryExpression ) ) )* )
            {
            // InternalSymboleo.g:3255:2: (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) ) ( (lv_right_7_0= rulePrimaryExpression ) ) )* )
            // InternalSymboleo.g:3256:3: this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) ) ( (lv_right_7_0= rulePrimaryExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getMultiplicationAccess().getPrimaryExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_59);
            this_PrimaryExpression_0=rulePrimaryExpression();

            state._fsp--;


            			current = this_PrimaryExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSymboleo.g:3264:3: ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) ) ( (lv_right_7_0= rulePrimaryExpression ) ) )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( ((LA59_0>=71 && LA59_0<=73)) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // InternalSymboleo.g:3265:4: ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) ) ( (lv_right_7_0= rulePrimaryExpression ) )
            	    {
            	    // InternalSymboleo.g:3265:4: ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) )
            	    int alt58=3;
            	    switch ( input.LA(1) ) {
            	    case 71:
            	        {
            	        alt58=1;
            	        }
            	        break;
            	    case 72:
            	        {
            	        alt58=2;
            	        }
            	        break;
            	    case 73:
            	        {
            	        alt58=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 58, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt58) {
            	        case 1 :
            	            // InternalSymboleo.g:3266:5: ( () otherlv_2= '*' )
            	            {
            	            // InternalSymboleo.g:3266:5: ( () otherlv_2= '*' )
            	            // InternalSymboleo.g:3267:6: () otherlv_2= '*'
            	            {
            	            // InternalSymboleo.g:3267:6: ()
            	            // InternalSymboleo.g:3268:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0_0_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_2=(Token)match(input,71,FOLLOW_39); 

            	            						newLeafNode(otherlv_2, grammarAccess.getMultiplicationAccess().getAsteriskKeyword_1_0_0_1());
            	            					

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalSymboleo.g:3280:5: ( () otherlv_4= '/' )
            	            {
            	            // InternalSymboleo.g:3280:5: ( () otherlv_4= '/' )
            	            // InternalSymboleo.g:3281:6: () otherlv_4= '/'
            	            {
            	            // InternalSymboleo.g:3281:6: ()
            	            // InternalSymboleo.g:3282:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getMultiplicationAccess().getDivLeftAction_1_0_1_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_4=(Token)match(input,72,FOLLOW_39); 

            	            						newLeafNode(otherlv_4, grammarAccess.getMultiplicationAccess().getSolidusKeyword_1_0_1_1());
            	            					

            	            }


            	            }
            	            break;
            	        case 3 :
            	            // InternalSymboleo.g:3294:5: ( () otherlv_6= '%' )
            	            {
            	            // InternalSymboleo.g:3294:5: ( () otherlv_6= '%' )
            	            // InternalSymboleo.g:3295:6: () otherlv_6= '%'
            	            {
            	            // InternalSymboleo.g:3295:6: ()
            	            // InternalSymboleo.g:3296:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getMultiplicationAccess().getModLeftAction_1_0_2_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_6=(Token)match(input,73,FOLLOW_39); 

            	            						newLeafNode(otherlv_6, grammarAccess.getMultiplicationAccess().getPercentSignKeyword_1_0_2_1());
            	            					

            	            }


            	            }
            	            break;

            	    }

            	    // InternalSymboleo.g:3308:4: ( (lv_right_7_0= rulePrimaryExpression ) )
            	    // InternalSymboleo.g:3309:5: (lv_right_7_0= rulePrimaryExpression )
            	    {
            	    // InternalSymboleo.g:3309:5: (lv_right_7_0= rulePrimaryExpression )
            	    // InternalSymboleo.g:3310:6: lv_right_7_0= rulePrimaryExpression
            	    {

            	    						newCompositeNode(grammarAccess.getMultiplicationAccess().getRightPrimaryExpressionParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_59);
            	    lv_right_7_0=rulePrimaryExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getMultiplicationRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_7_0,
            	    							"ca.uottawa.csmlab.symboleo.Symboleo.PrimaryExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop59;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplication"


    // $ANTLR start "entryRulePrimaryExpression"
    // InternalSymboleo.g:3332:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalSymboleo.g:3332:58: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalSymboleo.g:3333:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
             newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;

             current =iv_rulePrimaryExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // InternalSymboleo.g:3339:1: rulePrimaryExpression returns [EObject current=null] : ( ( () otherlv_1= '(' ( (lv_inner_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( () ( (lv_function_5_0= ruleFunctionCall ) ) ) | ( () otherlv_7= 'not' ( (lv_expression_8_0= rulePrimaryExpression ) ) ) | this_AtomicExpression_9= ruleAtomicExpression ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_7=null;
        EObject lv_inner_2_0 = null;

        EObject lv_function_5_0 = null;

        EObject lv_expression_8_0 = null;

        EObject this_AtomicExpression_9 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:3345:2: ( ( ( () otherlv_1= '(' ( (lv_inner_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( () ( (lv_function_5_0= ruleFunctionCall ) ) ) | ( () otherlv_7= 'not' ( (lv_expression_8_0= rulePrimaryExpression ) ) ) | this_AtomicExpression_9= ruleAtomicExpression ) )
            // InternalSymboleo.g:3346:2: ( ( () otherlv_1= '(' ( (lv_inner_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( () ( (lv_function_5_0= ruleFunctionCall ) ) ) | ( () otherlv_7= 'not' ( (lv_expression_8_0= rulePrimaryExpression ) ) ) | this_AtomicExpression_9= ruleAtomicExpression )
            {
            // InternalSymboleo.g:3346:2: ( ( () otherlv_1= '(' ( (lv_inner_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( () ( (lv_function_5_0= ruleFunctionCall ) ) ) | ( () otherlv_7= 'not' ( (lv_expression_8_0= rulePrimaryExpression ) ) ) | this_AtomicExpression_9= ruleAtomicExpression )
            int alt60=4;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt60=1;
                }
                break;
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
                {
                alt60=2;
                }
                break;
            case 74:
                {
                alt60=3;
                }
                break;
            case RULE_ID:
            case RULE_INT:
            case RULE_STRING:
            case 38:
            case 75:
            case 76:
                {
                alt60=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }

            switch (alt60) {
                case 1 :
                    // InternalSymboleo.g:3347:3: ( () otherlv_1= '(' ( (lv_inner_2_0= ruleExpression ) ) otherlv_3= ')' )
                    {
                    // InternalSymboleo.g:3347:3: ( () otherlv_1= '(' ( (lv_inner_2_0= ruleExpression ) ) otherlv_3= ')' )
                    // InternalSymboleo.g:3348:4: () otherlv_1= '(' ( (lv_inner_2_0= ruleExpression ) ) otherlv_3= ')'
                    {
                    // InternalSymboleo.g:3348:4: ()
                    // InternalSymboleo.g:3349:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimaryExpressionAccess().getPrimaryExpressionRecursiveAction_0_0(),
                    						current);
                    				

                    }

                    otherlv_1=(Token)match(input,17,FOLLOW_39); 

                    				newLeafNode(otherlv_1, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_0_1());
                    			
                    // InternalSymboleo.g:3359:4: ( (lv_inner_2_0= ruleExpression ) )
                    // InternalSymboleo.g:3360:5: (lv_inner_2_0= ruleExpression )
                    {
                    // InternalSymboleo.g:3360:5: (lv_inner_2_0= ruleExpression )
                    // InternalSymboleo.g:3361:6: lv_inner_2_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getInnerExpressionParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_inner_2_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                    						}
                    						set(
                    							current,
                    							"inner",
                    							lv_inner_2_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_3, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_0_3());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:3384:3: ( () ( (lv_function_5_0= ruleFunctionCall ) ) )
                    {
                    // InternalSymboleo.g:3384:3: ( () ( (lv_function_5_0= ruleFunctionCall ) ) )
                    // InternalSymboleo.g:3385:4: () ( (lv_function_5_0= ruleFunctionCall ) )
                    {
                    // InternalSymboleo.g:3385:4: ()
                    // InternalSymboleo.g:3386:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimaryExpressionAccess().getPrimaryExpressionFunctionCallAction_1_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:3392:4: ( (lv_function_5_0= ruleFunctionCall ) )
                    // InternalSymboleo.g:3393:5: (lv_function_5_0= ruleFunctionCall )
                    {
                    // InternalSymboleo.g:3393:5: (lv_function_5_0= ruleFunctionCall )
                    // InternalSymboleo.g:3394:6: lv_function_5_0= ruleFunctionCall
                    {

                    						newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getFunctionFunctionCallParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_function_5_0=ruleFunctionCall();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                    						}
                    						set(
                    							current,
                    							"function",
                    							lv_function_5_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.FunctionCall");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:3413:3: ( () otherlv_7= 'not' ( (lv_expression_8_0= rulePrimaryExpression ) ) )
                    {
                    // InternalSymboleo.g:3413:3: ( () otherlv_7= 'not' ( (lv_expression_8_0= rulePrimaryExpression ) ) )
                    // InternalSymboleo.g:3414:4: () otherlv_7= 'not' ( (lv_expression_8_0= rulePrimaryExpression ) )
                    {
                    // InternalSymboleo.g:3414:4: ()
                    // InternalSymboleo.g:3415:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimaryExpressionAccess().getNegatedPrimaryExpressionAction_2_0(),
                    						current);
                    				

                    }

                    otherlv_7=(Token)match(input,74,FOLLOW_39); 

                    				newLeafNode(otherlv_7, grammarAccess.getPrimaryExpressionAccess().getNotKeyword_2_1());
                    			
                    // InternalSymboleo.g:3425:4: ( (lv_expression_8_0= rulePrimaryExpression ) )
                    // InternalSymboleo.g:3426:5: (lv_expression_8_0= rulePrimaryExpression )
                    {
                    // InternalSymboleo.g:3426:5: (lv_expression_8_0= rulePrimaryExpression )
                    // InternalSymboleo.g:3427:6: lv_expression_8_0= rulePrimaryExpression
                    {

                    						newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getExpressionPrimaryExpressionParserRuleCall_2_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_expression_8_0=rulePrimaryExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                    						}
                    						set(
                    							current,
                    							"expression",
                    							lv_expression_8_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.PrimaryExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalSymboleo.g:3446:3: this_AtomicExpression_9= ruleAtomicExpression
                    {

                    			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getAtomicExpressionParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_AtomicExpression_9=ruleAtomicExpression();

                    state._fsp--;


                    			current = this_AtomicExpression_9;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "entryRuleAtomicExpression"
    // InternalSymboleo.g:3458:1: entryRuleAtomicExpression returns [EObject current=null] : iv_ruleAtomicExpression= ruleAtomicExpression EOF ;
    public final EObject entryRuleAtomicExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomicExpression = null;


        try {
            // InternalSymboleo.g:3458:57: (iv_ruleAtomicExpression= ruleAtomicExpression EOF )
            // InternalSymboleo.g:3459:2: iv_ruleAtomicExpression= ruleAtomicExpression EOF
            {
             newCompositeNode(grammarAccess.getAtomicExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAtomicExpression=ruleAtomicExpression();

            state._fsp--;

             current =iv_ruleAtomicExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAtomicExpression"


    // $ANTLR start "ruleAtomicExpression"
    // InternalSymboleo.g:3465:1: ruleAtomicExpression returns [EObject current=null] : ( ( () ( (lv_value_1_0= 'true' ) ) ) | ( () ( (lv_value_3_0= 'false' ) ) ) | ( () ( (lv_value_5_0= ruleDouble ) ) ) | ( () ( (lv_value_7_0= RULE_INT ) ) ) | ( () ( (lv_value_9_0= ruleDate ) ) ) | ( () ( (otherlv_11= RULE_ID ) ) otherlv_12= '(' ( (otherlv_13= RULE_ID ) ) otherlv_14= ')' ) | ( () ( (lv_value_16_0= RULE_STRING ) ) ) | ( () ( (lv_value_18_0= ruleVariableDotExpression ) ) ) ) ;
    public final EObject ruleAtomicExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token lv_value_3_0=null;
        Token lv_value_7_0=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token lv_value_16_0=null;
        AntlrDatatypeRuleToken lv_value_5_0 = null;

        AntlrDatatypeRuleToken lv_value_9_0 = null;

        EObject lv_value_18_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:3471:2: ( ( ( () ( (lv_value_1_0= 'true' ) ) ) | ( () ( (lv_value_3_0= 'false' ) ) ) | ( () ( (lv_value_5_0= ruleDouble ) ) ) | ( () ( (lv_value_7_0= RULE_INT ) ) ) | ( () ( (lv_value_9_0= ruleDate ) ) ) | ( () ( (otherlv_11= RULE_ID ) ) otherlv_12= '(' ( (otherlv_13= RULE_ID ) ) otherlv_14= ')' ) | ( () ( (lv_value_16_0= RULE_STRING ) ) ) | ( () ( (lv_value_18_0= ruleVariableDotExpression ) ) ) ) )
            // InternalSymboleo.g:3472:2: ( ( () ( (lv_value_1_0= 'true' ) ) ) | ( () ( (lv_value_3_0= 'false' ) ) ) | ( () ( (lv_value_5_0= ruleDouble ) ) ) | ( () ( (lv_value_7_0= RULE_INT ) ) ) | ( () ( (lv_value_9_0= ruleDate ) ) ) | ( () ( (otherlv_11= RULE_ID ) ) otherlv_12= '(' ( (otherlv_13= RULE_ID ) ) otherlv_14= ')' ) | ( () ( (lv_value_16_0= RULE_STRING ) ) ) | ( () ( (lv_value_18_0= ruleVariableDotExpression ) ) ) )
            {
            // InternalSymboleo.g:3472:2: ( ( () ( (lv_value_1_0= 'true' ) ) ) | ( () ( (lv_value_3_0= 'false' ) ) ) | ( () ( (lv_value_5_0= ruleDouble ) ) ) | ( () ( (lv_value_7_0= RULE_INT ) ) ) | ( () ( (lv_value_9_0= ruleDate ) ) ) | ( () ( (otherlv_11= RULE_ID ) ) otherlv_12= '(' ( (otherlv_13= RULE_ID ) ) otherlv_14= ')' ) | ( () ( (lv_value_16_0= RULE_STRING ) ) ) | ( () ( (lv_value_18_0= ruleVariableDotExpression ) ) ) )
            int alt61=8;
            alt61 = dfa61.predict(input);
            switch (alt61) {
                case 1 :
                    // InternalSymboleo.g:3473:3: ( () ( (lv_value_1_0= 'true' ) ) )
                    {
                    // InternalSymboleo.g:3473:3: ( () ( (lv_value_1_0= 'true' ) ) )
                    // InternalSymboleo.g:3474:4: () ( (lv_value_1_0= 'true' ) )
                    {
                    // InternalSymboleo.g:3474:4: ()
                    // InternalSymboleo.g:3475:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getAtomicExpressionAccess().getAtomicExpressionTrueAction_0_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:3481:4: ( (lv_value_1_0= 'true' ) )
                    // InternalSymboleo.g:3482:5: (lv_value_1_0= 'true' )
                    {
                    // InternalSymboleo.g:3482:5: (lv_value_1_0= 'true' )
                    // InternalSymboleo.g:3483:6: lv_value_1_0= 'true'
                    {
                    lv_value_1_0=(Token)match(input,75,FOLLOW_2); 

                    						newLeafNode(lv_value_1_0, grammarAccess.getAtomicExpressionAccess().getValueTrueKeyword_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAtomicExpressionRule());
                    						}
                    						setWithLastConsumed(current, "value", lv_value_1_0, "true");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:3497:3: ( () ( (lv_value_3_0= 'false' ) ) )
                    {
                    // InternalSymboleo.g:3497:3: ( () ( (lv_value_3_0= 'false' ) ) )
                    // InternalSymboleo.g:3498:4: () ( (lv_value_3_0= 'false' ) )
                    {
                    // InternalSymboleo.g:3498:4: ()
                    // InternalSymboleo.g:3499:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getAtomicExpressionAccess().getAtomicExpressionFalseAction_1_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:3505:4: ( (lv_value_3_0= 'false' ) )
                    // InternalSymboleo.g:3506:5: (lv_value_3_0= 'false' )
                    {
                    // InternalSymboleo.g:3506:5: (lv_value_3_0= 'false' )
                    // InternalSymboleo.g:3507:6: lv_value_3_0= 'false'
                    {
                    lv_value_3_0=(Token)match(input,76,FOLLOW_2); 

                    						newLeafNode(lv_value_3_0, grammarAccess.getAtomicExpressionAccess().getValueFalseKeyword_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAtomicExpressionRule());
                    						}
                    						setWithLastConsumed(current, "value", lv_value_3_0, "false");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:3521:3: ( () ( (lv_value_5_0= ruleDouble ) ) )
                    {
                    // InternalSymboleo.g:3521:3: ( () ( (lv_value_5_0= ruleDouble ) ) )
                    // InternalSymboleo.g:3522:4: () ( (lv_value_5_0= ruleDouble ) )
                    {
                    // InternalSymboleo.g:3522:4: ()
                    // InternalSymboleo.g:3523:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getAtomicExpressionAccess().getAtomicExpressionDoubleAction_2_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:3529:4: ( (lv_value_5_0= ruleDouble ) )
                    // InternalSymboleo.g:3530:5: (lv_value_5_0= ruleDouble )
                    {
                    // InternalSymboleo.g:3530:5: (lv_value_5_0= ruleDouble )
                    // InternalSymboleo.g:3531:6: lv_value_5_0= ruleDouble
                    {

                    						newCompositeNode(grammarAccess.getAtomicExpressionAccess().getValueDoubleParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_value_5_0=ruleDouble();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAtomicExpressionRule());
                    						}
                    						set(
                    							current,
                    							"value",
                    							lv_value_5_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Double");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalSymboleo.g:3550:3: ( () ( (lv_value_7_0= RULE_INT ) ) )
                    {
                    // InternalSymboleo.g:3550:3: ( () ( (lv_value_7_0= RULE_INT ) ) )
                    // InternalSymboleo.g:3551:4: () ( (lv_value_7_0= RULE_INT ) )
                    {
                    // InternalSymboleo.g:3551:4: ()
                    // InternalSymboleo.g:3552:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getAtomicExpressionAccess().getAtomicExpressionIntAction_3_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:3558:4: ( (lv_value_7_0= RULE_INT ) )
                    // InternalSymboleo.g:3559:5: (lv_value_7_0= RULE_INT )
                    {
                    // InternalSymboleo.g:3559:5: (lv_value_7_0= RULE_INT )
                    // InternalSymboleo.g:3560:6: lv_value_7_0= RULE_INT
                    {
                    lv_value_7_0=(Token)match(input,RULE_INT,FOLLOW_2); 

                    						newLeafNode(lv_value_7_0, grammarAccess.getAtomicExpressionAccess().getValueINTTerminalRuleCall_3_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAtomicExpressionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"value",
                    							lv_value_7_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalSymboleo.g:3578:3: ( () ( (lv_value_9_0= ruleDate ) ) )
                    {
                    // InternalSymboleo.g:3578:3: ( () ( (lv_value_9_0= ruleDate ) ) )
                    // InternalSymboleo.g:3579:4: () ( (lv_value_9_0= ruleDate ) )
                    {
                    // InternalSymboleo.g:3579:4: ()
                    // InternalSymboleo.g:3580:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getAtomicExpressionAccess().getAtomicExpressionDateAction_4_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:3586:4: ( (lv_value_9_0= ruleDate ) )
                    // InternalSymboleo.g:3587:5: (lv_value_9_0= ruleDate )
                    {
                    // InternalSymboleo.g:3587:5: (lv_value_9_0= ruleDate )
                    // InternalSymboleo.g:3588:6: lv_value_9_0= ruleDate
                    {

                    						newCompositeNode(grammarAccess.getAtomicExpressionAccess().getValueDateParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_value_9_0=ruleDate();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAtomicExpressionRule());
                    						}
                    						set(
                    							current,
                    							"value",
                    							lv_value_9_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Date");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalSymboleo.g:3607:3: ( () ( (otherlv_11= RULE_ID ) ) otherlv_12= '(' ( (otherlv_13= RULE_ID ) ) otherlv_14= ')' )
                    {
                    // InternalSymboleo.g:3607:3: ( () ( (otherlv_11= RULE_ID ) ) otherlv_12= '(' ( (otherlv_13= RULE_ID ) ) otherlv_14= ')' )
                    // InternalSymboleo.g:3608:4: () ( (otherlv_11= RULE_ID ) ) otherlv_12= '(' ( (otherlv_13= RULE_ID ) ) otherlv_14= ')'
                    {
                    // InternalSymboleo.g:3608:4: ()
                    // InternalSymboleo.g:3609:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getAtomicExpressionAccess().getAtomicExpressionEnumAction_5_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:3615:4: ( (otherlv_11= RULE_ID ) )
                    // InternalSymboleo.g:3616:5: (otherlv_11= RULE_ID )
                    {
                    // InternalSymboleo.g:3616:5: (otherlv_11= RULE_ID )
                    // InternalSymboleo.g:3617:6: otherlv_11= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAtomicExpressionRule());
                    						}
                    					
                    otherlv_11=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_11, grammarAccess.getAtomicExpressionAccess().getEnumerationEnumerationCrossReference_5_1_0());
                    					

                    }


                    }

                    otherlv_12=(Token)match(input,17,FOLLOW_3); 

                    				newLeafNode(otherlv_12, grammarAccess.getAtomicExpressionAccess().getLeftParenthesisKeyword_5_2());
                    			
                    // InternalSymboleo.g:3632:4: ( (otherlv_13= RULE_ID ) )
                    // InternalSymboleo.g:3633:5: (otherlv_13= RULE_ID )
                    {
                    // InternalSymboleo.g:3633:5: (otherlv_13= RULE_ID )
                    // InternalSymboleo.g:3634:6: otherlv_13= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAtomicExpressionRule());
                    						}
                    					
                    otherlv_13=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_13, grammarAccess.getAtomicExpressionAccess().getEnumItemEnumItemCrossReference_5_3_0());
                    					

                    }


                    }

                    otherlv_14=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_14, grammarAccess.getAtomicExpressionAccess().getRightParenthesisKeyword_5_4());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalSymboleo.g:3651:3: ( () ( (lv_value_16_0= RULE_STRING ) ) )
                    {
                    // InternalSymboleo.g:3651:3: ( () ( (lv_value_16_0= RULE_STRING ) ) )
                    // InternalSymboleo.g:3652:4: () ( (lv_value_16_0= RULE_STRING ) )
                    {
                    // InternalSymboleo.g:3652:4: ()
                    // InternalSymboleo.g:3653:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getAtomicExpressionAccess().getAtomicExpressionStringAction_6_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:3659:4: ( (lv_value_16_0= RULE_STRING ) )
                    // InternalSymboleo.g:3660:5: (lv_value_16_0= RULE_STRING )
                    {
                    // InternalSymboleo.g:3660:5: (lv_value_16_0= RULE_STRING )
                    // InternalSymboleo.g:3661:6: lv_value_16_0= RULE_STRING
                    {
                    lv_value_16_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    						newLeafNode(lv_value_16_0, grammarAccess.getAtomicExpressionAccess().getValueSTRINGTerminalRuleCall_6_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAtomicExpressionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"value",
                    							lv_value_16_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalSymboleo.g:3679:3: ( () ( (lv_value_18_0= ruleVariableDotExpression ) ) )
                    {
                    // InternalSymboleo.g:3679:3: ( () ( (lv_value_18_0= ruleVariableDotExpression ) ) )
                    // InternalSymboleo.g:3680:4: () ( (lv_value_18_0= ruleVariableDotExpression ) )
                    {
                    // InternalSymboleo.g:3680:4: ()
                    // InternalSymboleo.g:3681:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getAtomicExpressionAccess().getAtomicExpressionParameterAction_7_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:3687:4: ( (lv_value_18_0= ruleVariableDotExpression ) )
                    // InternalSymboleo.g:3688:5: (lv_value_18_0= ruleVariableDotExpression )
                    {
                    // InternalSymboleo.g:3688:5: (lv_value_18_0= ruleVariableDotExpression )
                    // InternalSymboleo.g:3689:6: lv_value_18_0= ruleVariableDotExpression
                    {

                    						newCompositeNode(grammarAccess.getAtomicExpressionAccess().getValueVariableDotExpressionParserRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_value_18_0=ruleVariableDotExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAtomicExpressionRule());
                    						}
                    						set(
                    							current,
                    							"value",
                    							lv_value_18_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.VariableDotExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAtomicExpression"


    // $ANTLR start "entryRuleFunctionCall"
    // InternalSymboleo.g:3711:1: entryRuleFunctionCall returns [EObject current=null] : iv_ruleFunctionCall= ruleFunctionCall EOF ;
    public final EObject entryRuleFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionCall = null;


        try {
            // InternalSymboleo.g:3711:53: (iv_ruleFunctionCall= ruleFunctionCall EOF )
            // InternalSymboleo.g:3712:2: iv_ruleFunctionCall= ruleFunctionCall EOF
            {
             newCompositeNode(grammarAccess.getFunctionCallRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFunctionCall=ruleFunctionCall();

            state._fsp--;

             current =iv_ruleFunctionCall; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunctionCall"


    // $ANTLR start "ruleFunctionCall"
    // InternalSymboleo.g:3718:1: ruleFunctionCall returns [EObject current=null] : (this_MathFunction_0= ruleMathFunction | this_StringFunction_1= ruleStringFunction | this_DateFunction_2= ruleDateFunction ) ;
    public final EObject ruleFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject this_MathFunction_0 = null;

        EObject this_StringFunction_1 = null;

        EObject this_DateFunction_2 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:3724:2: ( (this_MathFunction_0= ruleMathFunction | this_StringFunction_1= ruleStringFunction | this_DateFunction_2= ruleDateFunction ) )
            // InternalSymboleo.g:3725:2: (this_MathFunction_0= ruleMathFunction | this_StringFunction_1= ruleStringFunction | this_DateFunction_2= ruleDateFunction )
            {
            // InternalSymboleo.g:3725:2: (this_MathFunction_0= ruleMathFunction | this_StringFunction_1= ruleStringFunction | this_DateFunction_2= ruleDateFunction )
            int alt62=3;
            switch ( input.LA(1) ) {
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
                {
                alt62=1;
                }
                break;
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
                {
                alt62=2;
                }
                break;
            case 95:
                {
                alt62=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }

            switch (alt62) {
                case 1 :
                    // InternalSymboleo.g:3726:3: this_MathFunction_0= ruleMathFunction
                    {

                    			newCompositeNode(grammarAccess.getFunctionCallAccess().getMathFunctionParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_MathFunction_0=ruleMathFunction();

                    state._fsp--;


                    			current = this_MathFunction_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:3735:3: this_StringFunction_1= ruleStringFunction
                    {

                    			newCompositeNode(grammarAccess.getFunctionCallAccess().getStringFunctionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_StringFunction_1=ruleStringFunction();

                    state._fsp--;


                    			current = this_StringFunction_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:3744:3: this_DateFunction_2= ruleDateFunction
                    {

                    			newCompositeNode(grammarAccess.getFunctionCallAccess().getDateFunctionParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_DateFunction_2=ruleDateFunction();

                    state._fsp--;


                    			current = this_DateFunction_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunctionCall"


    // $ANTLR start "entryRuleMathFunction"
    // InternalSymboleo.g:3756:1: entryRuleMathFunction returns [EObject current=null] : iv_ruleMathFunction= ruleMathFunction EOF ;
    public final EObject entryRuleMathFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMathFunction = null;


        try {
            // InternalSymboleo.g:3756:53: (iv_ruleMathFunction= ruleMathFunction EOF )
            // InternalSymboleo.g:3757:2: iv_ruleMathFunction= ruleMathFunction EOF
            {
             newCompositeNode(grammarAccess.getMathFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMathFunction=ruleMathFunction();

            state._fsp--;

             current =iv_ruleMathFunction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMathFunction"


    // $ANTLR start "ruleMathFunction"
    // InternalSymboleo.g:3763:1: ruleMathFunction returns [EObject current=null] : ( ( () ( ( (lv_name_1_1= 'Math.pow' | lv_name_1_2= 'Math.max' | lv_name_1_3= 'Math.min' ) ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= ruleExpression ) ) otherlv_6= ')' ) | ( () ( ( (lv_name_8_1= 'Math.abs' | lv_name_8_2= 'Math.floor' | lv_name_8_3= 'Math.cbrt' | lv_name_8_4= 'Math.ceil' | lv_name_8_5= 'Math.exp' | lv_name_8_6= 'Math.sign' | lv_name_8_7= 'Math.sqrt' ) ) ) otherlv_9= '(' ( (lv_arg1_10_0= ruleExpression ) ) otherlv_11= ')' ) ) ;
    public final EObject ruleMathFunction() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_1=null;
        Token lv_name_1_2=null;
        Token lv_name_1_3=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token lv_name_8_1=null;
        Token lv_name_8_2=null;
        Token lv_name_8_3=null;
        Token lv_name_8_4=null;
        Token lv_name_8_5=null;
        Token lv_name_8_6=null;
        Token lv_name_8_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject lv_arg1_3_0 = null;

        EObject lv_arg2_5_0 = null;

        EObject lv_arg1_10_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:3769:2: ( ( ( () ( ( (lv_name_1_1= 'Math.pow' | lv_name_1_2= 'Math.max' | lv_name_1_3= 'Math.min' ) ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= ruleExpression ) ) otherlv_6= ')' ) | ( () ( ( (lv_name_8_1= 'Math.abs' | lv_name_8_2= 'Math.floor' | lv_name_8_3= 'Math.cbrt' | lv_name_8_4= 'Math.ceil' | lv_name_8_5= 'Math.exp' | lv_name_8_6= 'Math.sign' | lv_name_8_7= 'Math.sqrt' ) ) ) otherlv_9= '(' ( (lv_arg1_10_0= ruleExpression ) ) otherlv_11= ')' ) ) )
            // InternalSymboleo.g:3770:2: ( ( () ( ( (lv_name_1_1= 'Math.pow' | lv_name_1_2= 'Math.max' | lv_name_1_3= 'Math.min' ) ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= ruleExpression ) ) otherlv_6= ')' ) | ( () ( ( (lv_name_8_1= 'Math.abs' | lv_name_8_2= 'Math.floor' | lv_name_8_3= 'Math.cbrt' | lv_name_8_4= 'Math.ceil' | lv_name_8_5= 'Math.exp' | lv_name_8_6= 'Math.sign' | lv_name_8_7= 'Math.sqrt' ) ) ) otherlv_9= '(' ( (lv_arg1_10_0= ruleExpression ) ) otherlv_11= ')' ) )
            {
            // InternalSymboleo.g:3770:2: ( ( () ( ( (lv_name_1_1= 'Math.pow' | lv_name_1_2= 'Math.max' | lv_name_1_3= 'Math.min' ) ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= ruleExpression ) ) otherlv_6= ')' ) | ( () ( ( (lv_name_8_1= 'Math.abs' | lv_name_8_2= 'Math.floor' | lv_name_8_3= 'Math.cbrt' | lv_name_8_4= 'Math.ceil' | lv_name_8_5= 'Math.exp' | lv_name_8_6= 'Math.sign' | lv_name_8_7= 'Math.sqrt' ) ) ) otherlv_9= '(' ( (lv_arg1_10_0= ruleExpression ) ) otherlv_11= ')' ) )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( ((LA65_0>=77 && LA65_0<=79)) ) {
                alt65=1;
            }
            else if ( ((LA65_0>=80 && LA65_0<=86)) ) {
                alt65=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }
            switch (alt65) {
                case 1 :
                    // InternalSymboleo.g:3771:3: ( () ( ( (lv_name_1_1= 'Math.pow' | lv_name_1_2= 'Math.max' | lv_name_1_3= 'Math.min' ) ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= ruleExpression ) ) otherlv_6= ')' )
                    {
                    // InternalSymboleo.g:3771:3: ( () ( ( (lv_name_1_1= 'Math.pow' | lv_name_1_2= 'Math.max' | lv_name_1_3= 'Math.min' ) ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= ruleExpression ) ) otherlv_6= ')' )
                    // InternalSymboleo.g:3772:4: () ( ( (lv_name_1_1= 'Math.pow' | lv_name_1_2= 'Math.max' | lv_name_1_3= 'Math.min' ) ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= ruleExpression ) ) otherlv_6= ')'
                    {
                    // InternalSymboleo.g:3772:4: ()
                    // InternalSymboleo.g:3773:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getMathFunctionAccess().getTwoArgMathFunctionAction_0_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:3779:4: ( ( (lv_name_1_1= 'Math.pow' | lv_name_1_2= 'Math.max' | lv_name_1_3= 'Math.min' ) ) )
                    // InternalSymboleo.g:3780:5: ( (lv_name_1_1= 'Math.pow' | lv_name_1_2= 'Math.max' | lv_name_1_3= 'Math.min' ) )
                    {
                    // InternalSymboleo.g:3780:5: ( (lv_name_1_1= 'Math.pow' | lv_name_1_2= 'Math.max' | lv_name_1_3= 'Math.min' ) )
                    // InternalSymboleo.g:3781:6: (lv_name_1_1= 'Math.pow' | lv_name_1_2= 'Math.max' | lv_name_1_3= 'Math.min' )
                    {
                    // InternalSymboleo.g:3781:6: (lv_name_1_1= 'Math.pow' | lv_name_1_2= 'Math.max' | lv_name_1_3= 'Math.min' )
                    int alt63=3;
                    switch ( input.LA(1) ) {
                    case 77:
                        {
                        alt63=1;
                        }
                        break;
                    case 78:
                        {
                        alt63=2;
                        }
                        break;
                    case 79:
                        {
                        alt63=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 63, 0, input);

                        throw nvae;
                    }

                    switch (alt63) {
                        case 1 :
                            // InternalSymboleo.g:3782:7: lv_name_1_1= 'Math.pow'
                            {
                            lv_name_1_1=(Token)match(input,77,FOLLOW_10); 

                            							newLeafNode(lv_name_1_1, grammarAccess.getMathFunctionAccess().getNameMathPowKeyword_0_1_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getMathFunctionRule());
                            							}
                            							setWithLastConsumed(current, "name", lv_name_1_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSymboleo.g:3793:7: lv_name_1_2= 'Math.max'
                            {
                            lv_name_1_2=(Token)match(input,78,FOLLOW_10); 

                            							newLeafNode(lv_name_1_2, grammarAccess.getMathFunctionAccess().getNameMathMaxKeyword_0_1_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getMathFunctionRule());
                            							}
                            							setWithLastConsumed(current, "name", lv_name_1_2, null);
                            						

                            }
                            break;
                        case 3 :
                            // InternalSymboleo.g:3804:7: lv_name_1_3= 'Math.min'
                            {
                            lv_name_1_3=(Token)match(input,79,FOLLOW_10); 

                            							newLeafNode(lv_name_1_3, grammarAccess.getMathFunctionAccess().getNameMathMinKeyword_0_1_0_2());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getMathFunctionRule());
                            							}
                            							setWithLastConsumed(current, "name", lv_name_1_3, null);
                            						

                            }
                            break;

                    }


                    }


                    }

                    otherlv_2=(Token)match(input,17,FOLLOW_39); 

                    				newLeafNode(otherlv_2, grammarAccess.getMathFunctionAccess().getLeftParenthesisKeyword_0_2());
                    			
                    // InternalSymboleo.g:3821:4: ( (lv_arg1_3_0= ruleExpression ) )
                    // InternalSymboleo.g:3822:5: (lv_arg1_3_0= ruleExpression )
                    {
                    // InternalSymboleo.g:3822:5: (lv_arg1_3_0= ruleExpression )
                    // InternalSymboleo.g:3823:6: lv_arg1_3_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getMathFunctionAccess().getArg1ExpressionParserRuleCall_0_3_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_arg1_3_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMathFunctionRule());
                    						}
                    						set(
                    							current,
                    							"arg1",
                    							lv_arg1_3_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,18,FOLLOW_39); 

                    				newLeafNode(otherlv_4, grammarAccess.getMathFunctionAccess().getCommaKeyword_0_4());
                    			
                    // InternalSymboleo.g:3844:4: ( (lv_arg2_5_0= ruleExpression ) )
                    // InternalSymboleo.g:3845:5: (lv_arg2_5_0= ruleExpression )
                    {
                    // InternalSymboleo.g:3845:5: (lv_arg2_5_0= ruleExpression )
                    // InternalSymboleo.g:3846:6: lv_arg2_5_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getMathFunctionAccess().getArg2ExpressionParserRuleCall_0_5_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_arg2_5_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMathFunctionRule());
                    						}
                    						set(
                    							current,
                    							"arg2",
                    							lv_arg2_5_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_6=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getMathFunctionAccess().getRightParenthesisKeyword_0_6());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:3869:3: ( () ( ( (lv_name_8_1= 'Math.abs' | lv_name_8_2= 'Math.floor' | lv_name_8_3= 'Math.cbrt' | lv_name_8_4= 'Math.ceil' | lv_name_8_5= 'Math.exp' | lv_name_8_6= 'Math.sign' | lv_name_8_7= 'Math.sqrt' ) ) ) otherlv_9= '(' ( (lv_arg1_10_0= ruleExpression ) ) otherlv_11= ')' )
                    {
                    // InternalSymboleo.g:3869:3: ( () ( ( (lv_name_8_1= 'Math.abs' | lv_name_8_2= 'Math.floor' | lv_name_8_3= 'Math.cbrt' | lv_name_8_4= 'Math.ceil' | lv_name_8_5= 'Math.exp' | lv_name_8_6= 'Math.sign' | lv_name_8_7= 'Math.sqrt' ) ) ) otherlv_9= '(' ( (lv_arg1_10_0= ruleExpression ) ) otherlv_11= ')' )
                    // InternalSymboleo.g:3870:4: () ( ( (lv_name_8_1= 'Math.abs' | lv_name_8_2= 'Math.floor' | lv_name_8_3= 'Math.cbrt' | lv_name_8_4= 'Math.ceil' | lv_name_8_5= 'Math.exp' | lv_name_8_6= 'Math.sign' | lv_name_8_7= 'Math.sqrt' ) ) ) otherlv_9= '(' ( (lv_arg1_10_0= ruleExpression ) ) otherlv_11= ')'
                    {
                    // InternalSymboleo.g:3870:4: ()
                    // InternalSymboleo.g:3871:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getMathFunctionAccess().getOneArgMathFunctionAction_1_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:3877:4: ( ( (lv_name_8_1= 'Math.abs' | lv_name_8_2= 'Math.floor' | lv_name_8_3= 'Math.cbrt' | lv_name_8_4= 'Math.ceil' | lv_name_8_5= 'Math.exp' | lv_name_8_6= 'Math.sign' | lv_name_8_7= 'Math.sqrt' ) ) )
                    // InternalSymboleo.g:3878:5: ( (lv_name_8_1= 'Math.abs' | lv_name_8_2= 'Math.floor' | lv_name_8_3= 'Math.cbrt' | lv_name_8_4= 'Math.ceil' | lv_name_8_5= 'Math.exp' | lv_name_8_6= 'Math.sign' | lv_name_8_7= 'Math.sqrt' ) )
                    {
                    // InternalSymboleo.g:3878:5: ( (lv_name_8_1= 'Math.abs' | lv_name_8_2= 'Math.floor' | lv_name_8_3= 'Math.cbrt' | lv_name_8_4= 'Math.ceil' | lv_name_8_5= 'Math.exp' | lv_name_8_6= 'Math.sign' | lv_name_8_7= 'Math.sqrt' ) )
                    // InternalSymboleo.g:3879:6: (lv_name_8_1= 'Math.abs' | lv_name_8_2= 'Math.floor' | lv_name_8_3= 'Math.cbrt' | lv_name_8_4= 'Math.ceil' | lv_name_8_5= 'Math.exp' | lv_name_8_6= 'Math.sign' | lv_name_8_7= 'Math.sqrt' )
                    {
                    // InternalSymboleo.g:3879:6: (lv_name_8_1= 'Math.abs' | lv_name_8_2= 'Math.floor' | lv_name_8_3= 'Math.cbrt' | lv_name_8_4= 'Math.ceil' | lv_name_8_5= 'Math.exp' | lv_name_8_6= 'Math.sign' | lv_name_8_7= 'Math.sqrt' )
                    int alt64=7;
                    switch ( input.LA(1) ) {
                    case 80:
                        {
                        alt64=1;
                        }
                        break;
                    case 81:
                        {
                        alt64=2;
                        }
                        break;
                    case 82:
                        {
                        alt64=3;
                        }
                        break;
                    case 83:
                        {
                        alt64=4;
                        }
                        break;
                    case 84:
                        {
                        alt64=5;
                        }
                        break;
                    case 85:
                        {
                        alt64=6;
                        }
                        break;
                    case 86:
                        {
                        alt64=7;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 64, 0, input);

                        throw nvae;
                    }

                    switch (alt64) {
                        case 1 :
                            // InternalSymboleo.g:3880:7: lv_name_8_1= 'Math.abs'
                            {
                            lv_name_8_1=(Token)match(input,80,FOLLOW_10); 

                            							newLeafNode(lv_name_8_1, grammarAccess.getMathFunctionAccess().getNameMathAbsKeyword_1_1_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getMathFunctionRule());
                            							}
                            							setWithLastConsumed(current, "name", lv_name_8_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSymboleo.g:3891:7: lv_name_8_2= 'Math.floor'
                            {
                            lv_name_8_2=(Token)match(input,81,FOLLOW_10); 

                            							newLeafNode(lv_name_8_2, grammarAccess.getMathFunctionAccess().getNameMathFloorKeyword_1_1_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getMathFunctionRule());
                            							}
                            							setWithLastConsumed(current, "name", lv_name_8_2, null);
                            						

                            }
                            break;
                        case 3 :
                            // InternalSymboleo.g:3902:7: lv_name_8_3= 'Math.cbrt'
                            {
                            lv_name_8_3=(Token)match(input,82,FOLLOW_10); 

                            							newLeafNode(lv_name_8_3, grammarAccess.getMathFunctionAccess().getNameMathCbrtKeyword_1_1_0_2());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getMathFunctionRule());
                            							}
                            							setWithLastConsumed(current, "name", lv_name_8_3, null);
                            						

                            }
                            break;
                        case 4 :
                            // InternalSymboleo.g:3913:7: lv_name_8_4= 'Math.ceil'
                            {
                            lv_name_8_4=(Token)match(input,83,FOLLOW_10); 

                            							newLeafNode(lv_name_8_4, grammarAccess.getMathFunctionAccess().getNameMathCeilKeyword_1_1_0_3());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getMathFunctionRule());
                            							}
                            							setWithLastConsumed(current, "name", lv_name_8_4, null);
                            						

                            }
                            break;
                        case 5 :
                            // InternalSymboleo.g:3924:7: lv_name_8_5= 'Math.exp'
                            {
                            lv_name_8_5=(Token)match(input,84,FOLLOW_10); 

                            							newLeafNode(lv_name_8_5, grammarAccess.getMathFunctionAccess().getNameMathExpKeyword_1_1_0_4());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getMathFunctionRule());
                            							}
                            							setWithLastConsumed(current, "name", lv_name_8_5, null);
                            						

                            }
                            break;
                        case 6 :
                            // InternalSymboleo.g:3935:7: lv_name_8_6= 'Math.sign'
                            {
                            lv_name_8_6=(Token)match(input,85,FOLLOW_10); 

                            							newLeafNode(lv_name_8_6, grammarAccess.getMathFunctionAccess().getNameMathSignKeyword_1_1_0_5());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getMathFunctionRule());
                            							}
                            							setWithLastConsumed(current, "name", lv_name_8_6, null);
                            						

                            }
                            break;
                        case 7 :
                            // InternalSymboleo.g:3946:7: lv_name_8_7= 'Math.sqrt'
                            {
                            lv_name_8_7=(Token)match(input,86,FOLLOW_10); 

                            							newLeafNode(lv_name_8_7, grammarAccess.getMathFunctionAccess().getNameMathSqrtKeyword_1_1_0_6());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getMathFunctionRule());
                            							}
                            							setWithLastConsumed(current, "name", lv_name_8_7, null);
                            						

                            }
                            break;

                    }


                    }


                    }

                    otherlv_9=(Token)match(input,17,FOLLOW_39); 

                    				newLeafNode(otherlv_9, grammarAccess.getMathFunctionAccess().getLeftParenthesisKeyword_1_2());
                    			
                    // InternalSymboleo.g:3963:4: ( (lv_arg1_10_0= ruleExpression ) )
                    // InternalSymboleo.g:3964:5: (lv_arg1_10_0= ruleExpression )
                    {
                    // InternalSymboleo.g:3964:5: (lv_arg1_10_0= ruleExpression )
                    // InternalSymboleo.g:3965:6: lv_arg1_10_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getMathFunctionAccess().getArg1ExpressionParserRuleCall_1_3_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_arg1_10_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMathFunctionRule());
                    						}
                    						set(
                    							current,
                    							"arg1",
                    							lv_arg1_10_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getMathFunctionAccess().getRightParenthesisKeyword_1_4());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMathFunction"


    // $ANTLR start "entryRuleStringFunction"
    // InternalSymboleo.g:3991:1: entryRuleStringFunction returns [EObject current=null] : iv_ruleStringFunction= ruleStringFunction EOF ;
    public final EObject entryRuleStringFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringFunction = null;


        try {
            // InternalSymboleo.g:3991:55: (iv_ruleStringFunction= ruleStringFunction EOF )
            // InternalSymboleo.g:3992:2: iv_ruleStringFunction= ruleStringFunction EOF
            {
             newCompositeNode(grammarAccess.getStringFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStringFunction=ruleStringFunction();

            state._fsp--;

             current =iv_ruleStringFunction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringFunction"


    // $ANTLR start "ruleStringFunction"
    // InternalSymboleo.g:3998:1: ruleStringFunction returns [EObject current=null] : ( ( () ( ( (lv_name_1_1= 'String.substring' | lv_name_1_2= 'String.replaceAll' ) ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= ruleExpression ) ) otherlv_6= ',' ( (lv_arg3_7_0= ruleExpression ) ) otherlv_8= ')' ) | ( () ( (lv_name_10_0= 'String.concat' ) ) otherlv_11= '(' ( (lv_arg1_12_0= ruleExpression ) ) otherlv_13= ',' ( (lv_arg2_14_0= ruleExpression ) ) otherlv_15= ')' ) | ( () ( ( (lv_name_17_1= 'String.toLowerCase' | lv_name_17_2= 'String.toUpperCase' | lv_name_17_3= 'String.trimEnd' | lv_name_17_4= 'String.trimStart' | lv_name_17_5= 'String.trim' ) ) ) otherlv_18= '(' ( (lv_arg1_19_0= ruleExpression ) ) otherlv_20= ')' ) ) ;
    public final EObject ruleStringFunction() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_1=null;
        Token lv_name_1_2=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token lv_name_10_0=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token lv_name_17_1=null;
        Token lv_name_17_2=null;
        Token lv_name_17_3=null;
        Token lv_name_17_4=null;
        Token lv_name_17_5=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        EObject lv_arg1_3_0 = null;

        EObject lv_arg2_5_0 = null;

        EObject lv_arg3_7_0 = null;

        EObject lv_arg1_12_0 = null;

        EObject lv_arg2_14_0 = null;

        EObject lv_arg1_19_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:4004:2: ( ( ( () ( ( (lv_name_1_1= 'String.substring' | lv_name_1_2= 'String.replaceAll' ) ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= ruleExpression ) ) otherlv_6= ',' ( (lv_arg3_7_0= ruleExpression ) ) otherlv_8= ')' ) | ( () ( (lv_name_10_0= 'String.concat' ) ) otherlv_11= '(' ( (lv_arg1_12_0= ruleExpression ) ) otherlv_13= ',' ( (lv_arg2_14_0= ruleExpression ) ) otherlv_15= ')' ) | ( () ( ( (lv_name_17_1= 'String.toLowerCase' | lv_name_17_2= 'String.toUpperCase' | lv_name_17_3= 'String.trimEnd' | lv_name_17_4= 'String.trimStart' | lv_name_17_5= 'String.trim' ) ) ) otherlv_18= '(' ( (lv_arg1_19_0= ruleExpression ) ) otherlv_20= ')' ) ) )
            // InternalSymboleo.g:4005:2: ( ( () ( ( (lv_name_1_1= 'String.substring' | lv_name_1_2= 'String.replaceAll' ) ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= ruleExpression ) ) otherlv_6= ',' ( (lv_arg3_7_0= ruleExpression ) ) otherlv_8= ')' ) | ( () ( (lv_name_10_0= 'String.concat' ) ) otherlv_11= '(' ( (lv_arg1_12_0= ruleExpression ) ) otherlv_13= ',' ( (lv_arg2_14_0= ruleExpression ) ) otherlv_15= ')' ) | ( () ( ( (lv_name_17_1= 'String.toLowerCase' | lv_name_17_2= 'String.toUpperCase' | lv_name_17_3= 'String.trimEnd' | lv_name_17_4= 'String.trimStart' | lv_name_17_5= 'String.trim' ) ) ) otherlv_18= '(' ( (lv_arg1_19_0= ruleExpression ) ) otherlv_20= ')' ) )
            {
            // InternalSymboleo.g:4005:2: ( ( () ( ( (lv_name_1_1= 'String.substring' | lv_name_1_2= 'String.replaceAll' ) ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= ruleExpression ) ) otherlv_6= ',' ( (lv_arg3_7_0= ruleExpression ) ) otherlv_8= ')' ) | ( () ( (lv_name_10_0= 'String.concat' ) ) otherlv_11= '(' ( (lv_arg1_12_0= ruleExpression ) ) otherlv_13= ',' ( (lv_arg2_14_0= ruleExpression ) ) otherlv_15= ')' ) | ( () ( ( (lv_name_17_1= 'String.toLowerCase' | lv_name_17_2= 'String.toUpperCase' | lv_name_17_3= 'String.trimEnd' | lv_name_17_4= 'String.trimStart' | lv_name_17_5= 'String.trim' ) ) ) otherlv_18= '(' ( (lv_arg1_19_0= ruleExpression ) ) otherlv_20= ')' ) )
            int alt68=3;
            switch ( input.LA(1) ) {
            case 87:
            case 88:
                {
                alt68=1;
                }
                break;
            case 89:
                {
                alt68=2;
                }
                break;
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
                {
                alt68=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }

            switch (alt68) {
                case 1 :
                    // InternalSymboleo.g:4006:3: ( () ( ( (lv_name_1_1= 'String.substring' | lv_name_1_2= 'String.replaceAll' ) ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= ruleExpression ) ) otherlv_6= ',' ( (lv_arg3_7_0= ruleExpression ) ) otherlv_8= ')' )
                    {
                    // InternalSymboleo.g:4006:3: ( () ( ( (lv_name_1_1= 'String.substring' | lv_name_1_2= 'String.replaceAll' ) ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= ruleExpression ) ) otherlv_6= ',' ( (lv_arg3_7_0= ruleExpression ) ) otherlv_8= ')' )
                    // InternalSymboleo.g:4007:4: () ( ( (lv_name_1_1= 'String.substring' | lv_name_1_2= 'String.replaceAll' ) ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= ruleExpression ) ) otherlv_6= ',' ( (lv_arg3_7_0= ruleExpression ) ) otherlv_8= ')'
                    {
                    // InternalSymboleo.g:4007:4: ()
                    // InternalSymboleo.g:4008:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getStringFunctionAccess().getThreeArgStringFunctionAction_0_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:4014:4: ( ( (lv_name_1_1= 'String.substring' | lv_name_1_2= 'String.replaceAll' ) ) )
                    // InternalSymboleo.g:4015:5: ( (lv_name_1_1= 'String.substring' | lv_name_1_2= 'String.replaceAll' ) )
                    {
                    // InternalSymboleo.g:4015:5: ( (lv_name_1_1= 'String.substring' | lv_name_1_2= 'String.replaceAll' ) )
                    // InternalSymboleo.g:4016:6: (lv_name_1_1= 'String.substring' | lv_name_1_2= 'String.replaceAll' )
                    {
                    // InternalSymboleo.g:4016:6: (lv_name_1_1= 'String.substring' | lv_name_1_2= 'String.replaceAll' )
                    int alt66=2;
                    int LA66_0 = input.LA(1);

                    if ( (LA66_0==87) ) {
                        alt66=1;
                    }
                    else if ( (LA66_0==88) ) {
                        alt66=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 66, 0, input);

                        throw nvae;
                    }
                    switch (alt66) {
                        case 1 :
                            // InternalSymboleo.g:4017:7: lv_name_1_1= 'String.substring'
                            {
                            lv_name_1_1=(Token)match(input,87,FOLLOW_10); 

                            							newLeafNode(lv_name_1_1, grammarAccess.getStringFunctionAccess().getNameStringSubstringKeyword_0_1_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getStringFunctionRule());
                            							}
                            							setWithLastConsumed(current, "name", lv_name_1_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSymboleo.g:4028:7: lv_name_1_2= 'String.replaceAll'
                            {
                            lv_name_1_2=(Token)match(input,88,FOLLOW_10); 

                            							newLeafNode(lv_name_1_2, grammarAccess.getStringFunctionAccess().getNameStringReplaceAllKeyword_0_1_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getStringFunctionRule());
                            							}
                            							setWithLastConsumed(current, "name", lv_name_1_2, null);
                            						

                            }
                            break;

                    }


                    }


                    }

                    otherlv_2=(Token)match(input,17,FOLLOW_39); 

                    				newLeafNode(otherlv_2, grammarAccess.getStringFunctionAccess().getLeftParenthesisKeyword_0_2());
                    			
                    // InternalSymboleo.g:4045:4: ( (lv_arg1_3_0= ruleExpression ) )
                    // InternalSymboleo.g:4046:5: (lv_arg1_3_0= ruleExpression )
                    {
                    // InternalSymboleo.g:4046:5: (lv_arg1_3_0= ruleExpression )
                    // InternalSymboleo.g:4047:6: lv_arg1_3_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getStringFunctionAccess().getArg1ExpressionParserRuleCall_0_3_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_arg1_3_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStringFunctionRule());
                    						}
                    						set(
                    							current,
                    							"arg1",
                    							lv_arg1_3_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,18,FOLLOW_39); 

                    				newLeafNode(otherlv_4, grammarAccess.getStringFunctionAccess().getCommaKeyword_0_4());
                    			
                    // InternalSymboleo.g:4068:4: ( (lv_arg2_5_0= ruleExpression ) )
                    // InternalSymboleo.g:4069:5: (lv_arg2_5_0= ruleExpression )
                    {
                    // InternalSymboleo.g:4069:5: (lv_arg2_5_0= ruleExpression )
                    // InternalSymboleo.g:4070:6: lv_arg2_5_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getStringFunctionAccess().getArg2ExpressionParserRuleCall_0_5_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_arg2_5_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStringFunctionRule());
                    						}
                    						set(
                    							current,
                    							"arg2",
                    							lv_arg2_5_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_6=(Token)match(input,18,FOLLOW_39); 

                    				newLeafNode(otherlv_6, grammarAccess.getStringFunctionAccess().getCommaKeyword_0_6());
                    			
                    // InternalSymboleo.g:4091:4: ( (lv_arg3_7_0= ruleExpression ) )
                    // InternalSymboleo.g:4092:5: (lv_arg3_7_0= ruleExpression )
                    {
                    // InternalSymboleo.g:4092:5: (lv_arg3_7_0= ruleExpression )
                    // InternalSymboleo.g:4093:6: lv_arg3_7_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getStringFunctionAccess().getArg3ExpressionParserRuleCall_0_7_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_arg3_7_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStringFunctionRule());
                    						}
                    						set(
                    							current,
                    							"arg3",
                    							lv_arg3_7_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_8=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_8, grammarAccess.getStringFunctionAccess().getRightParenthesisKeyword_0_8());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:4116:3: ( () ( (lv_name_10_0= 'String.concat' ) ) otherlv_11= '(' ( (lv_arg1_12_0= ruleExpression ) ) otherlv_13= ',' ( (lv_arg2_14_0= ruleExpression ) ) otherlv_15= ')' )
                    {
                    // InternalSymboleo.g:4116:3: ( () ( (lv_name_10_0= 'String.concat' ) ) otherlv_11= '(' ( (lv_arg1_12_0= ruleExpression ) ) otherlv_13= ',' ( (lv_arg2_14_0= ruleExpression ) ) otherlv_15= ')' )
                    // InternalSymboleo.g:4117:4: () ( (lv_name_10_0= 'String.concat' ) ) otherlv_11= '(' ( (lv_arg1_12_0= ruleExpression ) ) otherlv_13= ',' ( (lv_arg2_14_0= ruleExpression ) ) otherlv_15= ')'
                    {
                    // InternalSymboleo.g:4117:4: ()
                    // InternalSymboleo.g:4118:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getStringFunctionAccess().getTwoArgStringFunctionAction_1_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:4124:4: ( (lv_name_10_0= 'String.concat' ) )
                    // InternalSymboleo.g:4125:5: (lv_name_10_0= 'String.concat' )
                    {
                    // InternalSymboleo.g:4125:5: (lv_name_10_0= 'String.concat' )
                    // InternalSymboleo.g:4126:6: lv_name_10_0= 'String.concat'
                    {
                    lv_name_10_0=(Token)match(input,89,FOLLOW_10); 

                    						newLeafNode(lv_name_10_0, grammarAccess.getStringFunctionAccess().getNameStringConcatKeyword_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStringFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_10_0, "String.concat");
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,17,FOLLOW_39); 

                    				newLeafNode(otherlv_11, grammarAccess.getStringFunctionAccess().getLeftParenthesisKeyword_1_2());
                    			
                    // InternalSymboleo.g:4142:4: ( (lv_arg1_12_0= ruleExpression ) )
                    // InternalSymboleo.g:4143:5: (lv_arg1_12_0= ruleExpression )
                    {
                    // InternalSymboleo.g:4143:5: (lv_arg1_12_0= ruleExpression )
                    // InternalSymboleo.g:4144:6: lv_arg1_12_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getStringFunctionAccess().getArg1ExpressionParserRuleCall_1_3_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_arg1_12_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStringFunctionRule());
                    						}
                    						set(
                    							current,
                    							"arg1",
                    							lv_arg1_12_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_13=(Token)match(input,18,FOLLOW_39); 

                    				newLeafNode(otherlv_13, grammarAccess.getStringFunctionAccess().getCommaKeyword_1_4());
                    			
                    // InternalSymboleo.g:4165:4: ( (lv_arg2_14_0= ruleExpression ) )
                    // InternalSymboleo.g:4166:5: (lv_arg2_14_0= ruleExpression )
                    {
                    // InternalSymboleo.g:4166:5: (lv_arg2_14_0= ruleExpression )
                    // InternalSymboleo.g:4167:6: lv_arg2_14_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getStringFunctionAccess().getArg2ExpressionParserRuleCall_1_5_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_arg2_14_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStringFunctionRule());
                    						}
                    						set(
                    							current,
                    							"arg2",
                    							lv_arg2_14_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_15=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_15, grammarAccess.getStringFunctionAccess().getRightParenthesisKeyword_1_6());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:4190:3: ( () ( ( (lv_name_17_1= 'String.toLowerCase' | lv_name_17_2= 'String.toUpperCase' | lv_name_17_3= 'String.trimEnd' | lv_name_17_4= 'String.trimStart' | lv_name_17_5= 'String.trim' ) ) ) otherlv_18= '(' ( (lv_arg1_19_0= ruleExpression ) ) otherlv_20= ')' )
                    {
                    // InternalSymboleo.g:4190:3: ( () ( ( (lv_name_17_1= 'String.toLowerCase' | lv_name_17_2= 'String.toUpperCase' | lv_name_17_3= 'String.trimEnd' | lv_name_17_4= 'String.trimStart' | lv_name_17_5= 'String.trim' ) ) ) otherlv_18= '(' ( (lv_arg1_19_0= ruleExpression ) ) otherlv_20= ')' )
                    // InternalSymboleo.g:4191:4: () ( ( (lv_name_17_1= 'String.toLowerCase' | lv_name_17_2= 'String.toUpperCase' | lv_name_17_3= 'String.trimEnd' | lv_name_17_4= 'String.trimStart' | lv_name_17_5= 'String.trim' ) ) ) otherlv_18= '(' ( (lv_arg1_19_0= ruleExpression ) ) otherlv_20= ')'
                    {
                    // InternalSymboleo.g:4191:4: ()
                    // InternalSymboleo.g:4192:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getStringFunctionAccess().getOneArgStringFunctionAction_2_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:4198:4: ( ( (lv_name_17_1= 'String.toLowerCase' | lv_name_17_2= 'String.toUpperCase' | lv_name_17_3= 'String.trimEnd' | lv_name_17_4= 'String.trimStart' | lv_name_17_5= 'String.trim' ) ) )
                    // InternalSymboleo.g:4199:5: ( (lv_name_17_1= 'String.toLowerCase' | lv_name_17_2= 'String.toUpperCase' | lv_name_17_3= 'String.trimEnd' | lv_name_17_4= 'String.trimStart' | lv_name_17_5= 'String.trim' ) )
                    {
                    // InternalSymboleo.g:4199:5: ( (lv_name_17_1= 'String.toLowerCase' | lv_name_17_2= 'String.toUpperCase' | lv_name_17_3= 'String.trimEnd' | lv_name_17_4= 'String.trimStart' | lv_name_17_5= 'String.trim' ) )
                    // InternalSymboleo.g:4200:6: (lv_name_17_1= 'String.toLowerCase' | lv_name_17_2= 'String.toUpperCase' | lv_name_17_3= 'String.trimEnd' | lv_name_17_4= 'String.trimStart' | lv_name_17_5= 'String.trim' )
                    {
                    // InternalSymboleo.g:4200:6: (lv_name_17_1= 'String.toLowerCase' | lv_name_17_2= 'String.toUpperCase' | lv_name_17_3= 'String.trimEnd' | lv_name_17_4= 'String.trimStart' | lv_name_17_5= 'String.trim' )
                    int alt67=5;
                    switch ( input.LA(1) ) {
                    case 90:
                        {
                        alt67=1;
                        }
                        break;
                    case 91:
                        {
                        alt67=2;
                        }
                        break;
                    case 92:
                        {
                        alt67=3;
                        }
                        break;
                    case 93:
                        {
                        alt67=4;
                        }
                        break;
                    case 94:
                        {
                        alt67=5;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 67, 0, input);

                        throw nvae;
                    }

                    switch (alt67) {
                        case 1 :
                            // InternalSymboleo.g:4201:7: lv_name_17_1= 'String.toLowerCase'
                            {
                            lv_name_17_1=(Token)match(input,90,FOLLOW_10); 

                            							newLeafNode(lv_name_17_1, grammarAccess.getStringFunctionAccess().getNameStringToLowerCaseKeyword_2_1_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getStringFunctionRule());
                            							}
                            							setWithLastConsumed(current, "name", lv_name_17_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalSymboleo.g:4212:7: lv_name_17_2= 'String.toUpperCase'
                            {
                            lv_name_17_2=(Token)match(input,91,FOLLOW_10); 

                            							newLeafNode(lv_name_17_2, grammarAccess.getStringFunctionAccess().getNameStringToUpperCaseKeyword_2_1_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getStringFunctionRule());
                            							}
                            							setWithLastConsumed(current, "name", lv_name_17_2, null);
                            						

                            }
                            break;
                        case 3 :
                            // InternalSymboleo.g:4223:7: lv_name_17_3= 'String.trimEnd'
                            {
                            lv_name_17_3=(Token)match(input,92,FOLLOW_10); 

                            							newLeafNode(lv_name_17_3, grammarAccess.getStringFunctionAccess().getNameStringTrimEndKeyword_2_1_0_2());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getStringFunctionRule());
                            							}
                            							setWithLastConsumed(current, "name", lv_name_17_3, null);
                            						

                            }
                            break;
                        case 4 :
                            // InternalSymboleo.g:4234:7: lv_name_17_4= 'String.trimStart'
                            {
                            lv_name_17_4=(Token)match(input,93,FOLLOW_10); 

                            							newLeafNode(lv_name_17_4, grammarAccess.getStringFunctionAccess().getNameStringTrimStartKeyword_2_1_0_3());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getStringFunctionRule());
                            							}
                            							setWithLastConsumed(current, "name", lv_name_17_4, null);
                            						

                            }
                            break;
                        case 5 :
                            // InternalSymboleo.g:4245:7: lv_name_17_5= 'String.trim'
                            {
                            lv_name_17_5=(Token)match(input,94,FOLLOW_10); 

                            							newLeafNode(lv_name_17_5, grammarAccess.getStringFunctionAccess().getNameStringTrimKeyword_2_1_0_4());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getStringFunctionRule());
                            							}
                            							setWithLastConsumed(current, "name", lv_name_17_5, null);
                            						

                            }
                            break;

                    }


                    }


                    }

                    otherlv_18=(Token)match(input,17,FOLLOW_39); 

                    				newLeafNode(otherlv_18, grammarAccess.getStringFunctionAccess().getLeftParenthesisKeyword_2_2());
                    			
                    // InternalSymboleo.g:4262:4: ( (lv_arg1_19_0= ruleExpression ) )
                    // InternalSymboleo.g:4263:5: (lv_arg1_19_0= ruleExpression )
                    {
                    // InternalSymboleo.g:4263:5: (lv_arg1_19_0= ruleExpression )
                    // InternalSymboleo.g:4264:6: lv_arg1_19_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getStringFunctionAccess().getArg1ExpressionParserRuleCall_2_3_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_arg1_19_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStringFunctionRule());
                    						}
                    						set(
                    							current,
                    							"arg1",
                    							lv_arg1_19_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_20=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_20, grammarAccess.getStringFunctionAccess().getRightParenthesisKeyword_2_4());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringFunction"


    // $ANTLR start "entryRuleDateFunction"
    // InternalSymboleo.g:4290:1: entryRuleDateFunction returns [EObject current=null] : iv_ruleDateFunction= ruleDateFunction EOF ;
    public final EObject entryRuleDateFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDateFunction = null;


        try {
            // InternalSymboleo.g:4290:53: (iv_ruleDateFunction= ruleDateFunction EOF )
            // InternalSymboleo.g:4291:2: iv_ruleDateFunction= ruleDateFunction EOF
            {
             newCompositeNode(grammarAccess.getDateFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDateFunction=ruleDateFunction();

            state._fsp--;

             current =iv_ruleDateFunction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDateFunction"


    // $ANTLR start "ruleDateFunction"
    // InternalSymboleo.g:4297:1: ruleDateFunction returns [EObject current=null] : ( () ( (lv_name_1_0= 'Date.add' ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_value_5_0= ruleExpression ) ) otherlv_6= ',' ( (lv_timeUnit_7_0= ruleTimeUnit ) ) otherlv_8= ')' ) ;
    public final EObject ruleDateFunction() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_arg1_3_0 = null;

        EObject lv_value_5_0 = null;

        AntlrDatatypeRuleToken lv_timeUnit_7_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:4303:2: ( ( () ( (lv_name_1_0= 'Date.add' ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_value_5_0= ruleExpression ) ) otherlv_6= ',' ( (lv_timeUnit_7_0= ruleTimeUnit ) ) otherlv_8= ')' ) )
            // InternalSymboleo.g:4304:2: ( () ( (lv_name_1_0= 'Date.add' ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_value_5_0= ruleExpression ) ) otherlv_6= ',' ( (lv_timeUnit_7_0= ruleTimeUnit ) ) otherlv_8= ')' )
            {
            // InternalSymboleo.g:4304:2: ( () ( (lv_name_1_0= 'Date.add' ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_value_5_0= ruleExpression ) ) otherlv_6= ',' ( (lv_timeUnit_7_0= ruleTimeUnit ) ) otherlv_8= ')' )
            // InternalSymboleo.g:4305:3: () ( (lv_name_1_0= 'Date.add' ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_value_5_0= ruleExpression ) ) otherlv_6= ',' ( (lv_timeUnit_7_0= ruleTimeUnit ) ) otherlv_8= ')'
            {
            // InternalSymboleo.g:4305:3: ()
            // InternalSymboleo.g:4306:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getDateFunctionAccess().getThreeArgDateFunctionAction_0(),
            					current);
            			

            }

            // InternalSymboleo.g:4312:3: ( (lv_name_1_0= 'Date.add' ) )
            // InternalSymboleo.g:4313:4: (lv_name_1_0= 'Date.add' )
            {
            // InternalSymboleo.g:4313:4: (lv_name_1_0= 'Date.add' )
            // InternalSymboleo.g:4314:5: lv_name_1_0= 'Date.add'
            {
            lv_name_1_0=(Token)match(input,95,FOLLOW_10); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDateFunctionAccess().getNameDateAddKeyword_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDateFunctionRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_1_0, "Date.add");
            				

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_39); 

            			newLeafNode(otherlv_2, grammarAccess.getDateFunctionAccess().getLeftParenthesisKeyword_2());
            		
            // InternalSymboleo.g:4330:3: ( (lv_arg1_3_0= ruleExpression ) )
            // InternalSymboleo.g:4331:4: (lv_arg1_3_0= ruleExpression )
            {
            // InternalSymboleo.g:4331:4: (lv_arg1_3_0= ruleExpression )
            // InternalSymboleo.g:4332:5: lv_arg1_3_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getDateFunctionAccess().getArg1ExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_11);
            lv_arg1_3_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDateFunctionRule());
            					}
            					set(
            						current,
            						"arg1",
            						lv_arg1_3_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,18,FOLLOW_39); 

            			newLeafNode(otherlv_4, grammarAccess.getDateFunctionAccess().getCommaKeyword_4());
            		
            // InternalSymboleo.g:4353:3: ( (lv_value_5_0= ruleExpression ) )
            // InternalSymboleo.g:4354:4: (lv_value_5_0= ruleExpression )
            {
            // InternalSymboleo.g:4354:4: (lv_value_5_0= ruleExpression )
            // InternalSymboleo.g:4355:5: lv_value_5_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getDateFunctionAccess().getValueExpressionParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_11);
            lv_value_5_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDateFunctionRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_5_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,18,FOLLOW_8); 

            			newLeafNode(otherlv_6, grammarAccess.getDateFunctionAccess().getCommaKeyword_6());
            		
            // InternalSymboleo.g:4376:3: ( (lv_timeUnit_7_0= ruleTimeUnit ) )
            // InternalSymboleo.g:4377:4: (lv_timeUnit_7_0= ruleTimeUnit )
            {
            // InternalSymboleo.g:4377:4: (lv_timeUnit_7_0= ruleTimeUnit )
            // InternalSymboleo.g:4378:5: lv_timeUnit_7_0= ruleTimeUnit
            {

            					newCompositeNode(grammarAccess.getDateFunctionAccess().getTimeUnitTimeUnitParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_12);
            lv_timeUnit_7_0=ruleTimeUnit();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDateFunctionRule());
            					}
            					set(
            						current,
            						"timeUnit",
            						lv_timeUnit_7_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.TimeUnit");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getDateFunctionAccess().getRightParenthesisKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDateFunction"


    // $ANTLR start "entryRuleObligation"
    // InternalSymboleo.g:4403:1: entryRuleObligation returns [EObject current=null] : iv_ruleObligation= ruleObligation EOF ;
    public final EObject entryRuleObligation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObligation = null;


        try {
            // InternalSymboleo.g:4403:51: (iv_ruleObligation= ruleObligation EOF )
            // InternalSymboleo.g:4404:2: iv_ruleObligation= ruleObligation EOF
            {
             newCompositeNode(grammarAccess.getObligationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleObligation=ruleObligation();

            state._fsp--;

             current =iv_ruleObligation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleObligation"


    // $ANTLR start "ruleObligation"
    // InternalSymboleo.g:4410:1: ruleObligation returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->' )? (otherlv_4= 'O' | otherlv_5= 'Obligation' ) otherlv_6= '(' ( (lv_debtor_7_0= ruleVariableDotExpression ) ) otherlv_8= ',' ( (lv_creditor_9_0= ruleVariableDotExpression ) ) otherlv_10= ',' ( (lv_antecedent_11_0= ruleProposition ) ) otherlv_12= ',' ( (lv_consequent_13_0= ruleProposition ) ) otherlv_14= ')' (otherlv_15= 'with' otherlv_16= 'Controller' ( (lv_controller_17_0= ruleVariableDotExpression ) ) )? ) ;
    public final EObject ruleObligation() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        EObject lv_trigger_2_0 = null;

        EObject lv_debtor_7_0 = null;

        EObject lv_creditor_9_0 = null;

        EObject lv_antecedent_11_0 = null;

        EObject lv_consequent_13_0 = null;

        EObject lv_controller_17_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:4416:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->' )? (otherlv_4= 'O' | otherlv_5= 'Obligation' ) otherlv_6= '(' ( (lv_debtor_7_0= ruleVariableDotExpression ) ) otherlv_8= ',' ( (lv_creditor_9_0= ruleVariableDotExpression ) ) otherlv_10= ',' ( (lv_antecedent_11_0= ruleProposition ) ) otherlv_12= ',' ( (lv_consequent_13_0= ruleProposition ) ) otherlv_14= ')' (otherlv_15= 'with' otherlv_16= 'Controller' ( (lv_controller_17_0= ruleVariableDotExpression ) ) )? ) )
            // InternalSymboleo.g:4417:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->' )? (otherlv_4= 'O' | otherlv_5= 'Obligation' ) otherlv_6= '(' ( (lv_debtor_7_0= ruleVariableDotExpression ) ) otherlv_8= ',' ( (lv_creditor_9_0= ruleVariableDotExpression ) ) otherlv_10= ',' ( (lv_antecedent_11_0= ruleProposition ) ) otherlv_12= ',' ( (lv_consequent_13_0= ruleProposition ) ) otherlv_14= ')' (otherlv_15= 'with' otherlv_16= 'Controller' ( (lv_controller_17_0= ruleVariableDotExpression ) ) )? )
            {
            // InternalSymboleo.g:4417:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->' )? (otherlv_4= 'O' | otherlv_5= 'Obligation' ) otherlv_6= '(' ( (lv_debtor_7_0= ruleVariableDotExpression ) ) otherlv_8= ',' ( (lv_creditor_9_0= ruleVariableDotExpression ) ) otherlv_10= ',' ( (lv_antecedent_11_0= ruleProposition ) ) otherlv_12= ',' ( (lv_consequent_13_0= ruleProposition ) ) otherlv_14= ')' (otherlv_15= 'with' otherlv_16= 'Controller' ( (lv_controller_17_0= ruleVariableDotExpression ) ) )? )
            // InternalSymboleo.g:4418:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->' )? (otherlv_4= 'O' | otherlv_5= 'Obligation' ) otherlv_6= '(' ( (lv_debtor_7_0= ruleVariableDotExpression ) ) otherlv_8= ',' ( (lv_creditor_9_0= ruleVariableDotExpression ) ) otherlv_10= ',' ( (lv_antecedent_11_0= ruleProposition ) ) otherlv_12= ',' ( (lv_consequent_13_0= ruleProposition ) ) otherlv_14= ')' (otherlv_15= 'with' otherlv_16= 'Controller' ( (lv_controller_17_0= ruleVariableDotExpression ) ) )?
            {
            // InternalSymboleo.g:4418:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalSymboleo.g:4419:4: (lv_name_0_0= RULE_ID )
            {
            // InternalSymboleo.g:4419:4: (lv_name_0_0= RULE_ID )
            // InternalSymboleo.g:4420:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_34); 

            					newLeafNode(lv_name_0_0, grammarAccess.getObligationAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getObligationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,33,FOLLOW_60); 

            			newLeafNode(otherlv_1, grammarAccess.getObligationAccess().getColonKeyword_1());
            		
            // InternalSymboleo.g:4440:3: ( ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->' )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( ((LA69_0>=RULE_ID && LA69_0<=RULE_STRING)||LA69_0==17||LA69_0==38||(LA69_0>=74 && LA69_0<=76)||(LA69_0>=107 && LA69_0<=119)) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalSymboleo.g:4441:4: ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->'
                    {
                    // InternalSymboleo.g:4441:4: ( (lv_trigger_2_0= ruleProposition ) )
                    // InternalSymboleo.g:4442:5: (lv_trigger_2_0= ruleProposition )
                    {
                    // InternalSymboleo.g:4442:5: (lv_trigger_2_0= ruleProposition )
                    // InternalSymboleo.g:4443:6: lv_trigger_2_0= ruleProposition
                    {

                    						newCompositeNode(grammarAccess.getObligationAccess().getTriggerPropositionParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_61);
                    lv_trigger_2_0=ruleProposition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getObligationRule());
                    						}
                    						set(
                    							current,
                    							"trigger",
                    							lv_trigger_2_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Proposition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,96,FOLLOW_62); 

                    				newLeafNode(otherlv_3, grammarAccess.getObligationAccess().getHyphenMinusGreaterThanSignKeyword_2_1());
                    			

                    }
                    break;

            }

            // InternalSymboleo.g:4465:3: (otherlv_4= 'O' | otherlv_5= 'Obligation' )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==97) ) {
                alt70=1;
            }
            else if ( (LA70_0==98) ) {
                alt70=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }
            switch (alt70) {
                case 1 :
                    // InternalSymboleo.g:4466:4: otherlv_4= 'O'
                    {
                    otherlv_4=(Token)match(input,97,FOLLOW_10); 

                    				newLeafNode(otherlv_4, grammarAccess.getObligationAccess().getOKeyword_3_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:4471:4: otherlv_5= 'Obligation'
                    {
                    otherlv_5=(Token)match(input,98,FOLLOW_10); 

                    				newLeafNode(otherlv_5, grammarAccess.getObligationAccess().getObligationKeyword_3_1());
                    			

                    }
                    break;

            }

            otherlv_6=(Token)match(input,17,FOLLOW_3); 

            			newLeafNode(otherlv_6, grammarAccess.getObligationAccess().getLeftParenthesisKeyword_4());
            		
            // InternalSymboleo.g:4480:3: ( (lv_debtor_7_0= ruleVariableDotExpression ) )
            // InternalSymboleo.g:4481:4: (lv_debtor_7_0= ruleVariableDotExpression )
            {
            // InternalSymboleo.g:4481:4: (lv_debtor_7_0= ruleVariableDotExpression )
            // InternalSymboleo.g:4482:5: lv_debtor_7_0= ruleVariableDotExpression
            {

            					newCompositeNode(grammarAccess.getObligationAccess().getDebtorVariableDotExpressionParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_11);
            lv_debtor_7_0=ruleVariableDotExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getObligationRule());
            					}
            					set(
            						current,
            						"debtor",
            						lv_debtor_7_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.VariableDotExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,18,FOLLOW_3); 

            			newLeafNode(otherlv_8, grammarAccess.getObligationAccess().getCommaKeyword_6());
            		
            // InternalSymboleo.g:4503:3: ( (lv_creditor_9_0= ruleVariableDotExpression ) )
            // InternalSymboleo.g:4504:4: (lv_creditor_9_0= ruleVariableDotExpression )
            {
            // InternalSymboleo.g:4504:4: (lv_creditor_9_0= ruleVariableDotExpression )
            // InternalSymboleo.g:4505:5: lv_creditor_9_0= ruleVariableDotExpression
            {

            					newCompositeNode(grammarAccess.getObligationAccess().getCreditorVariableDotExpressionParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_11);
            lv_creditor_9_0=ruleVariableDotExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getObligationRule());
            					}
            					set(
            						current,
            						"creditor",
            						lv_creditor_9_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.VariableDotExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_10=(Token)match(input,18,FOLLOW_63); 

            			newLeafNode(otherlv_10, grammarAccess.getObligationAccess().getCommaKeyword_8());
            		
            // InternalSymboleo.g:4526:3: ( (lv_antecedent_11_0= ruleProposition ) )
            // InternalSymboleo.g:4527:4: (lv_antecedent_11_0= ruleProposition )
            {
            // InternalSymboleo.g:4527:4: (lv_antecedent_11_0= ruleProposition )
            // InternalSymboleo.g:4528:5: lv_antecedent_11_0= ruleProposition
            {

            					newCompositeNode(grammarAccess.getObligationAccess().getAntecedentPropositionParserRuleCall_9_0());
            				
            pushFollow(FOLLOW_11);
            lv_antecedent_11_0=ruleProposition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getObligationRule());
            					}
            					set(
            						current,
            						"antecedent",
            						lv_antecedent_11_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.Proposition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_12=(Token)match(input,18,FOLLOW_63); 

            			newLeafNode(otherlv_12, grammarAccess.getObligationAccess().getCommaKeyword_10());
            		
            // InternalSymboleo.g:4549:3: ( (lv_consequent_13_0= ruleProposition ) )
            // InternalSymboleo.g:4550:4: (lv_consequent_13_0= ruleProposition )
            {
            // InternalSymboleo.g:4550:4: (lv_consequent_13_0= ruleProposition )
            // InternalSymboleo.g:4551:5: lv_consequent_13_0= ruleProposition
            {

            					newCompositeNode(grammarAccess.getObligationAccess().getConsequentPropositionParserRuleCall_11_0());
            				
            pushFollow(FOLLOW_12);
            lv_consequent_13_0=ruleProposition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getObligationRule());
            					}
            					set(
            						current,
            						"consequent",
            						lv_consequent_13_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.Proposition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_14=(Token)match(input,19,FOLLOW_31); 

            			newLeafNode(otherlv_14, grammarAccess.getObligationAccess().getRightParenthesisKeyword_12());
            		
            // InternalSymboleo.g:4572:3: (otherlv_15= 'with' otherlv_16= 'Controller' ( (lv_controller_17_0= ruleVariableDotExpression ) ) )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==32) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalSymboleo.g:4573:4: otherlv_15= 'with' otherlv_16= 'Controller' ( (lv_controller_17_0= ruleVariableDotExpression ) )
                    {
                    otherlv_15=(Token)match(input,32,FOLLOW_41); 

                    				newLeafNode(otherlv_15, grammarAccess.getObligationAccess().getWithKeyword_13_0());
                    			
                    otherlv_16=(Token)match(input,45,FOLLOW_3); 

                    				newLeafNode(otherlv_16, grammarAccess.getObligationAccess().getControllerKeyword_13_1());
                    			
                    // InternalSymboleo.g:4581:4: ( (lv_controller_17_0= ruleVariableDotExpression ) )
                    // InternalSymboleo.g:4582:5: (lv_controller_17_0= ruleVariableDotExpression )
                    {
                    // InternalSymboleo.g:4582:5: (lv_controller_17_0= ruleVariableDotExpression )
                    // InternalSymboleo.g:4583:6: lv_controller_17_0= ruleVariableDotExpression
                    {

                    						newCompositeNode(grammarAccess.getObligationAccess().getControllerVariableDotExpressionParserRuleCall_13_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_controller_17_0=ruleVariableDotExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getObligationRule());
                    						}
                    						set(
                    							current,
                    							"controller",
                    							lv_controller_17_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.VariableDotExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleObligation"


    // $ANTLR start "entryRulePower"
    // InternalSymboleo.g:4605:1: entryRulePower returns [EObject current=null] : iv_rulePower= rulePower EOF ;
    public final EObject entryRulePower() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePower = null;


        try {
            // InternalSymboleo.g:4605:46: (iv_rulePower= rulePower EOF )
            // InternalSymboleo.g:4606:2: iv_rulePower= rulePower EOF
            {
             newCompositeNode(grammarAccess.getPowerRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePower=rulePower();

            state._fsp--;

             current =iv_rulePower; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePower"


    // $ANTLR start "rulePower"
    // InternalSymboleo.g:4612:1: rulePower returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->' )? (otherlv_4= 'P' | otherlv_5= 'Power' ) otherlv_6= '(' ( (lv_creditor_7_0= ruleVariableDotExpression ) ) otherlv_8= ',' ( (lv_debtor_9_0= ruleVariableDotExpression ) ) otherlv_10= ',' ( (lv_antecedent_11_0= ruleProposition ) ) otherlv_12= ',' ( (lv_consequent_13_0= rulePowerFunction ) ) otherlv_14= ')' (otherlv_15= 'with' otherlv_16= 'Controller' ( (lv_controller_17_0= ruleVariableDotExpression ) ) )? ) ;
    public final EObject rulePower() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        EObject lv_trigger_2_0 = null;

        EObject lv_creditor_7_0 = null;

        EObject lv_debtor_9_0 = null;

        EObject lv_antecedent_11_0 = null;

        EObject lv_consequent_13_0 = null;

        EObject lv_controller_17_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:4618:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->' )? (otherlv_4= 'P' | otherlv_5= 'Power' ) otherlv_6= '(' ( (lv_creditor_7_0= ruleVariableDotExpression ) ) otherlv_8= ',' ( (lv_debtor_9_0= ruleVariableDotExpression ) ) otherlv_10= ',' ( (lv_antecedent_11_0= ruleProposition ) ) otherlv_12= ',' ( (lv_consequent_13_0= rulePowerFunction ) ) otherlv_14= ')' (otherlv_15= 'with' otherlv_16= 'Controller' ( (lv_controller_17_0= ruleVariableDotExpression ) ) )? ) )
            // InternalSymboleo.g:4619:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->' )? (otherlv_4= 'P' | otherlv_5= 'Power' ) otherlv_6= '(' ( (lv_creditor_7_0= ruleVariableDotExpression ) ) otherlv_8= ',' ( (lv_debtor_9_0= ruleVariableDotExpression ) ) otherlv_10= ',' ( (lv_antecedent_11_0= ruleProposition ) ) otherlv_12= ',' ( (lv_consequent_13_0= rulePowerFunction ) ) otherlv_14= ')' (otherlv_15= 'with' otherlv_16= 'Controller' ( (lv_controller_17_0= ruleVariableDotExpression ) ) )? )
            {
            // InternalSymboleo.g:4619:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->' )? (otherlv_4= 'P' | otherlv_5= 'Power' ) otherlv_6= '(' ( (lv_creditor_7_0= ruleVariableDotExpression ) ) otherlv_8= ',' ( (lv_debtor_9_0= ruleVariableDotExpression ) ) otherlv_10= ',' ( (lv_antecedent_11_0= ruleProposition ) ) otherlv_12= ',' ( (lv_consequent_13_0= rulePowerFunction ) ) otherlv_14= ')' (otherlv_15= 'with' otherlv_16= 'Controller' ( (lv_controller_17_0= ruleVariableDotExpression ) ) )? )
            // InternalSymboleo.g:4620:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->' )? (otherlv_4= 'P' | otherlv_5= 'Power' ) otherlv_6= '(' ( (lv_creditor_7_0= ruleVariableDotExpression ) ) otherlv_8= ',' ( (lv_debtor_9_0= ruleVariableDotExpression ) ) otherlv_10= ',' ( (lv_antecedent_11_0= ruleProposition ) ) otherlv_12= ',' ( (lv_consequent_13_0= rulePowerFunction ) ) otherlv_14= ')' (otherlv_15= 'with' otherlv_16= 'Controller' ( (lv_controller_17_0= ruleVariableDotExpression ) ) )?
            {
            // InternalSymboleo.g:4620:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalSymboleo.g:4621:4: (lv_name_0_0= RULE_ID )
            {
            // InternalSymboleo.g:4621:4: (lv_name_0_0= RULE_ID )
            // InternalSymboleo.g:4622:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_34); 

            					newLeafNode(lv_name_0_0, grammarAccess.getPowerAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPowerRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,33,FOLLOW_64); 

            			newLeafNode(otherlv_1, grammarAccess.getPowerAccess().getColonKeyword_1());
            		
            // InternalSymboleo.g:4642:3: ( ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->' )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( ((LA72_0>=RULE_ID && LA72_0<=RULE_STRING)||LA72_0==17||LA72_0==38||(LA72_0>=74 && LA72_0<=76)||(LA72_0>=107 && LA72_0<=119)) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // InternalSymboleo.g:4643:4: ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->'
                    {
                    // InternalSymboleo.g:4643:4: ( (lv_trigger_2_0= ruleProposition ) )
                    // InternalSymboleo.g:4644:5: (lv_trigger_2_0= ruleProposition )
                    {
                    // InternalSymboleo.g:4644:5: (lv_trigger_2_0= ruleProposition )
                    // InternalSymboleo.g:4645:6: lv_trigger_2_0= ruleProposition
                    {

                    						newCompositeNode(grammarAccess.getPowerAccess().getTriggerPropositionParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_61);
                    lv_trigger_2_0=ruleProposition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPowerRule());
                    						}
                    						set(
                    							current,
                    							"trigger",
                    							lv_trigger_2_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Proposition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,96,FOLLOW_65); 

                    				newLeafNode(otherlv_3, grammarAccess.getPowerAccess().getHyphenMinusGreaterThanSignKeyword_2_1());
                    			

                    }
                    break;

            }

            // InternalSymboleo.g:4667:3: (otherlv_4= 'P' | otherlv_5= 'Power' )
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==99) ) {
                alt73=1;
            }
            else if ( (LA73_0==100) ) {
                alt73=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;
            }
            switch (alt73) {
                case 1 :
                    // InternalSymboleo.g:4668:4: otherlv_4= 'P'
                    {
                    otherlv_4=(Token)match(input,99,FOLLOW_10); 

                    				newLeafNode(otherlv_4, grammarAccess.getPowerAccess().getPKeyword_3_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:4673:4: otherlv_5= 'Power'
                    {
                    otherlv_5=(Token)match(input,100,FOLLOW_10); 

                    				newLeafNode(otherlv_5, grammarAccess.getPowerAccess().getPowerKeyword_3_1());
                    			

                    }
                    break;

            }

            otherlv_6=(Token)match(input,17,FOLLOW_3); 

            			newLeafNode(otherlv_6, grammarAccess.getPowerAccess().getLeftParenthesisKeyword_4());
            		
            // InternalSymboleo.g:4682:3: ( (lv_creditor_7_0= ruleVariableDotExpression ) )
            // InternalSymboleo.g:4683:4: (lv_creditor_7_0= ruleVariableDotExpression )
            {
            // InternalSymboleo.g:4683:4: (lv_creditor_7_0= ruleVariableDotExpression )
            // InternalSymboleo.g:4684:5: lv_creditor_7_0= ruleVariableDotExpression
            {

            					newCompositeNode(grammarAccess.getPowerAccess().getCreditorVariableDotExpressionParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_11);
            lv_creditor_7_0=ruleVariableDotExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPowerRule());
            					}
            					set(
            						current,
            						"creditor",
            						lv_creditor_7_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.VariableDotExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,18,FOLLOW_3); 

            			newLeafNode(otherlv_8, grammarAccess.getPowerAccess().getCommaKeyword_6());
            		
            // InternalSymboleo.g:4705:3: ( (lv_debtor_9_0= ruleVariableDotExpression ) )
            // InternalSymboleo.g:4706:4: (lv_debtor_9_0= ruleVariableDotExpression )
            {
            // InternalSymboleo.g:4706:4: (lv_debtor_9_0= ruleVariableDotExpression )
            // InternalSymboleo.g:4707:5: lv_debtor_9_0= ruleVariableDotExpression
            {

            					newCompositeNode(grammarAccess.getPowerAccess().getDebtorVariableDotExpressionParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_11);
            lv_debtor_9_0=ruleVariableDotExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPowerRule());
            					}
            					set(
            						current,
            						"debtor",
            						lv_debtor_9_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.VariableDotExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_10=(Token)match(input,18,FOLLOW_63); 

            			newLeafNode(otherlv_10, grammarAccess.getPowerAccess().getCommaKeyword_8());
            		
            // InternalSymboleo.g:4728:3: ( (lv_antecedent_11_0= ruleProposition ) )
            // InternalSymboleo.g:4729:4: (lv_antecedent_11_0= ruleProposition )
            {
            // InternalSymboleo.g:4729:4: (lv_antecedent_11_0= ruleProposition )
            // InternalSymboleo.g:4730:5: lv_antecedent_11_0= ruleProposition
            {

            					newCompositeNode(grammarAccess.getPowerAccess().getAntecedentPropositionParserRuleCall_9_0());
            				
            pushFollow(FOLLOW_11);
            lv_antecedent_11_0=ruleProposition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPowerRule());
            					}
            					set(
            						current,
            						"antecedent",
            						lv_antecedent_11_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.Proposition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_12=(Token)match(input,18,FOLLOW_66); 

            			newLeafNode(otherlv_12, grammarAccess.getPowerAccess().getCommaKeyword_10());
            		
            // InternalSymboleo.g:4751:3: ( (lv_consequent_13_0= rulePowerFunction ) )
            // InternalSymboleo.g:4752:4: (lv_consequent_13_0= rulePowerFunction )
            {
            // InternalSymboleo.g:4752:4: (lv_consequent_13_0= rulePowerFunction )
            // InternalSymboleo.g:4753:5: lv_consequent_13_0= rulePowerFunction
            {

            					newCompositeNode(grammarAccess.getPowerAccess().getConsequentPowerFunctionParserRuleCall_11_0());
            				
            pushFollow(FOLLOW_12);
            lv_consequent_13_0=rulePowerFunction();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPowerRule());
            					}
            					set(
            						current,
            						"consequent",
            						lv_consequent_13_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.PowerFunction");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_14=(Token)match(input,19,FOLLOW_31); 

            			newLeafNode(otherlv_14, grammarAccess.getPowerAccess().getRightParenthesisKeyword_12());
            		
            // InternalSymboleo.g:4774:3: (otherlv_15= 'with' otherlv_16= 'Controller' ( (lv_controller_17_0= ruleVariableDotExpression ) ) )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==32) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // InternalSymboleo.g:4775:4: otherlv_15= 'with' otherlv_16= 'Controller' ( (lv_controller_17_0= ruleVariableDotExpression ) )
                    {
                    otherlv_15=(Token)match(input,32,FOLLOW_41); 

                    				newLeafNode(otherlv_15, grammarAccess.getPowerAccess().getWithKeyword_13_0());
                    			
                    otherlv_16=(Token)match(input,45,FOLLOW_3); 

                    				newLeafNode(otherlv_16, grammarAccess.getPowerAccess().getControllerKeyword_13_1());
                    			
                    // InternalSymboleo.g:4783:4: ( (lv_controller_17_0= ruleVariableDotExpression ) )
                    // InternalSymboleo.g:4784:5: (lv_controller_17_0= ruleVariableDotExpression )
                    {
                    // InternalSymboleo.g:4784:5: (lv_controller_17_0= ruleVariableDotExpression )
                    // InternalSymboleo.g:4785:6: lv_controller_17_0= ruleVariableDotExpression
                    {

                    						newCompositeNode(grammarAccess.getPowerAccess().getControllerVariableDotExpressionParserRuleCall_13_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_controller_17_0=ruleVariableDotExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPowerRule());
                    						}
                    						set(
                    							current,
                    							"controller",
                    							lv_controller_17_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.VariableDotExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePower"


    // $ANTLR start "entryRulePowerFunction"
    // InternalSymboleo.g:4807:1: entryRulePowerFunction returns [EObject current=null] : iv_rulePowerFunction= rulePowerFunction EOF ;
    public final EObject entryRulePowerFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePowerFunction = null;


        try {
            // InternalSymboleo.g:4807:54: (iv_rulePowerFunction= rulePowerFunction EOF )
            // InternalSymboleo.g:4808:2: iv_rulePowerFunction= rulePowerFunction EOF
            {
             newCompositeNode(grammarAccess.getPowerFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePowerFunction=rulePowerFunction();

            state._fsp--;

             current =iv_rulePowerFunction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePowerFunction"


    // $ANTLR start "rulePowerFunction"
    // InternalSymboleo.g:4814:1: rulePowerFunction returns [EObject current=null] : ( ( () ( (lv_action_1_0= 'Suspended' ) ) otherlv_2= '(' otherlv_3= 'obligations.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' ) | ( () ( (lv_action_7_0= 'Resumed' ) ) otherlv_8= '(' otherlv_9= 'obligations.' ( (otherlv_10= RULE_ID ) ) otherlv_11= ')' ) | ( () ( (lv_action_13_0= 'Discharged' ) ) otherlv_14= '(' otherlv_15= 'obligations.' ( (otherlv_16= RULE_ID ) ) otherlv_17= ')' ) | ( () ( (lv_action_19_0= 'Terminated' ) ) otherlv_20= '(' otherlv_21= 'obligations.' ( (otherlv_22= RULE_ID ) ) otherlv_23= ')' ) | ( () ( (lv_action_25_0= 'Triggered' ) ) otherlv_26= '(' otherlv_27= 'obligations.' ( (otherlv_28= RULE_ID ) ) otherlv_29= ')' ) | ( () ( (lv_action_31_0= 'Suspended' ) ) otherlv_32= '(' ( (lv_norm_33_0= 'self' ) ) otherlv_34= ')' ) | ( () ( (lv_action_36_0= 'Resumed' ) ) otherlv_37= '(' ( (lv_norm_38_0= 'self' ) ) otherlv_39= ')' ) | ( () ( (lv_action_41_0= 'Terminated' ) ) otherlv_42= '(' ( (lv_norm_43_0= 'self' ) ) otherlv_44= ')' ) ) ;
    public final EObject rulePowerFunction() throws RecognitionException {
        EObject current = null;

        Token lv_action_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_action_7_0=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token lv_action_13_0=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token lv_action_19_0=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token lv_action_25_0=null;
        Token otherlv_26=null;
        Token otherlv_27=null;
        Token otherlv_28=null;
        Token otherlv_29=null;
        Token lv_action_31_0=null;
        Token otherlv_32=null;
        Token lv_norm_33_0=null;
        Token otherlv_34=null;
        Token lv_action_36_0=null;
        Token otherlv_37=null;
        Token lv_norm_38_0=null;
        Token otherlv_39=null;
        Token lv_action_41_0=null;
        Token otherlv_42=null;
        Token lv_norm_43_0=null;
        Token otherlv_44=null;


        	enterRule();

        try {
            // InternalSymboleo.g:4820:2: ( ( ( () ( (lv_action_1_0= 'Suspended' ) ) otherlv_2= '(' otherlv_3= 'obligations.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' ) | ( () ( (lv_action_7_0= 'Resumed' ) ) otherlv_8= '(' otherlv_9= 'obligations.' ( (otherlv_10= RULE_ID ) ) otherlv_11= ')' ) | ( () ( (lv_action_13_0= 'Discharged' ) ) otherlv_14= '(' otherlv_15= 'obligations.' ( (otherlv_16= RULE_ID ) ) otherlv_17= ')' ) | ( () ( (lv_action_19_0= 'Terminated' ) ) otherlv_20= '(' otherlv_21= 'obligations.' ( (otherlv_22= RULE_ID ) ) otherlv_23= ')' ) | ( () ( (lv_action_25_0= 'Triggered' ) ) otherlv_26= '(' otherlv_27= 'obligations.' ( (otherlv_28= RULE_ID ) ) otherlv_29= ')' ) | ( () ( (lv_action_31_0= 'Suspended' ) ) otherlv_32= '(' ( (lv_norm_33_0= 'self' ) ) otherlv_34= ')' ) | ( () ( (lv_action_36_0= 'Resumed' ) ) otherlv_37= '(' ( (lv_norm_38_0= 'self' ) ) otherlv_39= ')' ) | ( () ( (lv_action_41_0= 'Terminated' ) ) otherlv_42= '(' ( (lv_norm_43_0= 'self' ) ) otherlv_44= ')' ) ) )
            // InternalSymboleo.g:4821:2: ( ( () ( (lv_action_1_0= 'Suspended' ) ) otherlv_2= '(' otherlv_3= 'obligations.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' ) | ( () ( (lv_action_7_0= 'Resumed' ) ) otherlv_8= '(' otherlv_9= 'obligations.' ( (otherlv_10= RULE_ID ) ) otherlv_11= ')' ) | ( () ( (lv_action_13_0= 'Discharged' ) ) otherlv_14= '(' otherlv_15= 'obligations.' ( (otherlv_16= RULE_ID ) ) otherlv_17= ')' ) | ( () ( (lv_action_19_0= 'Terminated' ) ) otherlv_20= '(' otherlv_21= 'obligations.' ( (otherlv_22= RULE_ID ) ) otherlv_23= ')' ) | ( () ( (lv_action_25_0= 'Triggered' ) ) otherlv_26= '(' otherlv_27= 'obligations.' ( (otherlv_28= RULE_ID ) ) otherlv_29= ')' ) | ( () ( (lv_action_31_0= 'Suspended' ) ) otherlv_32= '(' ( (lv_norm_33_0= 'self' ) ) otherlv_34= ')' ) | ( () ( (lv_action_36_0= 'Resumed' ) ) otherlv_37= '(' ( (lv_norm_38_0= 'self' ) ) otherlv_39= ')' ) | ( () ( (lv_action_41_0= 'Terminated' ) ) otherlv_42= '(' ( (lv_norm_43_0= 'self' ) ) otherlv_44= ')' ) )
            {
            // InternalSymboleo.g:4821:2: ( ( () ( (lv_action_1_0= 'Suspended' ) ) otherlv_2= '(' otherlv_3= 'obligations.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' ) | ( () ( (lv_action_7_0= 'Resumed' ) ) otherlv_8= '(' otherlv_9= 'obligations.' ( (otherlv_10= RULE_ID ) ) otherlv_11= ')' ) | ( () ( (lv_action_13_0= 'Discharged' ) ) otherlv_14= '(' otherlv_15= 'obligations.' ( (otherlv_16= RULE_ID ) ) otherlv_17= ')' ) | ( () ( (lv_action_19_0= 'Terminated' ) ) otherlv_20= '(' otherlv_21= 'obligations.' ( (otherlv_22= RULE_ID ) ) otherlv_23= ')' ) | ( () ( (lv_action_25_0= 'Triggered' ) ) otherlv_26= '(' otherlv_27= 'obligations.' ( (otherlv_28= RULE_ID ) ) otherlv_29= ')' ) | ( () ( (lv_action_31_0= 'Suspended' ) ) otherlv_32= '(' ( (lv_norm_33_0= 'self' ) ) otherlv_34= ')' ) | ( () ( (lv_action_36_0= 'Resumed' ) ) otherlv_37= '(' ( (lv_norm_38_0= 'self' ) ) otherlv_39= ')' ) | ( () ( (lv_action_41_0= 'Terminated' ) ) otherlv_42= '(' ( (lv_norm_43_0= 'self' ) ) otherlv_44= ')' ) )
            int alt75=8;
            alt75 = dfa75.predict(input);
            switch (alt75) {
                case 1 :
                    // InternalSymboleo.g:4822:3: ( () ( (lv_action_1_0= 'Suspended' ) ) otherlv_2= '(' otherlv_3= 'obligations.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' )
                    {
                    // InternalSymboleo.g:4822:3: ( () ( (lv_action_1_0= 'Suspended' ) ) otherlv_2= '(' otherlv_3= 'obligations.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' )
                    // InternalSymboleo.g:4823:4: () ( (lv_action_1_0= 'Suspended' ) ) otherlv_2= '(' otherlv_3= 'obligations.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')'
                    {
                    // InternalSymboleo.g:4823:4: ()
                    // InternalSymboleo.g:4824:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPowerFunctionAccess().getPFObligationSuspendedAction_0_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:4830:4: ( (lv_action_1_0= 'Suspended' ) )
                    // InternalSymboleo.g:4831:5: (lv_action_1_0= 'Suspended' )
                    {
                    // InternalSymboleo.g:4831:5: (lv_action_1_0= 'Suspended' )
                    // InternalSymboleo.g:4832:6: lv_action_1_0= 'Suspended'
                    {
                    lv_action_1_0=(Token)match(input,101,FOLLOW_10); 

                    						newLeafNode(lv_action_1_0, grammarAccess.getPowerFunctionAccess().getActionSuspendedKeyword_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPowerFunctionRule());
                    						}
                    						setWithLastConsumed(current, "action", lv_action_1_0, "Suspended");
                    					

                    }


                    }

                    otherlv_2=(Token)match(input,17,FOLLOW_67); 

                    				newLeafNode(otherlv_2, grammarAccess.getPowerFunctionAccess().getLeftParenthesisKeyword_0_2());
                    			
                    otherlv_3=(Token)match(input,51,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getPowerFunctionAccess().getObligationsKeyword_0_3());
                    			
                    // InternalSymboleo.g:4852:4: ( (otherlv_4= RULE_ID ) )
                    // InternalSymboleo.g:4853:5: (otherlv_4= RULE_ID )
                    {
                    // InternalSymboleo.g:4853:5: (otherlv_4= RULE_ID )
                    // InternalSymboleo.g:4854:6: otherlv_4= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPowerFunctionRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_4, grammarAccess.getPowerFunctionAccess().getNormObligationCrossReference_0_4_0());
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getPowerFunctionAccess().getRightParenthesisKeyword_0_5());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:4871:3: ( () ( (lv_action_7_0= 'Resumed' ) ) otherlv_8= '(' otherlv_9= 'obligations.' ( (otherlv_10= RULE_ID ) ) otherlv_11= ')' )
                    {
                    // InternalSymboleo.g:4871:3: ( () ( (lv_action_7_0= 'Resumed' ) ) otherlv_8= '(' otherlv_9= 'obligations.' ( (otherlv_10= RULE_ID ) ) otherlv_11= ')' )
                    // InternalSymboleo.g:4872:4: () ( (lv_action_7_0= 'Resumed' ) ) otherlv_8= '(' otherlv_9= 'obligations.' ( (otherlv_10= RULE_ID ) ) otherlv_11= ')'
                    {
                    // InternalSymboleo.g:4872:4: ()
                    // InternalSymboleo.g:4873:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPowerFunctionAccess().getPFObligationResumedAction_1_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:4879:4: ( (lv_action_7_0= 'Resumed' ) )
                    // InternalSymboleo.g:4880:5: (lv_action_7_0= 'Resumed' )
                    {
                    // InternalSymboleo.g:4880:5: (lv_action_7_0= 'Resumed' )
                    // InternalSymboleo.g:4881:6: lv_action_7_0= 'Resumed'
                    {
                    lv_action_7_0=(Token)match(input,102,FOLLOW_10); 

                    						newLeafNode(lv_action_7_0, grammarAccess.getPowerFunctionAccess().getActionResumedKeyword_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPowerFunctionRule());
                    						}
                    						setWithLastConsumed(current, "action", lv_action_7_0, "Resumed");
                    					

                    }


                    }

                    otherlv_8=(Token)match(input,17,FOLLOW_67); 

                    				newLeafNode(otherlv_8, grammarAccess.getPowerFunctionAccess().getLeftParenthesisKeyword_1_2());
                    			
                    otherlv_9=(Token)match(input,51,FOLLOW_3); 

                    				newLeafNode(otherlv_9, grammarAccess.getPowerFunctionAccess().getObligationsKeyword_1_3());
                    			
                    // InternalSymboleo.g:4901:4: ( (otherlv_10= RULE_ID ) )
                    // InternalSymboleo.g:4902:5: (otherlv_10= RULE_ID )
                    {
                    // InternalSymboleo.g:4902:5: (otherlv_10= RULE_ID )
                    // InternalSymboleo.g:4903:6: otherlv_10= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPowerFunctionRule());
                    						}
                    					
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_10, grammarAccess.getPowerFunctionAccess().getNormObligationCrossReference_1_4_0());
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getPowerFunctionAccess().getRightParenthesisKeyword_1_5());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:4920:3: ( () ( (lv_action_13_0= 'Discharged' ) ) otherlv_14= '(' otherlv_15= 'obligations.' ( (otherlv_16= RULE_ID ) ) otherlv_17= ')' )
                    {
                    // InternalSymboleo.g:4920:3: ( () ( (lv_action_13_0= 'Discharged' ) ) otherlv_14= '(' otherlv_15= 'obligations.' ( (otherlv_16= RULE_ID ) ) otherlv_17= ')' )
                    // InternalSymboleo.g:4921:4: () ( (lv_action_13_0= 'Discharged' ) ) otherlv_14= '(' otherlv_15= 'obligations.' ( (otherlv_16= RULE_ID ) ) otherlv_17= ')'
                    {
                    // InternalSymboleo.g:4921:4: ()
                    // InternalSymboleo.g:4922:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPowerFunctionAccess().getPFObligationDischargedAction_2_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:4928:4: ( (lv_action_13_0= 'Discharged' ) )
                    // InternalSymboleo.g:4929:5: (lv_action_13_0= 'Discharged' )
                    {
                    // InternalSymboleo.g:4929:5: (lv_action_13_0= 'Discharged' )
                    // InternalSymboleo.g:4930:6: lv_action_13_0= 'Discharged'
                    {
                    lv_action_13_0=(Token)match(input,103,FOLLOW_10); 

                    						newLeafNode(lv_action_13_0, grammarAccess.getPowerFunctionAccess().getActionDischargedKeyword_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPowerFunctionRule());
                    						}
                    						setWithLastConsumed(current, "action", lv_action_13_0, "Discharged");
                    					

                    }


                    }

                    otherlv_14=(Token)match(input,17,FOLLOW_67); 

                    				newLeafNode(otherlv_14, grammarAccess.getPowerFunctionAccess().getLeftParenthesisKeyword_2_2());
                    			
                    otherlv_15=(Token)match(input,51,FOLLOW_3); 

                    				newLeafNode(otherlv_15, grammarAccess.getPowerFunctionAccess().getObligationsKeyword_2_3());
                    			
                    // InternalSymboleo.g:4950:4: ( (otherlv_16= RULE_ID ) )
                    // InternalSymboleo.g:4951:5: (otherlv_16= RULE_ID )
                    {
                    // InternalSymboleo.g:4951:5: (otherlv_16= RULE_ID )
                    // InternalSymboleo.g:4952:6: otherlv_16= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPowerFunctionRule());
                    						}
                    					
                    otherlv_16=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_16, grammarAccess.getPowerFunctionAccess().getNormObligationCrossReference_2_4_0());
                    					

                    }


                    }

                    otherlv_17=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_17, grammarAccess.getPowerFunctionAccess().getRightParenthesisKeyword_2_5());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalSymboleo.g:4969:3: ( () ( (lv_action_19_0= 'Terminated' ) ) otherlv_20= '(' otherlv_21= 'obligations.' ( (otherlv_22= RULE_ID ) ) otherlv_23= ')' )
                    {
                    // InternalSymboleo.g:4969:3: ( () ( (lv_action_19_0= 'Terminated' ) ) otherlv_20= '(' otherlv_21= 'obligations.' ( (otherlv_22= RULE_ID ) ) otherlv_23= ')' )
                    // InternalSymboleo.g:4970:4: () ( (lv_action_19_0= 'Terminated' ) ) otherlv_20= '(' otherlv_21= 'obligations.' ( (otherlv_22= RULE_ID ) ) otherlv_23= ')'
                    {
                    // InternalSymboleo.g:4970:4: ()
                    // InternalSymboleo.g:4971:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPowerFunctionAccess().getPFObligationTerminatedAction_3_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:4977:4: ( (lv_action_19_0= 'Terminated' ) )
                    // InternalSymboleo.g:4978:5: (lv_action_19_0= 'Terminated' )
                    {
                    // InternalSymboleo.g:4978:5: (lv_action_19_0= 'Terminated' )
                    // InternalSymboleo.g:4979:6: lv_action_19_0= 'Terminated'
                    {
                    lv_action_19_0=(Token)match(input,104,FOLLOW_10); 

                    						newLeafNode(lv_action_19_0, grammarAccess.getPowerFunctionAccess().getActionTerminatedKeyword_3_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPowerFunctionRule());
                    						}
                    						setWithLastConsumed(current, "action", lv_action_19_0, "Terminated");
                    					

                    }


                    }

                    otherlv_20=(Token)match(input,17,FOLLOW_67); 

                    				newLeafNode(otherlv_20, grammarAccess.getPowerFunctionAccess().getLeftParenthesisKeyword_3_2());
                    			
                    otherlv_21=(Token)match(input,51,FOLLOW_3); 

                    				newLeafNode(otherlv_21, grammarAccess.getPowerFunctionAccess().getObligationsKeyword_3_3());
                    			
                    // InternalSymboleo.g:4999:4: ( (otherlv_22= RULE_ID ) )
                    // InternalSymboleo.g:5000:5: (otherlv_22= RULE_ID )
                    {
                    // InternalSymboleo.g:5000:5: (otherlv_22= RULE_ID )
                    // InternalSymboleo.g:5001:6: otherlv_22= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPowerFunctionRule());
                    						}
                    					
                    otherlv_22=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_22, grammarAccess.getPowerFunctionAccess().getNormObligationCrossReference_3_4_0());
                    					

                    }


                    }

                    otherlv_23=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_23, grammarAccess.getPowerFunctionAccess().getRightParenthesisKeyword_3_5());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalSymboleo.g:5018:3: ( () ( (lv_action_25_0= 'Triggered' ) ) otherlv_26= '(' otherlv_27= 'obligations.' ( (otherlv_28= RULE_ID ) ) otherlv_29= ')' )
                    {
                    // InternalSymboleo.g:5018:3: ( () ( (lv_action_25_0= 'Triggered' ) ) otherlv_26= '(' otherlv_27= 'obligations.' ( (otherlv_28= RULE_ID ) ) otherlv_29= ')' )
                    // InternalSymboleo.g:5019:4: () ( (lv_action_25_0= 'Triggered' ) ) otherlv_26= '(' otherlv_27= 'obligations.' ( (otherlv_28= RULE_ID ) ) otherlv_29= ')'
                    {
                    // InternalSymboleo.g:5019:4: ()
                    // InternalSymboleo.g:5020:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPowerFunctionAccess().getPFObligationTriggeredAction_4_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:5026:4: ( (lv_action_25_0= 'Triggered' ) )
                    // InternalSymboleo.g:5027:5: (lv_action_25_0= 'Triggered' )
                    {
                    // InternalSymboleo.g:5027:5: (lv_action_25_0= 'Triggered' )
                    // InternalSymboleo.g:5028:6: lv_action_25_0= 'Triggered'
                    {
                    lv_action_25_0=(Token)match(input,105,FOLLOW_10); 

                    						newLeafNode(lv_action_25_0, grammarAccess.getPowerFunctionAccess().getActionTriggeredKeyword_4_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPowerFunctionRule());
                    						}
                    						setWithLastConsumed(current, "action", lv_action_25_0, "Triggered");
                    					

                    }


                    }

                    otherlv_26=(Token)match(input,17,FOLLOW_67); 

                    				newLeafNode(otherlv_26, grammarAccess.getPowerFunctionAccess().getLeftParenthesisKeyword_4_2());
                    			
                    otherlv_27=(Token)match(input,51,FOLLOW_3); 

                    				newLeafNode(otherlv_27, grammarAccess.getPowerFunctionAccess().getObligationsKeyword_4_3());
                    			
                    // InternalSymboleo.g:5048:4: ( (otherlv_28= RULE_ID ) )
                    // InternalSymboleo.g:5049:5: (otherlv_28= RULE_ID )
                    {
                    // InternalSymboleo.g:5049:5: (otherlv_28= RULE_ID )
                    // InternalSymboleo.g:5050:6: otherlv_28= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPowerFunctionRule());
                    						}
                    					
                    otherlv_28=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_28, grammarAccess.getPowerFunctionAccess().getNormObligationCrossReference_4_4_0());
                    					

                    }


                    }

                    otherlv_29=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_29, grammarAccess.getPowerFunctionAccess().getRightParenthesisKeyword_4_5());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalSymboleo.g:5067:3: ( () ( (lv_action_31_0= 'Suspended' ) ) otherlv_32= '(' ( (lv_norm_33_0= 'self' ) ) otherlv_34= ')' )
                    {
                    // InternalSymboleo.g:5067:3: ( () ( (lv_action_31_0= 'Suspended' ) ) otherlv_32= '(' ( (lv_norm_33_0= 'self' ) ) otherlv_34= ')' )
                    // InternalSymboleo.g:5068:4: () ( (lv_action_31_0= 'Suspended' ) ) otherlv_32= '(' ( (lv_norm_33_0= 'self' ) ) otherlv_34= ')'
                    {
                    // InternalSymboleo.g:5068:4: ()
                    // InternalSymboleo.g:5069:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPowerFunctionAccess().getPFContractSuspendedAction_5_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:5075:4: ( (lv_action_31_0= 'Suspended' ) )
                    // InternalSymboleo.g:5076:5: (lv_action_31_0= 'Suspended' )
                    {
                    // InternalSymboleo.g:5076:5: (lv_action_31_0= 'Suspended' )
                    // InternalSymboleo.g:5077:6: lv_action_31_0= 'Suspended'
                    {
                    lv_action_31_0=(Token)match(input,101,FOLLOW_10); 

                    						newLeafNode(lv_action_31_0, grammarAccess.getPowerFunctionAccess().getActionSuspendedKeyword_5_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPowerFunctionRule());
                    						}
                    						setWithLastConsumed(current, "action", lv_action_31_0, "Suspended");
                    					

                    }


                    }

                    otherlv_32=(Token)match(input,17,FOLLOW_68); 

                    				newLeafNode(otherlv_32, grammarAccess.getPowerFunctionAccess().getLeftParenthesisKeyword_5_2());
                    			
                    // InternalSymboleo.g:5093:4: ( (lv_norm_33_0= 'self' ) )
                    // InternalSymboleo.g:5094:5: (lv_norm_33_0= 'self' )
                    {
                    // InternalSymboleo.g:5094:5: (lv_norm_33_0= 'self' )
                    // InternalSymboleo.g:5095:6: lv_norm_33_0= 'self'
                    {
                    lv_norm_33_0=(Token)match(input,106,FOLLOW_12); 

                    						newLeafNode(lv_norm_33_0, grammarAccess.getPowerFunctionAccess().getNormSelfKeyword_5_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPowerFunctionRule());
                    						}
                    						setWithLastConsumed(current, "norm", lv_norm_33_0, "self");
                    					

                    }


                    }

                    otherlv_34=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_34, grammarAccess.getPowerFunctionAccess().getRightParenthesisKeyword_5_4());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalSymboleo.g:5113:3: ( () ( (lv_action_36_0= 'Resumed' ) ) otherlv_37= '(' ( (lv_norm_38_0= 'self' ) ) otherlv_39= ')' )
                    {
                    // InternalSymboleo.g:5113:3: ( () ( (lv_action_36_0= 'Resumed' ) ) otherlv_37= '(' ( (lv_norm_38_0= 'self' ) ) otherlv_39= ')' )
                    // InternalSymboleo.g:5114:4: () ( (lv_action_36_0= 'Resumed' ) ) otherlv_37= '(' ( (lv_norm_38_0= 'self' ) ) otherlv_39= ')'
                    {
                    // InternalSymboleo.g:5114:4: ()
                    // InternalSymboleo.g:5115:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPowerFunctionAccess().getPFContractResumedAction_6_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:5121:4: ( (lv_action_36_0= 'Resumed' ) )
                    // InternalSymboleo.g:5122:5: (lv_action_36_0= 'Resumed' )
                    {
                    // InternalSymboleo.g:5122:5: (lv_action_36_0= 'Resumed' )
                    // InternalSymboleo.g:5123:6: lv_action_36_0= 'Resumed'
                    {
                    lv_action_36_0=(Token)match(input,102,FOLLOW_10); 

                    						newLeafNode(lv_action_36_0, grammarAccess.getPowerFunctionAccess().getActionResumedKeyword_6_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPowerFunctionRule());
                    						}
                    						setWithLastConsumed(current, "action", lv_action_36_0, "Resumed");
                    					

                    }


                    }

                    otherlv_37=(Token)match(input,17,FOLLOW_68); 

                    				newLeafNode(otherlv_37, grammarAccess.getPowerFunctionAccess().getLeftParenthesisKeyword_6_2());
                    			
                    // InternalSymboleo.g:5139:4: ( (lv_norm_38_0= 'self' ) )
                    // InternalSymboleo.g:5140:5: (lv_norm_38_0= 'self' )
                    {
                    // InternalSymboleo.g:5140:5: (lv_norm_38_0= 'self' )
                    // InternalSymboleo.g:5141:6: lv_norm_38_0= 'self'
                    {
                    lv_norm_38_0=(Token)match(input,106,FOLLOW_12); 

                    						newLeafNode(lv_norm_38_0, grammarAccess.getPowerFunctionAccess().getNormSelfKeyword_6_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPowerFunctionRule());
                    						}
                    						setWithLastConsumed(current, "norm", lv_norm_38_0, "self");
                    					

                    }


                    }

                    otherlv_39=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_39, grammarAccess.getPowerFunctionAccess().getRightParenthesisKeyword_6_4());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalSymboleo.g:5159:3: ( () ( (lv_action_41_0= 'Terminated' ) ) otherlv_42= '(' ( (lv_norm_43_0= 'self' ) ) otherlv_44= ')' )
                    {
                    // InternalSymboleo.g:5159:3: ( () ( (lv_action_41_0= 'Terminated' ) ) otherlv_42= '(' ( (lv_norm_43_0= 'self' ) ) otherlv_44= ')' )
                    // InternalSymboleo.g:5160:4: () ( (lv_action_41_0= 'Terminated' ) ) otherlv_42= '(' ( (lv_norm_43_0= 'self' ) ) otherlv_44= ')'
                    {
                    // InternalSymboleo.g:5160:4: ()
                    // InternalSymboleo.g:5161:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPowerFunctionAccess().getPFContractTerminatedAction_7_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:5167:4: ( (lv_action_41_0= 'Terminated' ) )
                    // InternalSymboleo.g:5168:5: (lv_action_41_0= 'Terminated' )
                    {
                    // InternalSymboleo.g:5168:5: (lv_action_41_0= 'Terminated' )
                    // InternalSymboleo.g:5169:6: lv_action_41_0= 'Terminated'
                    {
                    lv_action_41_0=(Token)match(input,104,FOLLOW_10); 

                    						newLeafNode(lv_action_41_0, grammarAccess.getPowerFunctionAccess().getActionTerminatedKeyword_7_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPowerFunctionRule());
                    						}
                    						setWithLastConsumed(current, "action", lv_action_41_0, "Terminated");
                    					

                    }


                    }

                    otherlv_42=(Token)match(input,17,FOLLOW_68); 

                    				newLeafNode(otherlv_42, grammarAccess.getPowerFunctionAccess().getLeftParenthesisKeyword_7_2());
                    			
                    // InternalSymboleo.g:5185:4: ( (lv_norm_43_0= 'self' ) )
                    // InternalSymboleo.g:5186:5: (lv_norm_43_0= 'self' )
                    {
                    // InternalSymboleo.g:5186:5: (lv_norm_43_0= 'self' )
                    // InternalSymboleo.g:5187:6: lv_norm_43_0= 'self'
                    {
                    lv_norm_43_0=(Token)match(input,106,FOLLOW_12); 

                    						newLeafNode(lv_norm_43_0, grammarAccess.getPowerFunctionAccess().getNormSelfKeyword_7_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPowerFunctionRule());
                    						}
                    						setWithLastConsumed(current, "norm", lv_norm_43_0, "self");
                    					

                    }


                    }

                    otherlv_44=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_44, grammarAccess.getPowerFunctionAccess().getRightParenthesisKeyword_7_4());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePowerFunction"


    // $ANTLR start "entryRuleProposition"
    // InternalSymboleo.g:5208:1: entryRuleProposition returns [EObject current=null] : iv_ruleProposition= ruleProposition EOF ;
    public final EObject entryRuleProposition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProposition = null;


        try {
            // InternalSymboleo.g:5208:52: (iv_ruleProposition= ruleProposition EOF )
            // InternalSymboleo.g:5209:2: iv_ruleProposition= ruleProposition EOF
            {
             newCompositeNode(grammarAccess.getPropositionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProposition=ruleProposition();

            state._fsp--;

             current =iv_ruleProposition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProposition"


    // $ANTLR start "ruleProposition"
    // InternalSymboleo.g:5215:1: ruleProposition returns [EObject current=null] : this_POr_0= rulePOr ;
    public final EObject ruleProposition() throws RecognitionException {
        EObject current = null;

        EObject this_POr_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:5221:2: (this_POr_0= rulePOr )
            // InternalSymboleo.g:5222:2: this_POr_0= rulePOr
            {

            		newCompositeNode(grammarAccess.getPropositionAccess().getPOrParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_POr_0=rulePOr();

            state._fsp--;


            		current = this_POr_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProposition"


    // $ANTLR start "entryRulePOr"
    // InternalSymboleo.g:5233:1: entryRulePOr returns [EObject current=null] : iv_rulePOr= rulePOr EOF ;
    public final EObject entryRulePOr() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePOr = null;


        try {
            // InternalSymboleo.g:5233:44: (iv_rulePOr= rulePOr EOF )
            // InternalSymboleo.g:5234:2: iv_rulePOr= rulePOr EOF
            {
             newCompositeNode(grammarAccess.getPOrRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePOr=rulePOr();

            state._fsp--;

             current =iv_rulePOr; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePOr"


    // $ANTLR start "rulePOr"
    // InternalSymboleo.g:5240:1: rulePOr returns [EObject current=null] : (this_PAnd_0= rulePAnd ( () otherlv_2= 'or' ( (lv_right_3_0= rulePAnd ) ) )* ) ;
    public final EObject rulePOr() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_PAnd_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:5246:2: ( (this_PAnd_0= rulePAnd ( () otherlv_2= 'or' ( (lv_right_3_0= rulePAnd ) ) )* ) )
            // InternalSymboleo.g:5247:2: (this_PAnd_0= rulePAnd ( () otherlv_2= 'or' ( (lv_right_3_0= rulePAnd ) ) )* )
            {
            // InternalSymboleo.g:5247:2: (this_PAnd_0= rulePAnd ( () otherlv_2= 'or' ( (lv_right_3_0= rulePAnd ) ) )* )
            // InternalSymboleo.g:5248:3: this_PAnd_0= rulePAnd ( () otherlv_2= 'or' ( (lv_right_3_0= rulePAnd ) ) )*
            {

            			newCompositeNode(grammarAccess.getPOrAccess().getPAndParserRuleCall_0());
            		
            pushFollow(FOLLOW_54);
            this_PAnd_0=rulePAnd();

            state._fsp--;


            			current = this_PAnd_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSymboleo.g:5256:3: ( () otherlv_2= 'or' ( (lv_right_3_0= rulePAnd ) ) )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==61) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // InternalSymboleo.g:5257:4: () otherlv_2= 'or' ( (lv_right_3_0= rulePAnd ) )
            	    {
            	    // InternalSymboleo.g:5257:4: ()
            	    // InternalSymboleo.g:5258:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getPOrAccess().getPOrLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,61,FOLLOW_63); 

            	    				newLeafNode(otherlv_2, grammarAccess.getPOrAccess().getOrKeyword_1_1());
            	    			
            	    // InternalSymboleo.g:5268:4: ( (lv_right_3_0= rulePAnd ) )
            	    // InternalSymboleo.g:5269:5: (lv_right_3_0= rulePAnd )
            	    {
            	    // InternalSymboleo.g:5269:5: (lv_right_3_0= rulePAnd )
            	    // InternalSymboleo.g:5270:6: lv_right_3_0= rulePAnd
            	    {

            	    						newCompositeNode(grammarAccess.getPOrAccess().getRightPAndParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_54);
            	    lv_right_3_0=rulePAnd();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getPOrRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"ca.uottawa.csmlab.symboleo.Symboleo.PAnd");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop76;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePOr"


    // $ANTLR start "entryRulePAnd"
    // InternalSymboleo.g:5292:1: entryRulePAnd returns [EObject current=null] : iv_rulePAnd= rulePAnd EOF ;
    public final EObject entryRulePAnd() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePAnd = null;


        try {
            // InternalSymboleo.g:5292:45: (iv_rulePAnd= rulePAnd EOF )
            // InternalSymboleo.g:5293:2: iv_rulePAnd= rulePAnd EOF
            {
             newCompositeNode(grammarAccess.getPAndRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePAnd=rulePAnd();

            state._fsp--;

             current =iv_rulePAnd; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePAnd"


    // $ANTLR start "rulePAnd"
    // InternalSymboleo.g:5299:1: rulePAnd returns [EObject current=null] : (this_PEquality_0= rulePEquality ( () otherlv_2= 'and' ( (lv_right_3_0= rulePEquality ) ) )* ) ;
    public final EObject rulePAnd() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_PEquality_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:5305:2: ( (this_PEquality_0= rulePEquality ( () otherlv_2= 'and' ( (lv_right_3_0= rulePEquality ) ) )* ) )
            // InternalSymboleo.g:5306:2: (this_PEquality_0= rulePEquality ( () otherlv_2= 'and' ( (lv_right_3_0= rulePEquality ) ) )* )
            {
            // InternalSymboleo.g:5306:2: (this_PEquality_0= rulePEquality ( () otherlv_2= 'and' ( (lv_right_3_0= rulePEquality ) ) )* )
            // InternalSymboleo.g:5307:3: this_PEquality_0= rulePEquality ( () otherlv_2= 'and' ( (lv_right_3_0= rulePEquality ) ) )*
            {

            			newCompositeNode(grammarAccess.getPAndAccess().getPEqualityParserRuleCall_0());
            		
            pushFollow(FOLLOW_55);
            this_PEquality_0=rulePEquality();

            state._fsp--;


            			current = this_PEquality_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSymboleo.g:5315:3: ( () otherlv_2= 'and' ( (lv_right_3_0= rulePEquality ) ) )*
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==62) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // InternalSymboleo.g:5316:4: () otherlv_2= 'and' ( (lv_right_3_0= rulePEquality ) )
            	    {
            	    // InternalSymboleo.g:5316:4: ()
            	    // InternalSymboleo.g:5317:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getPAndAccess().getPAndLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,62,FOLLOW_63); 

            	    				newLeafNode(otherlv_2, grammarAccess.getPAndAccess().getAndKeyword_1_1());
            	    			
            	    // InternalSymboleo.g:5327:4: ( (lv_right_3_0= rulePEquality ) )
            	    // InternalSymboleo.g:5328:5: (lv_right_3_0= rulePEquality )
            	    {
            	    // InternalSymboleo.g:5328:5: (lv_right_3_0= rulePEquality )
            	    // InternalSymboleo.g:5329:6: lv_right_3_0= rulePEquality
            	    {

            	    						newCompositeNode(grammarAccess.getPAndAccess().getRightPEqualityParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_55);
            	    lv_right_3_0=rulePEquality();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getPAndRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"ca.uottawa.csmlab.symboleo.Symboleo.PEquality");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop77;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePAnd"


    // $ANTLR start "entryRulePEquality"
    // InternalSymboleo.g:5351:1: entryRulePEquality returns [EObject current=null] : iv_rulePEquality= rulePEquality EOF ;
    public final EObject entryRulePEquality() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePEquality = null;


        try {
            // InternalSymboleo.g:5351:50: (iv_rulePEquality= rulePEquality EOF )
            // InternalSymboleo.g:5352:2: iv_rulePEquality= rulePEquality EOF
            {
             newCompositeNode(grammarAccess.getPEqualityRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePEquality=rulePEquality();

            state._fsp--;

             current =iv_rulePEquality; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePEquality"


    // $ANTLR start "rulePEquality"
    // InternalSymboleo.g:5358:1: rulePEquality returns [EObject current=null] : (this_PComparison_0= rulePComparison ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= rulePComparison ) ) )* ) ;
    public final EObject rulePEquality() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_PComparison_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:5364:2: ( (this_PComparison_0= rulePComparison ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= rulePComparison ) ) )* ) )
            // InternalSymboleo.g:5365:2: (this_PComparison_0= rulePComparison ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= rulePComparison ) ) )* )
            {
            // InternalSymboleo.g:5365:2: (this_PComparison_0= rulePComparison ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= rulePComparison ) ) )* )
            // InternalSymboleo.g:5366:3: this_PComparison_0= rulePComparison ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= rulePComparison ) ) )*
            {

            			newCompositeNode(grammarAccess.getPEqualityAccess().getPComparisonParserRuleCall_0());
            		
            pushFollow(FOLLOW_56);
            this_PComparison_0=rulePComparison();

            state._fsp--;


            			current = this_PComparison_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSymboleo.g:5374:3: ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= rulePComparison ) ) )*
            loop79:
            do {
                int alt79=2;
                int LA79_0 = input.LA(1);

                if ( ((LA79_0>=63 && LA79_0<=64)) ) {
                    alt79=1;
                }


                switch (alt79) {
            	case 1 :
            	    // InternalSymboleo.g:5375:4: () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= rulePComparison ) )
            	    {
            	    // InternalSymboleo.g:5375:4: ()
            	    // InternalSymboleo.g:5376:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getPEqualityAccess().getPEqualityLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalSymboleo.g:5382:4: ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) )
            	    // InternalSymboleo.g:5383:5: ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) )
            	    {
            	    // InternalSymboleo.g:5383:5: ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) )
            	    // InternalSymboleo.g:5384:6: (lv_op_2_1= '==' | lv_op_2_2= '!=' )
            	    {
            	    // InternalSymboleo.g:5384:6: (lv_op_2_1= '==' | lv_op_2_2= '!=' )
            	    int alt78=2;
            	    int LA78_0 = input.LA(1);

            	    if ( (LA78_0==63) ) {
            	        alt78=1;
            	    }
            	    else if ( (LA78_0==64) ) {
            	        alt78=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 78, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt78) {
            	        case 1 :
            	            // InternalSymboleo.g:5385:7: lv_op_2_1= '=='
            	            {
            	            lv_op_2_1=(Token)match(input,63,FOLLOW_63); 

            	            							newLeafNode(lv_op_2_1, grammarAccess.getPEqualityAccess().getOpEqualsSignEqualsSignKeyword_1_1_0_0());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getPEqualityRule());
            	            							}
            	            							setWithLastConsumed(current, "op", lv_op_2_1, null);
            	            						

            	            }
            	            break;
            	        case 2 :
            	            // InternalSymboleo.g:5396:7: lv_op_2_2= '!='
            	            {
            	            lv_op_2_2=(Token)match(input,64,FOLLOW_63); 

            	            							newLeafNode(lv_op_2_2, grammarAccess.getPEqualityAccess().getOpExclamationMarkEqualsSignKeyword_1_1_0_1());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getPEqualityRule());
            	            							}
            	            							setWithLastConsumed(current, "op", lv_op_2_2, null);
            	            						

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalSymboleo.g:5409:4: ( (lv_right_3_0= rulePComparison ) )
            	    // InternalSymboleo.g:5410:5: (lv_right_3_0= rulePComparison )
            	    {
            	    // InternalSymboleo.g:5410:5: (lv_right_3_0= rulePComparison )
            	    // InternalSymboleo.g:5411:6: lv_right_3_0= rulePComparison
            	    {

            	    						newCompositeNode(grammarAccess.getPEqualityAccess().getRightPComparisonParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_56);
            	    lv_right_3_0=rulePComparison();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getPEqualityRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"ca.uottawa.csmlab.symboleo.Symboleo.PComparison");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop79;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePEquality"


    // $ANTLR start "entryRulePComparison"
    // InternalSymboleo.g:5433:1: entryRulePComparison returns [EObject current=null] : iv_rulePComparison= rulePComparison EOF ;
    public final EObject entryRulePComparison() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePComparison = null;


        try {
            // InternalSymboleo.g:5433:52: (iv_rulePComparison= rulePComparison EOF )
            // InternalSymboleo.g:5434:2: iv_rulePComparison= rulePComparison EOF
            {
             newCompositeNode(grammarAccess.getPComparisonRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePComparison=rulePComparison();

            state._fsp--;

             current =iv_rulePComparison; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePComparison"


    // $ANTLR start "rulePComparison"
    // InternalSymboleo.g:5440:1: rulePComparison returns [EObject current=null] : (this_PArithmetic_0= rulePArithmetic ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= rulePArithmetic ) ) )* ) ;
    public final EObject rulePComparison() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        Token lv_op_2_3=null;
        Token lv_op_2_4=null;
        EObject this_PArithmetic_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:5446:2: ( (this_PArithmetic_0= rulePArithmetic ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= rulePArithmetic ) ) )* ) )
            // InternalSymboleo.g:5447:2: (this_PArithmetic_0= rulePArithmetic ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= rulePArithmetic ) ) )* )
            {
            // InternalSymboleo.g:5447:2: (this_PArithmetic_0= rulePArithmetic ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= rulePArithmetic ) ) )* )
            // InternalSymboleo.g:5448:3: this_PArithmetic_0= rulePArithmetic ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= rulePArithmetic ) ) )*
            {

            			newCompositeNode(grammarAccess.getPComparisonAccess().getPArithmeticParserRuleCall_0());
            		
            pushFollow(FOLLOW_57);
            this_PArithmetic_0=rulePArithmetic();

            state._fsp--;


            			current = this_PArithmetic_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSymboleo.g:5456:3: ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= rulePArithmetic ) ) )*
            loop81:
            do {
                int alt81=2;
                int LA81_0 = input.LA(1);

                if ( ((LA81_0>=65 && LA81_0<=68)) ) {
                    alt81=1;
                }


                switch (alt81) {
            	case 1 :
            	    // InternalSymboleo.g:5457:4: () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= rulePArithmetic ) )
            	    {
            	    // InternalSymboleo.g:5457:4: ()
            	    // InternalSymboleo.g:5458:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getPComparisonAccess().getPComparisonLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalSymboleo.g:5464:4: ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) )
            	    // InternalSymboleo.g:5465:5: ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) )
            	    {
            	    // InternalSymboleo.g:5465:5: ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) )
            	    // InternalSymboleo.g:5466:6: (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' )
            	    {
            	    // InternalSymboleo.g:5466:6: (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' )
            	    int alt80=4;
            	    switch ( input.LA(1) ) {
            	    case 65:
            	        {
            	        alt80=1;
            	        }
            	        break;
            	    case 66:
            	        {
            	        alt80=2;
            	        }
            	        break;
            	    case 67:
            	        {
            	        alt80=3;
            	        }
            	        break;
            	    case 68:
            	        {
            	        alt80=4;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 80, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt80) {
            	        case 1 :
            	            // InternalSymboleo.g:5467:7: lv_op_2_1= '>='
            	            {
            	            lv_op_2_1=(Token)match(input,65,FOLLOW_63); 

            	            							newLeafNode(lv_op_2_1, grammarAccess.getPComparisonAccess().getOpGreaterThanSignEqualsSignKeyword_1_1_0_0());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getPComparisonRule());
            	            							}
            	            							setWithLastConsumed(current, "op", lv_op_2_1, null);
            	            						

            	            }
            	            break;
            	        case 2 :
            	            // InternalSymboleo.g:5478:7: lv_op_2_2= '<='
            	            {
            	            lv_op_2_2=(Token)match(input,66,FOLLOW_63); 

            	            							newLeafNode(lv_op_2_2, grammarAccess.getPComparisonAccess().getOpLessThanSignEqualsSignKeyword_1_1_0_1());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getPComparisonRule());
            	            							}
            	            							setWithLastConsumed(current, "op", lv_op_2_2, null);
            	            						

            	            }
            	            break;
            	        case 3 :
            	            // InternalSymboleo.g:5489:7: lv_op_2_3= '>'
            	            {
            	            lv_op_2_3=(Token)match(input,67,FOLLOW_63); 

            	            							newLeafNode(lv_op_2_3, grammarAccess.getPComparisonAccess().getOpGreaterThanSignKeyword_1_1_0_2());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getPComparisonRule());
            	            							}
            	            							setWithLastConsumed(current, "op", lv_op_2_3, null);
            	            						

            	            }
            	            break;
            	        case 4 :
            	            // InternalSymboleo.g:5500:7: lv_op_2_4= '<'
            	            {
            	            lv_op_2_4=(Token)match(input,68,FOLLOW_63); 

            	            							newLeafNode(lv_op_2_4, grammarAccess.getPComparisonAccess().getOpLessThanSignKeyword_1_1_0_3());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getPComparisonRule());
            	            							}
            	            							setWithLastConsumed(current, "op", lv_op_2_4, null);
            	            						

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalSymboleo.g:5513:4: ( (lv_right_3_0= rulePArithmetic ) )
            	    // InternalSymboleo.g:5514:5: (lv_right_3_0= rulePArithmetic )
            	    {
            	    // InternalSymboleo.g:5514:5: (lv_right_3_0= rulePArithmetic )
            	    // InternalSymboleo.g:5515:6: lv_right_3_0= rulePArithmetic
            	    {

            	    						newCompositeNode(grammarAccess.getPComparisonAccess().getRightPArithmeticParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_57);
            	    lv_right_3_0=rulePArithmetic();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getPComparisonRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"ca.uottawa.csmlab.symboleo.Symboleo.PArithmetic");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop81;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePComparison"


    // $ANTLR start "entryRulePArithmetic"
    // InternalSymboleo.g:5537:1: entryRulePArithmetic returns [EObject current=null] : iv_rulePArithmetic= rulePArithmetic EOF ;
    public final EObject entryRulePArithmetic() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePArithmetic = null;


        try {
            // InternalSymboleo.g:5537:52: (iv_rulePArithmetic= rulePArithmetic EOF )
            // InternalSymboleo.g:5538:2: iv_rulePArithmetic= rulePArithmetic EOF
            {
             newCompositeNode(grammarAccess.getPArithmeticRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePArithmetic=rulePArithmetic();

            state._fsp--;

             current =iv_rulePArithmetic; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePArithmetic"


    // $ANTLR start "rulePArithmetic"
    // InternalSymboleo.g:5544:1: rulePArithmetic returns [EObject current=null] : (this_PAtomicExpression_0= rulePAtomicExpression ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' | lv_op_2_3= '*' | lv_op_2_4= '/' | lv_op_2_5= '%' ) ) ) ( (lv_right_3_0= rulePAtomicExpression ) ) )* ) ;
    public final EObject rulePArithmetic() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        Token lv_op_2_3=null;
        Token lv_op_2_4=null;
        Token lv_op_2_5=null;
        EObject this_PAtomicExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:5550:2: ( (this_PAtomicExpression_0= rulePAtomicExpression ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' | lv_op_2_3= '*' | lv_op_2_4= '/' | lv_op_2_5= '%' ) ) ) ( (lv_right_3_0= rulePAtomicExpression ) ) )* ) )
            // InternalSymboleo.g:5551:2: (this_PAtomicExpression_0= rulePAtomicExpression ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' | lv_op_2_3= '*' | lv_op_2_4= '/' | lv_op_2_5= '%' ) ) ) ( (lv_right_3_0= rulePAtomicExpression ) ) )* )
            {
            // InternalSymboleo.g:5551:2: (this_PAtomicExpression_0= rulePAtomicExpression ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' | lv_op_2_3= '*' | lv_op_2_4= '/' | lv_op_2_5= '%' ) ) ) ( (lv_right_3_0= rulePAtomicExpression ) ) )* )
            // InternalSymboleo.g:5552:3: this_PAtomicExpression_0= rulePAtomicExpression ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' | lv_op_2_3= '*' | lv_op_2_4= '/' | lv_op_2_5= '%' ) ) ) ( (lv_right_3_0= rulePAtomicExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getPArithmeticAccess().getPAtomicExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_69);
            this_PAtomicExpression_0=rulePAtomicExpression();

            state._fsp--;


            			current = this_PAtomicExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSymboleo.g:5560:3: ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' | lv_op_2_3= '*' | lv_op_2_4= '/' | lv_op_2_5= '%' ) ) ) ( (lv_right_3_0= rulePAtomicExpression ) ) )*
            loop83:
            do {
                int alt83=2;
                int LA83_0 = input.LA(1);

                if ( ((LA83_0>=69 && LA83_0<=73)) ) {
                    alt83=1;
                }


                switch (alt83) {
            	case 1 :
            	    // InternalSymboleo.g:5561:4: () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' | lv_op_2_3= '*' | lv_op_2_4= '/' | lv_op_2_5= '%' ) ) ) ( (lv_right_3_0= rulePAtomicExpression ) )
            	    {
            	    // InternalSymboleo.g:5561:4: ()
            	    // InternalSymboleo.g:5562:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getPArithmeticAccess().getPArithmeticLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalSymboleo.g:5568:4: ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' | lv_op_2_3= '*' | lv_op_2_4= '/' | lv_op_2_5= '%' ) ) )
            	    // InternalSymboleo.g:5569:5: ( (lv_op_2_1= '+' | lv_op_2_2= '-' | lv_op_2_3= '*' | lv_op_2_4= '/' | lv_op_2_5= '%' ) )
            	    {
            	    // InternalSymboleo.g:5569:5: ( (lv_op_2_1= '+' | lv_op_2_2= '-' | lv_op_2_3= '*' | lv_op_2_4= '/' | lv_op_2_5= '%' ) )
            	    // InternalSymboleo.g:5570:6: (lv_op_2_1= '+' | lv_op_2_2= '-' | lv_op_2_3= '*' | lv_op_2_4= '/' | lv_op_2_5= '%' )
            	    {
            	    // InternalSymboleo.g:5570:6: (lv_op_2_1= '+' | lv_op_2_2= '-' | lv_op_2_3= '*' | lv_op_2_4= '/' | lv_op_2_5= '%' )
            	    int alt82=5;
            	    switch ( input.LA(1) ) {
            	    case 69:
            	        {
            	        alt82=1;
            	        }
            	        break;
            	    case 70:
            	        {
            	        alt82=2;
            	        }
            	        break;
            	    case 71:
            	        {
            	        alt82=3;
            	        }
            	        break;
            	    case 72:
            	        {
            	        alt82=4;
            	        }
            	        break;
            	    case 73:
            	        {
            	        alt82=5;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 82, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt82) {
            	        case 1 :
            	            // InternalSymboleo.g:5571:7: lv_op_2_1= '+'
            	            {
            	            lv_op_2_1=(Token)match(input,69,FOLLOW_63); 

            	            							newLeafNode(lv_op_2_1, grammarAccess.getPArithmeticAccess().getOpPlusSignKeyword_1_1_0_0());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getPArithmeticRule());
            	            							}
            	            							setWithLastConsumed(current, "op", lv_op_2_1, null);
            	            						

            	            }
            	            break;
            	        case 2 :
            	            // InternalSymboleo.g:5582:7: lv_op_2_2= '-'
            	            {
            	            lv_op_2_2=(Token)match(input,70,FOLLOW_63); 

            	            							newLeafNode(lv_op_2_2, grammarAccess.getPArithmeticAccess().getOpHyphenMinusKeyword_1_1_0_1());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getPArithmeticRule());
            	            							}
            	            							setWithLastConsumed(current, "op", lv_op_2_2, null);
            	            						

            	            }
            	            break;
            	        case 3 :
            	            // InternalSymboleo.g:5593:7: lv_op_2_3= '*'
            	            {
            	            lv_op_2_3=(Token)match(input,71,FOLLOW_63); 

            	            							newLeafNode(lv_op_2_3, grammarAccess.getPArithmeticAccess().getOpAsteriskKeyword_1_1_0_2());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getPArithmeticRule());
            	            							}
            	            							setWithLastConsumed(current, "op", lv_op_2_3, null);
            	            						

            	            }
            	            break;
            	        case 4 :
            	            // InternalSymboleo.g:5604:7: lv_op_2_4= '/'
            	            {
            	            lv_op_2_4=(Token)match(input,72,FOLLOW_63); 

            	            							newLeafNode(lv_op_2_4, grammarAccess.getPArithmeticAccess().getOpSolidusKeyword_1_1_0_3());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getPArithmeticRule());
            	            							}
            	            							setWithLastConsumed(current, "op", lv_op_2_4, null);
            	            						

            	            }
            	            break;
            	        case 5 :
            	            // InternalSymboleo.g:5615:7: lv_op_2_5= '%'
            	            {
            	            lv_op_2_5=(Token)match(input,73,FOLLOW_63); 

            	            							newLeafNode(lv_op_2_5, grammarAccess.getPArithmeticAccess().getOpPercentSignKeyword_1_1_0_4());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getPArithmeticRule());
            	            							}
            	            							setWithLastConsumed(current, "op", lv_op_2_5, null);
            	            						

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalSymboleo.g:5628:4: ( (lv_right_3_0= rulePAtomicExpression ) )
            	    // InternalSymboleo.g:5629:5: (lv_right_3_0= rulePAtomicExpression )
            	    {
            	    // InternalSymboleo.g:5629:5: (lv_right_3_0= rulePAtomicExpression )
            	    // InternalSymboleo.g:5630:6: lv_right_3_0= rulePAtomicExpression
            	    {

            	    						newCompositeNode(grammarAccess.getPArithmeticAccess().getRightPAtomicExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_69);
            	    lv_right_3_0=rulePAtomicExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getPArithmeticRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"ca.uottawa.csmlab.symboleo.Symboleo.PAtomicExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop83;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePArithmetic"


    // $ANTLR start "entryRulePAtomicExpression"
    // InternalSymboleo.g:5652:1: entryRulePAtomicExpression returns [EObject current=null] : iv_rulePAtomicExpression= rulePAtomicExpression EOF ;
    public final EObject entryRulePAtomicExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePAtomicExpression = null;


        try {
            // InternalSymboleo.g:5652:58: (iv_rulePAtomicExpression= rulePAtomicExpression EOF )
            // InternalSymboleo.g:5653:2: iv_rulePAtomicExpression= rulePAtomicExpression EOF
            {
             newCompositeNode(grammarAccess.getPAtomicExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePAtomicExpression=rulePAtomicExpression();

            state._fsp--;

             current =iv_rulePAtomicExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePAtomicExpression"


    // $ANTLR start "rulePAtomicExpression"
    // InternalSymboleo.g:5659:1: rulePAtomicExpression returns [EObject current=null] : ( ( () otherlv_1= '(' ( (lv_inner_2_0= ruleProposition ) ) otherlv_3= ')' ) | ( () otherlv_5= 'not' ( (lv_negated_6_0= rulePAtomicExpression ) ) ) | ( () ( (lv_predicateFunction_8_0= rulePredicateFunction ) ) ) | ( () ( (lv_function_10_0= ruleOtherFunction ) ) ) | ( () ( (otherlv_12= RULE_ID ) ) otherlv_13= '(' ( (otherlv_14= RULE_ID ) ) otherlv_15= ')' ) | ( () ( (lv_variable_17_0= ruleVariableDotExpression ) ) ) | ( () ( (lv_value_19_0= 'true' ) ) ) | ( () ( (lv_value_21_0= 'false' ) ) ) | ( () ( (lv_value_23_0= ruleDouble ) ) ) | ( () ( (lv_value_25_0= RULE_INT ) ) ) | ( () ( (lv_value_27_0= RULE_STRING ) ) ) | ( () ( (lv_value_29_0= ruleDate ) ) ) ) ;
    public final EObject rulePAtomicExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token lv_value_19_0=null;
        Token lv_value_21_0=null;
        Token lv_value_25_0=null;
        Token lv_value_27_0=null;
        EObject lv_inner_2_0 = null;

        EObject lv_negated_6_0 = null;

        EObject lv_predicateFunction_8_0 = null;

        EObject lv_function_10_0 = null;

        EObject lv_variable_17_0 = null;

        AntlrDatatypeRuleToken lv_value_23_0 = null;

        AntlrDatatypeRuleToken lv_value_29_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:5665:2: ( ( ( () otherlv_1= '(' ( (lv_inner_2_0= ruleProposition ) ) otherlv_3= ')' ) | ( () otherlv_5= 'not' ( (lv_negated_6_0= rulePAtomicExpression ) ) ) | ( () ( (lv_predicateFunction_8_0= rulePredicateFunction ) ) ) | ( () ( (lv_function_10_0= ruleOtherFunction ) ) ) | ( () ( (otherlv_12= RULE_ID ) ) otherlv_13= '(' ( (otherlv_14= RULE_ID ) ) otherlv_15= ')' ) | ( () ( (lv_variable_17_0= ruleVariableDotExpression ) ) ) | ( () ( (lv_value_19_0= 'true' ) ) ) | ( () ( (lv_value_21_0= 'false' ) ) ) | ( () ( (lv_value_23_0= ruleDouble ) ) ) | ( () ( (lv_value_25_0= RULE_INT ) ) ) | ( () ( (lv_value_27_0= RULE_STRING ) ) ) | ( () ( (lv_value_29_0= ruleDate ) ) ) ) )
            // InternalSymboleo.g:5666:2: ( ( () otherlv_1= '(' ( (lv_inner_2_0= ruleProposition ) ) otherlv_3= ')' ) | ( () otherlv_5= 'not' ( (lv_negated_6_0= rulePAtomicExpression ) ) ) | ( () ( (lv_predicateFunction_8_0= rulePredicateFunction ) ) ) | ( () ( (lv_function_10_0= ruleOtherFunction ) ) ) | ( () ( (otherlv_12= RULE_ID ) ) otherlv_13= '(' ( (otherlv_14= RULE_ID ) ) otherlv_15= ')' ) | ( () ( (lv_variable_17_0= ruleVariableDotExpression ) ) ) | ( () ( (lv_value_19_0= 'true' ) ) ) | ( () ( (lv_value_21_0= 'false' ) ) ) | ( () ( (lv_value_23_0= ruleDouble ) ) ) | ( () ( (lv_value_25_0= RULE_INT ) ) ) | ( () ( (lv_value_27_0= RULE_STRING ) ) ) | ( () ( (lv_value_29_0= ruleDate ) ) ) )
            {
            // InternalSymboleo.g:5666:2: ( ( () otherlv_1= '(' ( (lv_inner_2_0= ruleProposition ) ) otherlv_3= ')' ) | ( () otherlv_5= 'not' ( (lv_negated_6_0= rulePAtomicExpression ) ) ) | ( () ( (lv_predicateFunction_8_0= rulePredicateFunction ) ) ) | ( () ( (lv_function_10_0= ruleOtherFunction ) ) ) | ( () ( (otherlv_12= RULE_ID ) ) otherlv_13= '(' ( (otherlv_14= RULE_ID ) ) otherlv_15= ')' ) | ( () ( (lv_variable_17_0= ruleVariableDotExpression ) ) ) | ( () ( (lv_value_19_0= 'true' ) ) ) | ( () ( (lv_value_21_0= 'false' ) ) ) | ( () ( (lv_value_23_0= ruleDouble ) ) ) | ( () ( (lv_value_25_0= RULE_INT ) ) ) | ( () ( (lv_value_27_0= RULE_STRING ) ) ) | ( () ( (lv_value_29_0= ruleDate ) ) ) )
            int alt84=12;
            alt84 = dfa84.predict(input);
            switch (alt84) {
                case 1 :
                    // InternalSymboleo.g:5667:3: ( () otherlv_1= '(' ( (lv_inner_2_0= ruleProposition ) ) otherlv_3= ')' )
                    {
                    // InternalSymboleo.g:5667:3: ( () otherlv_1= '(' ( (lv_inner_2_0= ruleProposition ) ) otherlv_3= ')' )
                    // InternalSymboleo.g:5668:4: () otherlv_1= '(' ( (lv_inner_2_0= ruleProposition ) ) otherlv_3= ')'
                    {
                    // InternalSymboleo.g:5668:4: ()
                    // InternalSymboleo.g:5669:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPAtomicExpressionAccess().getPAtomRecursiveAction_0_0(),
                    						current);
                    				

                    }

                    otherlv_1=(Token)match(input,17,FOLLOW_63); 

                    				newLeafNode(otherlv_1, grammarAccess.getPAtomicExpressionAccess().getLeftParenthesisKeyword_0_1());
                    			
                    // InternalSymboleo.g:5679:4: ( (lv_inner_2_0= ruleProposition ) )
                    // InternalSymboleo.g:5680:5: (lv_inner_2_0= ruleProposition )
                    {
                    // InternalSymboleo.g:5680:5: (lv_inner_2_0= ruleProposition )
                    // InternalSymboleo.g:5681:6: lv_inner_2_0= ruleProposition
                    {

                    						newCompositeNode(grammarAccess.getPAtomicExpressionAccess().getInnerPropositionParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_inner_2_0=ruleProposition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPAtomicExpressionRule());
                    						}
                    						set(
                    							current,
                    							"inner",
                    							lv_inner_2_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Proposition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_3, grammarAccess.getPAtomicExpressionAccess().getRightParenthesisKeyword_0_3());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:5704:3: ( () otherlv_5= 'not' ( (lv_negated_6_0= rulePAtomicExpression ) ) )
                    {
                    // InternalSymboleo.g:5704:3: ( () otherlv_5= 'not' ( (lv_negated_6_0= rulePAtomicExpression ) ) )
                    // InternalSymboleo.g:5705:4: () otherlv_5= 'not' ( (lv_negated_6_0= rulePAtomicExpression ) )
                    {
                    // InternalSymboleo.g:5705:4: ()
                    // InternalSymboleo.g:5706:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPAtomicExpressionAccess().getNegatedPAtomAction_1_0(),
                    						current);
                    				

                    }

                    otherlv_5=(Token)match(input,74,FOLLOW_63); 

                    				newLeafNode(otherlv_5, grammarAccess.getPAtomicExpressionAccess().getNotKeyword_1_1());
                    			
                    // InternalSymboleo.g:5716:4: ( (lv_negated_6_0= rulePAtomicExpression ) )
                    // InternalSymboleo.g:5717:5: (lv_negated_6_0= rulePAtomicExpression )
                    {
                    // InternalSymboleo.g:5717:5: (lv_negated_6_0= rulePAtomicExpression )
                    // InternalSymboleo.g:5718:6: lv_negated_6_0= rulePAtomicExpression
                    {

                    						newCompositeNode(grammarAccess.getPAtomicExpressionAccess().getNegatedPAtomicExpressionParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_negated_6_0=rulePAtomicExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPAtomicExpressionRule());
                    						}
                    						set(
                    							current,
                    							"negated",
                    							lv_negated_6_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.PAtomicExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:5737:3: ( () ( (lv_predicateFunction_8_0= rulePredicateFunction ) ) )
                    {
                    // InternalSymboleo.g:5737:3: ( () ( (lv_predicateFunction_8_0= rulePredicateFunction ) ) )
                    // InternalSymboleo.g:5738:4: () ( (lv_predicateFunction_8_0= rulePredicateFunction ) )
                    {
                    // InternalSymboleo.g:5738:4: ()
                    // InternalSymboleo.g:5739:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPAtomicExpressionAccess().getPAtomPredicateAction_2_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:5745:4: ( (lv_predicateFunction_8_0= rulePredicateFunction ) )
                    // InternalSymboleo.g:5746:5: (lv_predicateFunction_8_0= rulePredicateFunction )
                    {
                    // InternalSymboleo.g:5746:5: (lv_predicateFunction_8_0= rulePredicateFunction )
                    // InternalSymboleo.g:5747:6: lv_predicateFunction_8_0= rulePredicateFunction
                    {

                    						newCompositeNode(grammarAccess.getPAtomicExpressionAccess().getPredicateFunctionPredicateFunctionParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_predicateFunction_8_0=rulePredicateFunction();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPAtomicExpressionRule());
                    						}
                    						set(
                    							current,
                    							"predicateFunction",
                    							lv_predicateFunction_8_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.PredicateFunction");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalSymboleo.g:5766:3: ( () ( (lv_function_10_0= ruleOtherFunction ) ) )
                    {
                    // InternalSymboleo.g:5766:3: ( () ( (lv_function_10_0= ruleOtherFunction ) ) )
                    // InternalSymboleo.g:5767:4: () ( (lv_function_10_0= ruleOtherFunction ) )
                    {
                    // InternalSymboleo.g:5767:4: ()
                    // InternalSymboleo.g:5768:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPAtomicExpressionAccess().getPAtomFunctionAction_3_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:5774:4: ( (lv_function_10_0= ruleOtherFunction ) )
                    // InternalSymboleo.g:5775:5: (lv_function_10_0= ruleOtherFunction )
                    {
                    // InternalSymboleo.g:5775:5: (lv_function_10_0= ruleOtherFunction )
                    // InternalSymboleo.g:5776:6: lv_function_10_0= ruleOtherFunction
                    {

                    						newCompositeNode(grammarAccess.getPAtomicExpressionAccess().getFunctionOtherFunctionParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_function_10_0=ruleOtherFunction();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPAtomicExpressionRule());
                    						}
                    						set(
                    							current,
                    							"function",
                    							lv_function_10_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.OtherFunction");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalSymboleo.g:5795:3: ( () ( (otherlv_12= RULE_ID ) ) otherlv_13= '(' ( (otherlv_14= RULE_ID ) ) otherlv_15= ')' )
                    {
                    // InternalSymboleo.g:5795:3: ( () ( (otherlv_12= RULE_ID ) ) otherlv_13= '(' ( (otherlv_14= RULE_ID ) ) otherlv_15= ')' )
                    // InternalSymboleo.g:5796:4: () ( (otherlv_12= RULE_ID ) ) otherlv_13= '(' ( (otherlv_14= RULE_ID ) ) otherlv_15= ')'
                    {
                    // InternalSymboleo.g:5796:4: ()
                    // InternalSymboleo.g:5797:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPAtomicExpressionAccess().getPAtomEnumAction_4_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:5803:4: ( (otherlv_12= RULE_ID ) )
                    // InternalSymboleo.g:5804:5: (otherlv_12= RULE_ID )
                    {
                    // InternalSymboleo.g:5804:5: (otherlv_12= RULE_ID )
                    // InternalSymboleo.g:5805:6: otherlv_12= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPAtomicExpressionRule());
                    						}
                    					
                    otherlv_12=(Token)match(input,RULE_ID,FOLLOW_10); 

                    						newLeafNode(otherlv_12, grammarAccess.getPAtomicExpressionAccess().getEnumerationEnumerationCrossReference_4_1_0());
                    					

                    }


                    }

                    otherlv_13=(Token)match(input,17,FOLLOW_3); 

                    				newLeafNode(otherlv_13, grammarAccess.getPAtomicExpressionAccess().getLeftParenthesisKeyword_4_2());
                    			
                    // InternalSymboleo.g:5820:4: ( (otherlv_14= RULE_ID ) )
                    // InternalSymboleo.g:5821:5: (otherlv_14= RULE_ID )
                    {
                    // InternalSymboleo.g:5821:5: (otherlv_14= RULE_ID )
                    // InternalSymboleo.g:5822:6: otherlv_14= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPAtomicExpressionRule());
                    						}
                    					
                    otherlv_14=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_14, grammarAccess.getPAtomicExpressionAccess().getEnumItemEnumItemCrossReference_4_3_0());
                    					

                    }


                    }

                    otherlv_15=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_15, grammarAccess.getPAtomicExpressionAccess().getRightParenthesisKeyword_4_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalSymboleo.g:5839:3: ( () ( (lv_variable_17_0= ruleVariableDotExpression ) ) )
                    {
                    // InternalSymboleo.g:5839:3: ( () ( (lv_variable_17_0= ruleVariableDotExpression ) ) )
                    // InternalSymboleo.g:5840:4: () ( (lv_variable_17_0= ruleVariableDotExpression ) )
                    {
                    // InternalSymboleo.g:5840:4: ()
                    // InternalSymboleo.g:5841:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPAtomicExpressionAccess().getPAtomVariableAction_5_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:5847:4: ( (lv_variable_17_0= ruleVariableDotExpression ) )
                    // InternalSymboleo.g:5848:5: (lv_variable_17_0= ruleVariableDotExpression )
                    {
                    // InternalSymboleo.g:5848:5: (lv_variable_17_0= ruleVariableDotExpression )
                    // InternalSymboleo.g:5849:6: lv_variable_17_0= ruleVariableDotExpression
                    {

                    						newCompositeNode(grammarAccess.getPAtomicExpressionAccess().getVariableVariableDotExpressionParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_variable_17_0=ruleVariableDotExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPAtomicExpressionRule());
                    						}
                    						set(
                    							current,
                    							"variable",
                    							lv_variable_17_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.VariableDotExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalSymboleo.g:5868:3: ( () ( (lv_value_19_0= 'true' ) ) )
                    {
                    // InternalSymboleo.g:5868:3: ( () ( (lv_value_19_0= 'true' ) ) )
                    // InternalSymboleo.g:5869:4: () ( (lv_value_19_0= 'true' ) )
                    {
                    // InternalSymboleo.g:5869:4: ()
                    // InternalSymboleo.g:5870:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPAtomicExpressionAccess().getPAtomPredicateTrueLiteralAction_6_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:5876:4: ( (lv_value_19_0= 'true' ) )
                    // InternalSymboleo.g:5877:5: (lv_value_19_0= 'true' )
                    {
                    // InternalSymboleo.g:5877:5: (lv_value_19_0= 'true' )
                    // InternalSymboleo.g:5878:6: lv_value_19_0= 'true'
                    {
                    lv_value_19_0=(Token)match(input,75,FOLLOW_2); 

                    						newLeafNode(lv_value_19_0, grammarAccess.getPAtomicExpressionAccess().getValueTrueKeyword_6_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPAtomicExpressionRule());
                    						}
                    						setWithLastConsumed(current, "value", lv_value_19_0, "true");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalSymboleo.g:5892:3: ( () ( (lv_value_21_0= 'false' ) ) )
                    {
                    // InternalSymboleo.g:5892:3: ( () ( (lv_value_21_0= 'false' ) ) )
                    // InternalSymboleo.g:5893:4: () ( (lv_value_21_0= 'false' ) )
                    {
                    // InternalSymboleo.g:5893:4: ()
                    // InternalSymboleo.g:5894:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPAtomicExpressionAccess().getPAtomPredicateFalseLiteralAction_7_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:5900:4: ( (lv_value_21_0= 'false' ) )
                    // InternalSymboleo.g:5901:5: (lv_value_21_0= 'false' )
                    {
                    // InternalSymboleo.g:5901:5: (lv_value_21_0= 'false' )
                    // InternalSymboleo.g:5902:6: lv_value_21_0= 'false'
                    {
                    lv_value_21_0=(Token)match(input,76,FOLLOW_2); 

                    						newLeafNode(lv_value_21_0, grammarAccess.getPAtomicExpressionAccess().getValueFalseKeyword_7_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPAtomicExpressionRule());
                    						}
                    						setWithLastConsumed(current, "value", lv_value_21_0, "false");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 9 :
                    // InternalSymboleo.g:5916:3: ( () ( (lv_value_23_0= ruleDouble ) ) )
                    {
                    // InternalSymboleo.g:5916:3: ( () ( (lv_value_23_0= ruleDouble ) ) )
                    // InternalSymboleo.g:5917:4: () ( (lv_value_23_0= ruleDouble ) )
                    {
                    // InternalSymboleo.g:5917:4: ()
                    // InternalSymboleo.g:5918:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPAtomicExpressionAccess().getPAtomDoubleLiteralAction_8_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:5924:4: ( (lv_value_23_0= ruleDouble ) )
                    // InternalSymboleo.g:5925:5: (lv_value_23_0= ruleDouble )
                    {
                    // InternalSymboleo.g:5925:5: (lv_value_23_0= ruleDouble )
                    // InternalSymboleo.g:5926:6: lv_value_23_0= ruleDouble
                    {

                    						newCompositeNode(grammarAccess.getPAtomicExpressionAccess().getValueDoubleParserRuleCall_8_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_value_23_0=ruleDouble();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPAtomicExpressionRule());
                    						}
                    						set(
                    							current,
                    							"value",
                    							lv_value_23_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Double");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 10 :
                    // InternalSymboleo.g:5945:3: ( () ( (lv_value_25_0= RULE_INT ) ) )
                    {
                    // InternalSymboleo.g:5945:3: ( () ( (lv_value_25_0= RULE_INT ) ) )
                    // InternalSymboleo.g:5946:4: () ( (lv_value_25_0= RULE_INT ) )
                    {
                    // InternalSymboleo.g:5946:4: ()
                    // InternalSymboleo.g:5947:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPAtomicExpressionAccess().getPAtomIntLiteralAction_9_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:5953:4: ( (lv_value_25_0= RULE_INT ) )
                    // InternalSymboleo.g:5954:5: (lv_value_25_0= RULE_INT )
                    {
                    // InternalSymboleo.g:5954:5: (lv_value_25_0= RULE_INT )
                    // InternalSymboleo.g:5955:6: lv_value_25_0= RULE_INT
                    {
                    lv_value_25_0=(Token)match(input,RULE_INT,FOLLOW_2); 

                    						newLeafNode(lv_value_25_0, grammarAccess.getPAtomicExpressionAccess().getValueINTTerminalRuleCall_9_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPAtomicExpressionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"value",
                    							lv_value_25_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 11 :
                    // InternalSymboleo.g:5973:3: ( () ( (lv_value_27_0= RULE_STRING ) ) )
                    {
                    // InternalSymboleo.g:5973:3: ( () ( (lv_value_27_0= RULE_STRING ) ) )
                    // InternalSymboleo.g:5974:4: () ( (lv_value_27_0= RULE_STRING ) )
                    {
                    // InternalSymboleo.g:5974:4: ()
                    // InternalSymboleo.g:5975:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPAtomicExpressionAccess().getPAtomStringLiteralAction_10_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:5981:4: ( (lv_value_27_0= RULE_STRING ) )
                    // InternalSymboleo.g:5982:5: (lv_value_27_0= RULE_STRING )
                    {
                    // InternalSymboleo.g:5982:5: (lv_value_27_0= RULE_STRING )
                    // InternalSymboleo.g:5983:6: lv_value_27_0= RULE_STRING
                    {
                    lv_value_27_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    						newLeafNode(lv_value_27_0, grammarAccess.getPAtomicExpressionAccess().getValueSTRINGTerminalRuleCall_10_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPAtomicExpressionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"value",
                    							lv_value_27_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 12 :
                    // InternalSymboleo.g:6001:3: ( () ( (lv_value_29_0= ruleDate ) ) )
                    {
                    // InternalSymboleo.g:6001:3: ( () ( (lv_value_29_0= ruleDate ) ) )
                    // InternalSymboleo.g:6002:4: () ( (lv_value_29_0= ruleDate ) )
                    {
                    // InternalSymboleo.g:6002:4: ()
                    // InternalSymboleo.g:6003:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPAtomicExpressionAccess().getPAtomDateLiteralAction_11_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:6009:4: ( (lv_value_29_0= ruleDate ) )
                    // InternalSymboleo.g:6010:5: (lv_value_29_0= ruleDate )
                    {
                    // InternalSymboleo.g:6010:5: (lv_value_29_0= ruleDate )
                    // InternalSymboleo.g:6011:6: lv_value_29_0= ruleDate
                    {

                    						newCompositeNode(grammarAccess.getPAtomicExpressionAccess().getValueDateParserRuleCall_11_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_value_29_0=ruleDate();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPAtomicExpressionRule());
                    						}
                    						set(
                    							current,
                    							"value",
                    							lv_value_29_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Date");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePAtomicExpression"


    // $ANTLR start "entryRulePredicateFunction"
    // InternalSymboleo.g:6033:1: entryRulePredicateFunction returns [EObject current=null] : iv_rulePredicateFunction= rulePredicateFunction EOF ;
    public final EObject entryRulePredicateFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePredicateFunction = null;


        try {
            // InternalSymboleo.g:6033:58: (iv_rulePredicateFunction= rulePredicateFunction EOF )
            // InternalSymboleo.g:6034:2: iv_rulePredicateFunction= rulePredicateFunction EOF
            {
             newCompositeNode(grammarAccess.getPredicateFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePredicateFunction=rulePredicateFunction();

            state._fsp--;

             current =iv_rulePredicateFunction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePredicateFunction"


    // $ANTLR start "rulePredicateFunction"
    // InternalSymboleo.g:6040:1: rulePredicateFunction returns [EObject current=null] : ( ( () ( (lv_name_1_0= 'Happens' ) ) otherlv_2= '(' ( (lv_event_3_0= ruleEvent ) ) otherlv_4= ')' ) | ( () ( (lv_name_6_0= 'WhappensBefore' ) ) otherlv_7= '(' ( (lv_event_8_0= ruleEvent ) ) otherlv_9= ',' ( (lv_point_10_0= rulePoint ) ) otherlv_11= ')' ) | ( () ( (lv_name_13_0= 'ShappensBefore' ) ) otherlv_14= '(' ( (lv_event_15_0= ruleEvent ) ) otherlv_16= ',' ( (lv_point_17_0= rulePoint ) ) otherlv_18= ')' ) | ( () ( (lv_name_20_0= 'HappensWithin' ) ) otherlv_21= '(' ( (lv_event_22_0= ruleEvent ) ) otherlv_23= ',' ( (lv_interval_24_0= ruleInterval ) ) otherlv_25= ')' ) | ( () ( (lv_name_27_0= 'WhappensBeforeE' ) ) otherlv_28= '(' ( (lv_event1_29_0= ruleEvent ) ) otherlv_30= ',' ( (lv_event2_31_0= ruleEvent ) ) otherlv_32= ')' ) | ( () ( (lv_name_34_0= 'ShappensBeforeE' ) ) otherlv_35= '(' ( (lv_event1_36_0= ruleEvent ) ) otherlv_37= ',' ( (lv_event2_38_0= ruleEvent ) ) otherlv_39= ')' ) | ( () ( (lv_name_41_0= 'HappensAfter' ) ) otherlv_42= '(' ( (lv_event_43_0= ruleEvent ) ) otherlv_44= ',' ( (lv_point_45_0= rulePoint ) ) otherlv_46= ')' ) | ( () ( (lv_name_48_0= 'Occurs' ) ) otherlv_49= '(' ( (lv_situation_50_0= ruleSituation ) ) otherlv_51= ',' ( (lv_interval_52_0= ruleInterval ) ) otherlv_53= ')' ) | ( () ( (lv_name_55_0= 'HappensAssign' ) ) otherlv_56= '(' ( (lv_event_57_0= ruleEvent ) ) otherlv_58= ',' ( ( (lv_assignment_59_0= ruleOAssignment ) ) (otherlv_60= ';' ( (lv_assignment_61_0= ruleOAssignment ) ) )* )? otherlv_62= ')' ) | ( () ( (lv_name_64_0= 'Assign' ) ) otherlv_65= '(' ( ( (lv_assignment_66_0= ruleOAssignment ) ) (otherlv_67= ';' ( (lv_assignment_68_0= ruleOAssignment ) ) )* )? otherlv_69= ')' ) ) ;
    public final EObject rulePredicateFunction() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_name_6_0=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token lv_name_13_0=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token lv_name_20_0=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token otherlv_25=null;
        Token lv_name_27_0=null;
        Token otherlv_28=null;
        Token otherlv_30=null;
        Token otherlv_32=null;
        Token lv_name_34_0=null;
        Token otherlv_35=null;
        Token otherlv_37=null;
        Token otherlv_39=null;
        Token lv_name_41_0=null;
        Token otherlv_42=null;
        Token otherlv_44=null;
        Token otherlv_46=null;
        Token lv_name_48_0=null;
        Token otherlv_49=null;
        Token otherlv_51=null;
        Token otherlv_53=null;
        Token lv_name_55_0=null;
        Token otherlv_56=null;
        Token otherlv_58=null;
        Token otherlv_60=null;
        Token otherlv_62=null;
        Token lv_name_64_0=null;
        Token otherlv_65=null;
        Token otherlv_67=null;
        Token otherlv_69=null;
        EObject lv_event_3_0 = null;

        EObject lv_event_8_0 = null;

        EObject lv_point_10_0 = null;

        EObject lv_event_15_0 = null;

        EObject lv_point_17_0 = null;

        EObject lv_event_22_0 = null;

        EObject lv_interval_24_0 = null;

        EObject lv_event1_29_0 = null;

        EObject lv_event2_31_0 = null;

        EObject lv_event1_36_0 = null;

        EObject lv_event2_38_0 = null;

        EObject lv_event_43_0 = null;

        EObject lv_point_45_0 = null;

        EObject lv_situation_50_0 = null;

        EObject lv_interval_52_0 = null;

        EObject lv_event_57_0 = null;

        EObject lv_assignment_59_0 = null;

        EObject lv_assignment_61_0 = null;

        EObject lv_assignment_66_0 = null;

        EObject lv_assignment_68_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:6046:2: ( ( ( () ( (lv_name_1_0= 'Happens' ) ) otherlv_2= '(' ( (lv_event_3_0= ruleEvent ) ) otherlv_4= ')' ) | ( () ( (lv_name_6_0= 'WhappensBefore' ) ) otherlv_7= '(' ( (lv_event_8_0= ruleEvent ) ) otherlv_9= ',' ( (lv_point_10_0= rulePoint ) ) otherlv_11= ')' ) | ( () ( (lv_name_13_0= 'ShappensBefore' ) ) otherlv_14= '(' ( (lv_event_15_0= ruleEvent ) ) otherlv_16= ',' ( (lv_point_17_0= rulePoint ) ) otherlv_18= ')' ) | ( () ( (lv_name_20_0= 'HappensWithin' ) ) otherlv_21= '(' ( (lv_event_22_0= ruleEvent ) ) otherlv_23= ',' ( (lv_interval_24_0= ruleInterval ) ) otherlv_25= ')' ) | ( () ( (lv_name_27_0= 'WhappensBeforeE' ) ) otherlv_28= '(' ( (lv_event1_29_0= ruleEvent ) ) otherlv_30= ',' ( (lv_event2_31_0= ruleEvent ) ) otherlv_32= ')' ) | ( () ( (lv_name_34_0= 'ShappensBeforeE' ) ) otherlv_35= '(' ( (lv_event1_36_0= ruleEvent ) ) otherlv_37= ',' ( (lv_event2_38_0= ruleEvent ) ) otherlv_39= ')' ) | ( () ( (lv_name_41_0= 'HappensAfter' ) ) otherlv_42= '(' ( (lv_event_43_0= ruleEvent ) ) otherlv_44= ',' ( (lv_point_45_0= rulePoint ) ) otherlv_46= ')' ) | ( () ( (lv_name_48_0= 'Occurs' ) ) otherlv_49= '(' ( (lv_situation_50_0= ruleSituation ) ) otherlv_51= ',' ( (lv_interval_52_0= ruleInterval ) ) otherlv_53= ')' ) | ( () ( (lv_name_55_0= 'HappensAssign' ) ) otherlv_56= '(' ( (lv_event_57_0= ruleEvent ) ) otherlv_58= ',' ( ( (lv_assignment_59_0= ruleOAssignment ) ) (otherlv_60= ';' ( (lv_assignment_61_0= ruleOAssignment ) ) )* )? otherlv_62= ')' ) | ( () ( (lv_name_64_0= 'Assign' ) ) otherlv_65= '(' ( ( (lv_assignment_66_0= ruleOAssignment ) ) (otherlv_67= ';' ( (lv_assignment_68_0= ruleOAssignment ) ) )* )? otherlv_69= ')' ) ) )
            // InternalSymboleo.g:6047:2: ( ( () ( (lv_name_1_0= 'Happens' ) ) otherlv_2= '(' ( (lv_event_3_0= ruleEvent ) ) otherlv_4= ')' ) | ( () ( (lv_name_6_0= 'WhappensBefore' ) ) otherlv_7= '(' ( (lv_event_8_0= ruleEvent ) ) otherlv_9= ',' ( (lv_point_10_0= rulePoint ) ) otherlv_11= ')' ) | ( () ( (lv_name_13_0= 'ShappensBefore' ) ) otherlv_14= '(' ( (lv_event_15_0= ruleEvent ) ) otherlv_16= ',' ( (lv_point_17_0= rulePoint ) ) otherlv_18= ')' ) | ( () ( (lv_name_20_0= 'HappensWithin' ) ) otherlv_21= '(' ( (lv_event_22_0= ruleEvent ) ) otherlv_23= ',' ( (lv_interval_24_0= ruleInterval ) ) otherlv_25= ')' ) | ( () ( (lv_name_27_0= 'WhappensBeforeE' ) ) otherlv_28= '(' ( (lv_event1_29_0= ruleEvent ) ) otherlv_30= ',' ( (lv_event2_31_0= ruleEvent ) ) otherlv_32= ')' ) | ( () ( (lv_name_34_0= 'ShappensBeforeE' ) ) otherlv_35= '(' ( (lv_event1_36_0= ruleEvent ) ) otherlv_37= ',' ( (lv_event2_38_0= ruleEvent ) ) otherlv_39= ')' ) | ( () ( (lv_name_41_0= 'HappensAfter' ) ) otherlv_42= '(' ( (lv_event_43_0= ruleEvent ) ) otherlv_44= ',' ( (lv_point_45_0= rulePoint ) ) otherlv_46= ')' ) | ( () ( (lv_name_48_0= 'Occurs' ) ) otherlv_49= '(' ( (lv_situation_50_0= ruleSituation ) ) otherlv_51= ',' ( (lv_interval_52_0= ruleInterval ) ) otherlv_53= ')' ) | ( () ( (lv_name_55_0= 'HappensAssign' ) ) otherlv_56= '(' ( (lv_event_57_0= ruleEvent ) ) otherlv_58= ',' ( ( (lv_assignment_59_0= ruleOAssignment ) ) (otherlv_60= ';' ( (lv_assignment_61_0= ruleOAssignment ) ) )* )? otherlv_62= ')' ) | ( () ( (lv_name_64_0= 'Assign' ) ) otherlv_65= '(' ( ( (lv_assignment_66_0= ruleOAssignment ) ) (otherlv_67= ';' ( (lv_assignment_68_0= ruleOAssignment ) ) )* )? otherlv_69= ')' ) )
            {
            // InternalSymboleo.g:6047:2: ( ( () ( (lv_name_1_0= 'Happens' ) ) otherlv_2= '(' ( (lv_event_3_0= ruleEvent ) ) otherlv_4= ')' ) | ( () ( (lv_name_6_0= 'WhappensBefore' ) ) otherlv_7= '(' ( (lv_event_8_0= ruleEvent ) ) otherlv_9= ',' ( (lv_point_10_0= rulePoint ) ) otherlv_11= ')' ) | ( () ( (lv_name_13_0= 'ShappensBefore' ) ) otherlv_14= '(' ( (lv_event_15_0= ruleEvent ) ) otherlv_16= ',' ( (lv_point_17_0= rulePoint ) ) otherlv_18= ')' ) | ( () ( (lv_name_20_0= 'HappensWithin' ) ) otherlv_21= '(' ( (lv_event_22_0= ruleEvent ) ) otherlv_23= ',' ( (lv_interval_24_0= ruleInterval ) ) otherlv_25= ')' ) | ( () ( (lv_name_27_0= 'WhappensBeforeE' ) ) otherlv_28= '(' ( (lv_event1_29_0= ruleEvent ) ) otherlv_30= ',' ( (lv_event2_31_0= ruleEvent ) ) otherlv_32= ')' ) | ( () ( (lv_name_34_0= 'ShappensBeforeE' ) ) otherlv_35= '(' ( (lv_event1_36_0= ruleEvent ) ) otherlv_37= ',' ( (lv_event2_38_0= ruleEvent ) ) otherlv_39= ')' ) | ( () ( (lv_name_41_0= 'HappensAfter' ) ) otherlv_42= '(' ( (lv_event_43_0= ruleEvent ) ) otherlv_44= ',' ( (lv_point_45_0= rulePoint ) ) otherlv_46= ')' ) | ( () ( (lv_name_48_0= 'Occurs' ) ) otherlv_49= '(' ( (lv_situation_50_0= ruleSituation ) ) otherlv_51= ',' ( (lv_interval_52_0= ruleInterval ) ) otherlv_53= ')' ) | ( () ( (lv_name_55_0= 'HappensAssign' ) ) otherlv_56= '(' ( (lv_event_57_0= ruleEvent ) ) otherlv_58= ',' ( ( (lv_assignment_59_0= ruleOAssignment ) ) (otherlv_60= ';' ( (lv_assignment_61_0= ruleOAssignment ) ) )* )? otherlv_62= ')' ) | ( () ( (lv_name_64_0= 'Assign' ) ) otherlv_65= '(' ( ( (lv_assignment_66_0= ruleOAssignment ) ) (otherlv_67= ';' ( (lv_assignment_68_0= ruleOAssignment ) ) )* )? otherlv_69= ')' ) )
            int alt89=10;
            switch ( input.LA(1) ) {
            case 107:
                {
                alt89=1;
                }
                break;
            case 108:
                {
                alt89=2;
                }
                break;
            case 109:
                {
                alt89=3;
                }
                break;
            case 110:
                {
                alt89=4;
                }
                break;
            case 111:
                {
                alt89=5;
                }
                break;
            case 112:
                {
                alt89=6;
                }
                break;
            case 113:
                {
                alt89=7;
                }
                break;
            case 114:
                {
                alt89=8;
                }
                break;
            case 115:
                {
                alt89=9;
                }
                break;
            case 116:
                {
                alt89=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 89, 0, input);

                throw nvae;
            }

            switch (alt89) {
                case 1 :
                    // InternalSymboleo.g:6048:3: ( () ( (lv_name_1_0= 'Happens' ) ) otherlv_2= '(' ( (lv_event_3_0= ruleEvent ) ) otherlv_4= ')' )
                    {
                    // InternalSymboleo.g:6048:3: ( () ( (lv_name_1_0= 'Happens' ) ) otherlv_2= '(' ( (lv_event_3_0= ruleEvent ) ) otherlv_4= ')' )
                    // InternalSymboleo.g:6049:4: () ( (lv_name_1_0= 'Happens' ) ) otherlv_2= '(' ( (lv_event_3_0= ruleEvent ) ) otherlv_4= ')'
                    {
                    // InternalSymboleo.g:6049:4: ()
                    // InternalSymboleo.g:6050:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPredicateFunctionAccess().getPredicateFunctionHappensAction_0_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:6056:4: ( (lv_name_1_0= 'Happens' ) )
                    // InternalSymboleo.g:6057:5: (lv_name_1_0= 'Happens' )
                    {
                    // InternalSymboleo.g:6057:5: (lv_name_1_0= 'Happens' )
                    // InternalSymboleo.g:6058:6: lv_name_1_0= 'Happens'
                    {
                    lv_name_1_0=(Token)match(input,107,FOLLOW_10); 

                    						newLeafNode(lv_name_1_0, grammarAccess.getPredicateFunctionAccess().getNameHappensKeyword_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPredicateFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_1_0, "Happens");
                    					

                    }


                    }

                    otherlv_2=(Token)match(input,17,FOLLOW_70); 

                    				newLeafNode(otherlv_2, grammarAccess.getPredicateFunctionAccess().getLeftParenthesisKeyword_0_2());
                    			
                    // InternalSymboleo.g:6074:4: ( (lv_event_3_0= ruleEvent ) )
                    // InternalSymboleo.g:6075:5: (lv_event_3_0= ruleEvent )
                    {
                    // InternalSymboleo.g:6075:5: (lv_event_3_0= ruleEvent )
                    // InternalSymboleo.g:6076:6: lv_event_3_0= ruleEvent
                    {

                    						newCompositeNode(grammarAccess.getPredicateFunctionAccess().getEventEventParserRuleCall_0_3_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_event_3_0=ruleEvent();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                    						}
                    						set(
                    							current,
                    							"event",
                    							lv_event_3_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Event");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_4, grammarAccess.getPredicateFunctionAccess().getRightParenthesisKeyword_0_4());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:6099:3: ( () ( (lv_name_6_0= 'WhappensBefore' ) ) otherlv_7= '(' ( (lv_event_8_0= ruleEvent ) ) otherlv_9= ',' ( (lv_point_10_0= rulePoint ) ) otherlv_11= ')' )
                    {
                    // InternalSymboleo.g:6099:3: ( () ( (lv_name_6_0= 'WhappensBefore' ) ) otherlv_7= '(' ( (lv_event_8_0= ruleEvent ) ) otherlv_9= ',' ( (lv_point_10_0= rulePoint ) ) otherlv_11= ')' )
                    // InternalSymboleo.g:6100:4: () ( (lv_name_6_0= 'WhappensBefore' ) ) otherlv_7= '(' ( (lv_event_8_0= ruleEvent ) ) otherlv_9= ',' ( (lv_point_10_0= rulePoint ) ) otherlv_11= ')'
                    {
                    // InternalSymboleo.g:6100:4: ()
                    // InternalSymboleo.g:6101:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPredicateFunctionAccess().getPredicateFunctionWHappensBeforeAction_1_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:6107:4: ( (lv_name_6_0= 'WhappensBefore' ) )
                    // InternalSymboleo.g:6108:5: (lv_name_6_0= 'WhappensBefore' )
                    {
                    // InternalSymboleo.g:6108:5: (lv_name_6_0= 'WhappensBefore' )
                    // InternalSymboleo.g:6109:6: lv_name_6_0= 'WhappensBefore'
                    {
                    lv_name_6_0=(Token)match(input,108,FOLLOW_10); 

                    						newLeafNode(lv_name_6_0, grammarAccess.getPredicateFunctionAccess().getNameWhappensBeforeKeyword_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPredicateFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_6_0, "WhappensBefore");
                    					

                    }


                    }

                    otherlv_7=(Token)match(input,17,FOLLOW_70); 

                    				newLeafNode(otherlv_7, grammarAccess.getPredicateFunctionAccess().getLeftParenthesisKeyword_1_2());
                    			
                    // InternalSymboleo.g:6125:4: ( (lv_event_8_0= ruleEvent ) )
                    // InternalSymboleo.g:6126:5: (lv_event_8_0= ruleEvent )
                    {
                    // InternalSymboleo.g:6126:5: (lv_event_8_0= ruleEvent )
                    // InternalSymboleo.g:6127:6: lv_event_8_0= ruleEvent
                    {

                    						newCompositeNode(grammarAccess.getPredicateFunctionAccess().getEventEventParserRuleCall_1_3_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_event_8_0=ruleEvent();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                    						}
                    						set(
                    							current,
                    							"event",
                    							lv_event_8_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Event");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_9=(Token)match(input,18,FOLLOW_71); 

                    				newLeafNode(otherlv_9, grammarAccess.getPredicateFunctionAccess().getCommaKeyword_1_4());
                    			
                    // InternalSymboleo.g:6148:4: ( (lv_point_10_0= rulePoint ) )
                    // InternalSymboleo.g:6149:5: (lv_point_10_0= rulePoint )
                    {
                    // InternalSymboleo.g:6149:5: (lv_point_10_0= rulePoint )
                    // InternalSymboleo.g:6150:6: lv_point_10_0= rulePoint
                    {

                    						newCompositeNode(grammarAccess.getPredicateFunctionAccess().getPointPointParserRuleCall_1_5_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_point_10_0=rulePoint();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                    						}
                    						set(
                    							current,
                    							"point",
                    							lv_point_10_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Point");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getPredicateFunctionAccess().getRightParenthesisKeyword_1_6());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:6173:3: ( () ( (lv_name_13_0= 'ShappensBefore' ) ) otherlv_14= '(' ( (lv_event_15_0= ruleEvent ) ) otherlv_16= ',' ( (lv_point_17_0= rulePoint ) ) otherlv_18= ')' )
                    {
                    // InternalSymboleo.g:6173:3: ( () ( (lv_name_13_0= 'ShappensBefore' ) ) otherlv_14= '(' ( (lv_event_15_0= ruleEvent ) ) otherlv_16= ',' ( (lv_point_17_0= rulePoint ) ) otherlv_18= ')' )
                    // InternalSymboleo.g:6174:4: () ( (lv_name_13_0= 'ShappensBefore' ) ) otherlv_14= '(' ( (lv_event_15_0= ruleEvent ) ) otherlv_16= ',' ( (lv_point_17_0= rulePoint ) ) otherlv_18= ')'
                    {
                    // InternalSymboleo.g:6174:4: ()
                    // InternalSymboleo.g:6175:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPredicateFunctionAccess().getPredicateFunctionSHappensBeforeAction_2_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:6181:4: ( (lv_name_13_0= 'ShappensBefore' ) )
                    // InternalSymboleo.g:6182:5: (lv_name_13_0= 'ShappensBefore' )
                    {
                    // InternalSymboleo.g:6182:5: (lv_name_13_0= 'ShappensBefore' )
                    // InternalSymboleo.g:6183:6: lv_name_13_0= 'ShappensBefore'
                    {
                    lv_name_13_0=(Token)match(input,109,FOLLOW_10); 

                    						newLeafNode(lv_name_13_0, grammarAccess.getPredicateFunctionAccess().getNameShappensBeforeKeyword_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPredicateFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_13_0, "ShappensBefore");
                    					

                    }


                    }

                    otherlv_14=(Token)match(input,17,FOLLOW_70); 

                    				newLeafNode(otherlv_14, grammarAccess.getPredicateFunctionAccess().getLeftParenthesisKeyword_2_2());
                    			
                    // InternalSymboleo.g:6199:4: ( (lv_event_15_0= ruleEvent ) )
                    // InternalSymboleo.g:6200:5: (lv_event_15_0= ruleEvent )
                    {
                    // InternalSymboleo.g:6200:5: (lv_event_15_0= ruleEvent )
                    // InternalSymboleo.g:6201:6: lv_event_15_0= ruleEvent
                    {

                    						newCompositeNode(grammarAccess.getPredicateFunctionAccess().getEventEventParserRuleCall_2_3_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_event_15_0=ruleEvent();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                    						}
                    						set(
                    							current,
                    							"event",
                    							lv_event_15_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Event");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_16=(Token)match(input,18,FOLLOW_71); 

                    				newLeafNode(otherlv_16, grammarAccess.getPredicateFunctionAccess().getCommaKeyword_2_4());
                    			
                    // InternalSymboleo.g:6222:4: ( (lv_point_17_0= rulePoint ) )
                    // InternalSymboleo.g:6223:5: (lv_point_17_0= rulePoint )
                    {
                    // InternalSymboleo.g:6223:5: (lv_point_17_0= rulePoint )
                    // InternalSymboleo.g:6224:6: lv_point_17_0= rulePoint
                    {

                    						newCompositeNode(grammarAccess.getPredicateFunctionAccess().getPointPointParserRuleCall_2_5_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_point_17_0=rulePoint();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                    						}
                    						set(
                    							current,
                    							"point",
                    							lv_point_17_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Point");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_18=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_18, grammarAccess.getPredicateFunctionAccess().getRightParenthesisKeyword_2_6());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalSymboleo.g:6247:3: ( () ( (lv_name_20_0= 'HappensWithin' ) ) otherlv_21= '(' ( (lv_event_22_0= ruleEvent ) ) otherlv_23= ',' ( (lv_interval_24_0= ruleInterval ) ) otherlv_25= ')' )
                    {
                    // InternalSymboleo.g:6247:3: ( () ( (lv_name_20_0= 'HappensWithin' ) ) otherlv_21= '(' ( (lv_event_22_0= ruleEvent ) ) otherlv_23= ',' ( (lv_interval_24_0= ruleInterval ) ) otherlv_25= ')' )
                    // InternalSymboleo.g:6248:4: () ( (lv_name_20_0= 'HappensWithin' ) ) otherlv_21= '(' ( (lv_event_22_0= ruleEvent ) ) otherlv_23= ',' ( (lv_interval_24_0= ruleInterval ) ) otherlv_25= ')'
                    {
                    // InternalSymboleo.g:6248:4: ()
                    // InternalSymboleo.g:6249:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPredicateFunctionAccess().getPredicateFunctionHappensWithinAction_3_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:6255:4: ( (lv_name_20_0= 'HappensWithin' ) )
                    // InternalSymboleo.g:6256:5: (lv_name_20_0= 'HappensWithin' )
                    {
                    // InternalSymboleo.g:6256:5: (lv_name_20_0= 'HappensWithin' )
                    // InternalSymboleo.g:6257:6: lv_name_20_0= 'HappensWithin'
                    {
                    lv_name_20_0=(Token)match(input,110,FOLLOW_10); 

                    						newLeafNode(lv_name_20_0, grammarAccess.getPredicateFunctionAccess().getNameHappensWithinKeyword_3_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPredicateFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_20_0, "HappensWithin");
                    					

                    }


                    }

                    otherlv_21=(Token)match(input,17,FOLLOW_70); 

                    				newLeafNode(otherlv_21, grammarAccess.getPredicateFunctionAccess().getLeftParenthesisKeyword_3_2());
                    			
                    // InternalSymboleo.g:6273:4: ( (lv_event_22_0= ruleEvent ) )
                    // InternalSymboleo.g:6274:5: (lv_event_22_0= ruleEvent )
                    {
                    // InternalSymboleo.g:6274:5: (lv_event_22_0= ruleEvent )
                    // InternalSymboleo.g:6275:6: lv_event_22_0= ruleEvent
                    {

                    						newCompositeNode(grammarAccess.getPredicateFunctionAccess().getEventEventParserRuleCall_3_3_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_event_22_0=ruleEvent();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                    						}
                    						set(
                    							current,
                    							"event",
                    							lv_event_22_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Event");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_23=(Token)match(input,18,FOLLOW_72); 

                    				newLeafNode(otherlv_23, grammarAccess.getPredicateFunctionAccess().getCommaKeyword_3_4());
                    			
                    // InternalSymboleo.g:6296:4: ( (lv_interval_24_0= ruleInterval ) )
                    // InternalSymboleo.g:6297:5: (lv_interval_24_0= ruleInterval )
                    {
                    // InternalSymboleo.g:6297:5: (lv_interval_24_0= ruleInterval )
                    // InternalSymboleo.g:6298:6: lv_interval_24_0= ruleInterval
                    {

                    						newCompositeNode(grammarAccess.getPredicateFunctionAccess().getIntervalIntervalParserRuleCall_3_5_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_interval_24_0=ruleInterval();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                    						}
                    						set(
                    							current,
                    							"interval",
                    							lv_interval_24_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Interval");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_25=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_25, grammarAccess.getPredicateFunctionAccess().getRightParenthesisKeyword_3_6());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalSymboleo.g:6321:3: ( () ( (lv_name_27_0= 'WhappensBeforeE' ) ) otherlv_28= '(' ( (lv_event1_29_0= ruleEvent ) ) otherlv_30= ',' ( (lv_event2_31_0= ruleEvent ) ) otherlv_32= ')' )
                    {
                    // InternalSymboleo.g:6321:3: ( () ( (lv_name_27_0= 'WhappensBeforeE' ) ) otherlv_28= '(' ( (lv_event1_29_0= ruleEvent ) ) otherlv_30= ',' ( (lv_event2_31_0= ruleEvent ) ) otherlv_32= ')' )
                    // InternalSymboleo.g:6322:4: () ( (lv_name_27_0= 'WhappensBeforeE' ) ) otherlv_28= '(' ( (lv_event1_29_0= ruleEvent ) ) otherlv_30= ',' ( (lv_event2_31_0= ruleEvent ) ) otherlv_32= ')'
                    {
                    // InternalSymboleo.g:6322:4: ()
                    // InternalSymboleo.g:6323:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPredicateFunctionAccess().getPredicateFunctionWHappensBeforeEventAction_4_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:6329:4: ( (lv_name_27_0= 'WhappensBeforeE' ) )
                    // InternalSymboleo.g:6330:5: (lv_name_27_0= 'WhappensBeforeE' )
                    {
                    // InternalSymboleo.g:6330:5: (lv_name_27_0= 'WhappensBeforeE' )
                    // InternalSymboleo.g:6331:6: lv_name_27_0= 'WhappensBeforeE'
                    {
                    lv_name_27_0=(Token)match(input,111,FOLLOW_10); 

                    						newLeafNode(lv_name_27_0, grammarAccess.getPredicateFunctionAccess().getNameWhappensBeforeEKeyword_4_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPredicateFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_27_0, "WhappensBeforeE");
                    					

                    }


                    }

                    otherlv_28=(Token)match(input,17,FOLLOW_70); 

                    				newLeafNode(otherlv_28, grammarAccess.getPredicateFunctionAccess().getLeftParenthesisKeyword_4_2());
                    			
                    // InternalSymboleo.g:6347:4: ( (lv_event1_29_0= ruleEvent ) )
                    // InternalSymboleo.g:6348:5: (lv_event1_29_0= ruleEvent )
                    {
                    // InternalSymboleo.g:6348:5: (lv_event1_29_0= ruleEvent )
                    // InternalSymboleo.g:6349:6: lv_event1_29_0= ruleEvent
                    {

                    						newCompositeNode(grammarAccess.getPredicateFunctionAccess().getEvent1EventParserRuleCall_4_3_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_event1_29_0=ruleEvent();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                    						}
                    						set(
                    							current,
                    							"event1",
                    							lv_event1_29_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Event");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_30=(Token)match(input,18,FOLLOW_70); 

                    				newLeafNode(otherlv_30, grammarAccess.getPredicateFunctionAccess().getCommaKeyword_4_4());
                    			
                    // InternalSymboleo.g:6370:4: ( (lv_event2_31_0= ruleEvent ) )
                    // InternalSymboleo.g:6371:5: (lv_event2_31_0= ruleEvent )
                    {
                    // InternalSymboleo.g:6371:5: (lv_event2_31_0= ruleEvent )
                    // InternalSymboleo.g:6372:6: lv_event2_31_0= ruleEvent
                    {

                    						newCompositeNode(grammarAccess.getPredicateFunctionAccess().getEvent2EventParserRuleCall_4_5_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_event2_31_0=ruleEvent();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                    						}
                    						set(
                    							current,
                    							"event2",
                    							lv_event2_31_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Event");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_32=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_32, grammarAccess.getPredicateFunctionAccess().getRightParenthesisKeyword_4_6());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalSymboleo.g:6395:3: ( () ( (lv_name_34_0= 'ShappensBeforeE' ) ) otherlv_35= '(' ( (lv_event1_36_0= ruleEvent ) ) otherlv_37= ',' ( (lv_event2_38_0= ruleEvent ) ) otherlv_39= ')' )
                    {
                    // InternalSymboleo.g:6395:3: ( () ( (lv_name_34_0= 'ShappensBeforeE' ) ) otherlv_35= '(' ( (lv_event1_36_0= ruleEvent ) ) otherlv_37= ',' ( (lv_event2_38_0= ruleEvent ) ) otherlv_39= ')' )
                    // InternalSymboleo.g:6396:4: () ( (lv_name_34_0= 'ShappensBeforeE' ) ) otherlv_35= '(' ( (lv_event1_36_0= ruleEvent ) ) otherlv_37= ',' ( (lv_event2_38_0= ruleEvent ) ) otherlv_39= ')'
                    {
                    // InternalSymboleo.g:6396:4: ()
                    // InternalSymboleo.g:6397:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPredicateFunctionAccess().getPredicateFunctionSHappensBeforeEventAction_5_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:6403:4: ( (lv_name_34_0= 'ShappensBeforeE' ) )
                    // InternalSymboleo.g:6404:5: (lv_name_34_0= 'ShappensBeforeE' )
                    {
                    // InternalSymboleo.g:6404:5: (lv_name_34_0= 'ShappensBeforeE' )
                    // InternalSymboleo.g:6405:6: lv_name_34_0= 'ShappensBeforeE'
                    {
                    lv_name_34_0=(Token)match(input,112,FOLLOW_10); 

                    						newLeafNode(lv_name_34_0, grammarAccess.getPredicateFunctionAccess().getNameShappensBeforeEKeyword_5_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPredicateFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_34_0, "ShappensBeforeE");
                    					

                    }


                    }

                    otherlv_35=(Token)match(input,17,FOLLOW_70); 

                    				newLeafNode(otherlv_35, grammarAccess.getPredicateFunctionAccess().getLeftParenthesisKeyword_5_2());
                    			
                    // InternalSymboleo.g:6421:4: ( (lv_event1_36_0= ruleEvent ) )
                    // InternalSymboleo.g:6422:5: (lv_event1_36_0= ruleEvent )
                    {
                    // InternalSymboleo.g:6422:5: (lv_event1_36_0= ruleEvent )
                    // InternalSymboleo.g:6423:6: lv_event1_36_0= ruleEvent
                    {

                    						newCompositeNode(grammarAccess.getPredicateFunctionAccess().getEvent1EventParserRuleCall_5_3_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_event1_36_0=ruleEvent();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                    						}
                    						set(
                    							current,
                    							"event1",
                    							lv_event1_36_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Event");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_37=(Token)match(input,18,FOLLOW_70); 

                    				newLeafNode(otherlv_37, grammarAccess.getPredicateFunctionAccess().getCommaKeyword_5_4());
                    			
                    // InternalSymboleo.g:6444:4: ( (lv_event2_38_0= ruleEvent ) )
                    // InternalSymboleo.g:6445:5: (lv_event2_38_0= ruleEvent )
                    {
                    // InternalSymboleo.g:6445:5: (lv_event2_38_0= ruleEvent )
                    // InternalSymboleo.g:6446:6: lv_event2_38_0= ruleEvent
                    {

                    						newCompositeNode(grammarAccess.getPredicateFunctionAccess().getEvent2EventParserRuleCall_5_5_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_event2_38_0=ruleEvent();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                    						}
                    						set(
                    							current,
                    							"event2",
                    							lv_event2_38_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Event");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_39=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_39, grammarAccess.getPredicateFunctionAccess().getRightParenthesisKeyword_5_6());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalSymboleo.g:6469:3: ( () ( (lv_name_41_0= 'HappensAfter' ) ) otherlv_42= '(' ( (lv_event_43_0= ruleEvent ) ) otherlv_44= ',' ( (lv_point_45_0= rulePoint ) ) otherlv_46= ')' )
                    {
                    // InternalSymboleo.g:6469:3: ( () ( (lv_name_41_0= 'HappensAfter' ) ) otherlv_42= '(' ( (lv_event_43_0= ruleEvent ) ) otherlv_44= ',' ( (lv_point_45_0= rulePoint ) ) otherlv_46= ')' )
                    // InternalSymboleo.g:6470:4: () ( (lv_name_41_0= 'HappensAfter' ) ) otherlv_42= '(' ( (lv_event_43_0= ruleEvent ) ) otherlv_44= ',' ( (lv_point_45_0= rulePoint ) ) otherlv_46= ')'
                    {
                    // InternalSymboleo.g:6470:4: ()
                    // InternalSymboleo.g:6471:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPredicateFunctionAccess().getPredicateFunctionHappensAfterAction_6_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:6477:4: ( (lv_name_41_0= 'HappensAfter' ) )
                    // InternalSymboleo.g:6478:5: (lv_name_41_0= 'HappensAfter' )
                    {
                    // InternalSymboleo.g:6478:5: (lv_name_41_0= 'HappensAfter' )
                    // InternalSymboleo.g:6479:6: lv_name_41_0= 'HappensAfter'
                    {
                    lv_name_41_0=(Token)match(input,113,FOLLOW_10); 

                    						newLeafNode(lv_name_41_0, grammarAccess.getPredicateFunctionAccess().getNameHappensAfterKeyword_6_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPredicateFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_41_0, "HappensAfter");
                    					

                    }


                    }

                    otherlv_42=(Token)match(input,17,FOLLOW_70); 

                    				newLeafNode(otherlv_42, grammarAccess.getPredicateFunctionAccess().getLeftParenthesisKeyword_6_2());
                    			
                    // InternalSymboleo.g:6495:4: ( (lv_event_43_0= ruleEvent ) )
                    // InternalSymboleo.g:6496:5: (lv_event_43_0= ruleEvent )
                    {
                    // InternalSymboleo.g:6496:5: (lv_event_43_0= ruleEvent )
                    // InternalSymboleo.g:6497:6: lv_event_43_0= ruleEvent
                    {

                    						newCompositeNode(grammarAccess.getPredicateFunctionAccess().getEventEventParserRuleCall_6_3_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_event_43_0=ruleEvent();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                    						}
                    						set(
                    							current,
                    							"event",
                    							lv_event_43_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Event");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_44=(Token)match(input,18,FOLLOW_71); 

                    				newLeafNode(otherlv_44, grammarAccess.getPredicateFunctionAccess().getCommaKeyword_6_4());
                    			
                    // InternalSymboleo.g:6518:4: ( (lv_point_45_0= rulePoint ) )
                    // InternalSymboleo.g:6519:5: (lv_point_45_0= rulePoint )
                    {
                    // InternalSymboleo.g:6519:5: (lv_point_45_0= rulePoint )
                    // InternalSymboleo.g:6520:6: lv_point_45_0= rulePoint
                    {

                    						newCompositeNode(grammarAccess.getPredicateFunctionAccess().getPointPointParserRuleCall_6_5_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_point_45_0=rulePoint();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                    						}
                    						set(
                    							current,
                    							"point",
                    							lv_point_45_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Point");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_46=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_46, grammarAccess.getPredicateFunctionAccess().getRightParenthesisKeyword_6_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalSymboleo.g:6543:3: ( () ( (lv_name_48_0= 'Occurs' ) ) otherlv_49= '(' ( (lv_situation_50_0= ruleSituation ) ) otherlv_51= ',' ( (lv_interval_52_0= ruleInterval ) ) otherlv_53= ')' )
                    {
                    // InternalSymboleo.g:6543:3: ( () ( (lv_name_48_0= 'Occurs' ) ) otherlv_49= '(' ( (lv_situation_50_0= ruleSituation ) ) otherlv_51= ',' ( (lv_interval_52_0= ruleInterval ) ) otherlv_53= ')' )
                    // InternalSymboleo.g:6544:4: () ( (lv_name_48_0= 'Occurs' ) ) otherlv_49= '(' ( (lv_situation_50_0= ruleSituation ) ) otherlv_51= ',' ( (lv_interval_52_0= ruleInterval ) ) otherlv_53= ')'
                    {
                    // InternalSymboleo.g:6544:4: ()
                    // InternalSymboleo.g:6545:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPredicateFunctionAccess().getPredicateFunctionOccursAction_7_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:6551:4: ( (lv_name_48_0= 'Occurs' ) )
                    // InternalSymboleo.g:6552:5: (lv_name_48_0= 'Occurs' )
                    {
                    // InternalSymboleo.g:6552:5: (lv_name_48_0= 'Occurs' )
                    // InternalSymboleo.g:6553:6: lv_name_48_0= 'Occurs'
                    {
                    lv_name_48_0=(Token)match(input,114,FOLLOW_10); 

                    						newLeafNode(lv_name_48_0, grammarAccess.getPredicateFunctionAccess().getNameOccursKeyword_7_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPredicateFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_48_0, "Occurs");
                    					

                    }


                    }

                    otherlv_49=(Token)match(input,17,FOLLOW_72); 

                    				newLeafNode(otherlv_49, grammarAccess.getPredicateFunctionAccess().getLeftParenthesisKeyword_7_2());
                    			
                    // InternalSymboleo.g:6569:4: ( (lv_situation_50_0= ruleSituation ) )
                    // InternalSymboleo.g:6570:5: (lv_situation_50_0= ruleSituation )
                    {
                    // InternalSymboleo.g:6570:5: (lv_situation_50_0= ruleSituation )
                    // InternalSymboleo.g:6571:6: lv_situation_50_0= ruleSituation
                    {

                    						newCompositeNode(grammarAccess.getPredicateFunctionAccess().getSituationSituationParserRuleCall_7_3_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_situation_50_0=ruleSituation();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                    						}
                    						set(
                    							current,
                    							"situation",
                    							lv_situation_50_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Situation");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_51=(Token)match(input,18,FOLLOW_72); 

                    				newLeafNode(otherlv_51, grammarAccess.getPredicateFunctionAccess().getCommaKeyword_7_4());
                    			
                    // InternalSymboleo.g:6592:4: ( (lv_interval_52_0= ruleInterval ) )
                    // InternalSymboleo.g:6593:5: (lv_interval_52_0= ruleInterval )
                    {
                    // InternalSymboleo.g:6593:5: (lv_interval_52_0= ruleInterval )
                    // InternalSymboleo.g:6594:6: lv_interval_52_0= ruleInterval
                    {

                    						newCompositeNode(grammarAccess.getPredicateFunctionAccess().getIntervalIntervalParserRuleCall_7_5_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_interval_52_0=ruleInterval();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                    						}
                    						set(
                    							current,
                    							"interval",
                    							lv_interval_52_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Interval");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_53=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_53, grammarAccess.getPredicateFunctionAccess().getRightParenthesisKeyword_7_6());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalSymboleo.g:6617:3: ( () ( (lv_name_55_0= 'HappensAssign' ) ) otherlv_56= '(' ( (lv_event_57_0= ruleEvent ) ) otherlv_58= ',' ( ( (lv_assignment_59_0= ruleOAssignment ) ) (otherlv_60= ';' ( (lv_assignment_61_0= ruleOAssignment ) ) )* )? otherlv_62= ')' )
                    {
                    // InternalSymboleo.g:6617:3: ( () ( (lv_name_55_0= 'HappensAssign' ) ) otherlv_56= '(' ( (lv_event_57_0= ruleEvent ) ) otherlv_58= ',' ( ( (lv_assignment_59_0= ruleOAssignment ) ) (otherlv_60= ';' ( (lv_assignment_61_0= ruleOAssignment ) ) )* )? otherlv_62= ')' )
                    // InternalSymboleo.g:6618:4: () ( (lv_name_55_0= 'HappensAssign' ) ) otherlv_56= '(' ( (lv_event_57_0= ruleEvent ) ) otherlv_58= ',' ( ( (lv_assignment_59_0= ruleOAssignment ) ) (otherlv_60= ';' ( (lv_assignment_61_0= ruleOAssignment ) ) )* )? otherlv_62= ')'
                    {
                    // InternalSymboleo.g:6618:4: ()
                    // InternalSymboleo.g:6619:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPredicateFunctionAccess().getPredicateFunctionAssignmentAction_8_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:6625:4: ( (lv_name_55_0= 'HappensAssign' ) )
                    // InternalSymboleo.g:6626:5: (lv_name_55_0= 'HappensAssign' )
                    {
                    // InternalSymboleo.g:6626:5: (lv_name_55_0= 'HappensAssign' )
                    // InternalSymboleo.g:6627:6: lv_name_55_0= 'HappensAssign'
                    {
                    lv_name_55_0=(Token)match(input,115,FOLLOW_10); 

                    						newLeafNode(lv_name_55_0, grammarAccess.getPredicateFunctionAccess().getNameHappensAssignKeyword_8_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPredicateFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_55_0, "HappensAssign");
                    					

                    }


                    }

                    otherlv_56=(Token)match(input,17,FOLLOW_70); 

                    				newLeafNode(otherlv_56, grammarAccess.getPredicateFunctionAccess().getLeftParenthesisKeyword_8_2());
                    			
                    // InternalSymboleo.g:6643:4: ( (lv_event_57_0= ruleEvent ) )
                    // InternalSymboleo.g:6644:5: (lv_event_57_0= ruleEvent )
                    {
                    // InternalSymboleo.g:6644:5: (lv_event_57_0= ruleEvent )
                    // InternalSymboleo.g:6645:6: lv_event_57_0= ruleEvent
                    {

                    						newCompositeNode(grammarAccess.getPredicateFunctionAccess().getEventEventParserRuleCall_8_3_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_event_57_0=ruleEvent();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                    						}
                    						set(
                    							current,
                    							"event",
                    							lv_event_57_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Event");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_58=(Token)match(input,18,FOLLOW_35); 

                    				newLeafNode(otherlv_58, grammarAccess.getPredicateFunctionAccess().getCommaKeyword_8_4());
                    			
                    // InternalSymboleo.g:6666:4: ( ( (lv_assignment_59_0= ruleOAssignment ) ) (otherlv_60= ';' ( (lv_assignment_61_0= ruleOAssignment ) ) )* )?
                    int alt86=2;
                    int LA86_0 = input.LA(1);

                    if ( (LA86_0==RULE_ID) ) {
                        alt86=1;
                    }
                    switch (alt86) {
                        case 1 :
                            // InternalSymboleo.g:6667:5: ( (lv_assignment_59_0= ruleOAssignment ) ) (otherlv_60= ';' ( (lv_assignment_61_0= ruleOAssignment ) ) )*
                            {
                            // InternalSymboleo.g:6667:5: ( (lv_assignment_59_0= ruleOAssignment ) )
                            // InternalSymboleo.g:6668:6: (lv_assignment_59_0= ruleOAssignment )
                            {
                            // InternalSymboleo.g:6668:6: (lv_assignment_59_0= ruleOAssignment )
                            // InternalSymboleo.g:6669:7: lv_assignment_59_0= ruleOAssignment
                            {

                            							newCompositeNode(grammarAccess.getPredicateFunctionAccess().getAssignmentOAssignmentParserRuleCall_8_5_0_0());
                            						
                            pushFollow(FOLLOW_73);
                            lv_assignment_59_0=ruleOAssignment();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                            							}
                            							add(
                            								current,
                            								"assignment",
                            								lv_assignment_59_0,
                            								"ca.uottawa.csmlab.symboleo.Symboleo.OAssignment");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }

                            // InternalSymboleo.g:6686:5: (otherlv_60= ';' ( (lv_assignment_61_0= ruleOAssignment ) ) )*
                            loop85:
                            do {
                                int alt85=2;
                                int LA85_0 = input.LA(1);

                                if ( (LA85_0==12) ) {
                                    alt85=1;
                                }


                                switch (alt85) {
                            	case 1 :
                            	    // InternalSymboleo.g:6687:6: otherlv_60= ';' ( (lv_assignment_61_0= ruleOAssignment ) )
                            	    {
                            	    otherlv_60=(Token)match(input,12,FOLLOW_3); 

                            	    						newLeafNode(otherlv_60, grammarAccess.getPredicateFunctionAccess().getSemicolonKeyword_8_5_1_0());
                            	    					
                            	    // InternalSymboleo.g:6691:6: ( (lv_assignment_61_0= ruleOAssignment ) )
                            	    // InternalSymboleo.g:6692:7: (lv_assignment_61_0= ruleOAssignment )
                            	    {
                            	    // InternalSymboleo.g:6692:7: (lv_assignment_61_0= ruleOAssignment )
                            	    // InternalSymboleo.g:6693:8: lv_assignment_61_0= ruleOAssignment
                            	    {

                            	    								newCompositeNode(grammarAccess.getPredicateFunctionAccess().getAssignmentOAssignmentParserRuleCall_8_5_1_1_0());
                            	    							
                            	    pushFollow(FOLLOW_73);
                            	    lv_assignment_61_0=ruleOAssignment();

                            	    state._fsp--;


                            	    								if (current==null) {
                            	    									current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                            	    								}
                            	    								add(
                            	    									current,
                            	    									"assignment",
                            	    									lv_assignment_61_0,
                            	    									"ca.uottawa.csmlab.symboleo.Symboleo.OAssignment");
                            	    								afterParserOrEnumRuleCall();
                            	    							

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop85;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_62=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_62, grammarAccess.getPredicateFunctionAccess().getRightParenthesisKeyword_8_6());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalSymboleo.g:6718:3: ( () ( (lv_name_64_0= 'Assign' ) ) otherlv_65= '(' ( ( (lv_assignment_66_0= ruleOAssignment ) ) (otherlv_67= ';' ( (lv_assignment_68_0= ruleOAssignment ) ) )* )? otherlv_69= ')' )
                    {
                    // InternalSymboleo.g:6718:3: ( () ( (lv_name_64_0= 'Assign' ) ) otherlv_65= '(' ( ( (lv_assignment_66_0= ruleOAssignment ) ) (otherlv_67= ';' ( (lv_assignment_68_0= ruleOAssignment ) ) )* )? otherlv_69= ')' )
                    // InternalSymboleo.g:6719:4: () ( (lv_name_64_0= 'Assign' ) ) otherlv_65= '(' ( ( (lv_assignment_66_0= ruleOAssignment ) ) (otherlv_67= ';' ( (lv_assignment_68_0= ruleOAssignment ) ) )* )? otherlv_69= ')'
                    {
                    // InternalSymboleo.g:6719:4: ()
                    // InternalSymboleo.g:6720:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPredicateFunctionAccess().getPredicateFunctionAssignmentOnlyAction_9_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:6726:4: ( (lv_name_64_0= 'Assign' ) )
                    // InternalSymboleo.g:6727:5: (lv_name_64_0= 'Assign' )
                    {
                    // InternalSymboleo.g:6727:5: (lv_name_64_0= 'Assign' )
                    // InternalSymboleo.g:6728:6: lv_name_64_0= 'Assign'
                    {
                    lv_name_64_0=(Token)match(input,116,FOLLOW_10); 

                    						newLeafNode(lv_name_64_0, grammarAccess.getPredicateFunctionAccess().getNameAssignKeyword_9_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPredicateFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_64_0, "Assign");
                    					

                    }


                    }

                    otherlv_65=(Token)match(input,17,FOLLOW_35); 

                    				newLeafNode(otherlv_65, grammarAccess.getPredicateFunctionAccess().getLeftParenthesisKeyword_9_2());
                    			
                    // InternalSymboleo.g:6744:4: ( ( (lv_assignment_66_0= ruleOAssignment ) ) (otherlv_67= ';' ( (lv_assignment_68_0= ruleOAssignment ) ) )* )?
                    int alt88=2;
                    int LA88_0 = input.LA(1);

                    if ( (LA88_0==RULE_ID) ) {
                        alt88=1;
                    }
                    switch (alt88) {
                        case 1 :
                            // InternalSymboleo.g:6745:5: ( (lv_assignment_66_0= ruleOAssignment ) ) (otherlv_67= ';' ( (lv_assignment_68_0= ruleOAssignment ) ) )*
                            {
                            // InternalSymboleo.g:6745:5: ( (lv_assignment_66_0= ruleOAssignment ) )
                            // InternalSymboleo.g:6746:6: (lv_assignment_66_0= ruleOAssignment )
                            {
                            // InternalSymboleo.g:6746:6: (lv_assignment_66_0= ruleOAssignment )
                            // InternalSymboleo.g:6747:7: lv_assignment_66_0= ruleOAssignment
                            {

                            							newCompositeNode(grammarAccess.getPredicateFunctionAccess().getAssignmentOAssignmentParserRuleCall_9_3_0_0());
                            						
                            pushFollow(FOLLOW_73);
                            lv_assignment_66_0=ruleOAssignment();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                            							}
                            							add(
                            								current,
                            								"assignment",
                            								lv_assignment_66_0,
                            								"ca.uottawa.csmlab.symboleo.Symboleo.OAssignment");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }

                            // InternalSymboleo.g:6764:5: (otherlv_67= ';' ( (lv_assignment_68_0= ruleOAssignment ) ) )*
                            loop87:
                            do {
                                int alt87=2;
                                int LA87_0 = input.LA(1);

                                if ( (LA87_0==12) ) {
                                    alt87=1;
                                }


                                switch (alt87) {
                            	case 1 :
                            	    // InternalSymboleo.g:6765:6: otherlv_67= ';' ( (lv_assignment_68_0= ruleOAssignment ) )
                            	    {
                            	    otherlv_67=(Token)match(input,12,FOLLOW_3); 

                            	    						newLeafNode(otherlv_67, grammarAccess.getPredicateFunctionAccess().getSemicolonKeyword_9_3_1_0());
                            	    					
                            	    // InternalSymboleo.g:6769:6: ( (lv_assignment_68_0= ruleOAssignment ) )
                            	    // InternalSymboleo.g:6770:7: (lv_assignment_68_0= ruleOAssignment )
                            	    {
                            	    // InternalSymboleo.g:6770:7: (lv_assignment_68_0= ruleOAssignment )
                            	    // InternalSymboleo.g:6771:8: lv_assignment_68_0= ruleOAssignment
                            	    {

                            	    								newCompositeNode(grammarAccess.getPredicateFunctionAccess().getAssignmentOAssignmentParserRuleCall_9_3_1_1_0());
                            	    							
                            	    pushFollow(FOLLOW_73);
                            	    lv_assignment_68_0=ruleOAssignment();

                            	    state._fsp--;


                            	    								if (current==null) {
                            	    									current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                            	    								}
                            	    								add(
                            	    									current,
                            	    									"assignment",
                            	    									lv_assignment_68_0,
                            	    									"ca.uottawa.csmlab.symboleo.Symboleo.OAssignment");
                            	    								afterParserOrEnumRuleCall();
                            	    							

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop87;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_69=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_69, grammarAccess.getPredicateFunctionAccess().getRightParenthesisKeyword_9_4());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePredicateFunction"


    // $ANTLR start "entryRuleOtherFunction"
    // InternalSymboleo.g:6799:1: entryRuleOtherFunction returns [EObject current=null] : iv_ruleOtherFunction= ruleOtherFunction EOF ;
    public final EObject entryRuleOtherFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOtherFunction = null;


        try {
            // InternalSymboleo.g:6799:54: (iv_ruleOtherFunction= ruleOtherFunction EOF )
            // InternalSymboleo.g:6800:2: iv_ruleOtherFunction= ruleOtherFunction EOF
            {
             newCompositeNode(grammarAccess.getOtherFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOtherFunction=ruleOtherFunction();

            state._fsp--;

             current =iv_ruleOtherFunction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOtherFunction"


    // $ANTLR start "ruleOtherFunction"
    // InternalSymboleo.g:6806:1: ruleOtherFunction returns [EObject current=null] : ( ( () ( (lv_name_1_0= 'IsEqual' ) ) otherlv_2= '(' ( (lv_arg1_3_0= RULE_ID ) ) otherlv_4= ',' ( (lv_arg2_5_0= RULE_ID ) ) otherlv_6= ')' ) | ( () ( (lv_name_8_0= 'IsOwner' ) ) otherlv_9= '(' ( (lv_arg1_10_0= RULE_ID ) ) otherlv_11= ',' ( (lv_arg2_12_0= RULE_ID ) ) otherlv_13= ')' ) | ( () ( (lv_name_15_0= 'CannotBeAssigned' ) ) otherlv_16= '(' ( (lv_arg1_17_0= RULE_ID ) ) otherlv_18= ')' ) ) ;
    public final EObject ruleOtherFunction() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_arg1_3_0=null;
        Token otherlv_4=null;
        Token lv_arg2_5_0=null;
        Token otherlv_6=null;
        Token lv_name_8_0=null;
        Token otherlv_9=null;
        Token lv_arg1_10_0=null;
        Token otherlv_11=null;
        Token lv_arg2_12_0=null;
        Token otherlv_13=null;
        Token lv_name_15_0=null;
        Token otherlv_16=null;
        Token lv_arg1_17_0=null;
        Token otherlv_18=null;


        	enterRule();

        try {
            // InternalSymboleo.g:6812:2: ( ( ( () ( (lv_name_1_0= 'IsEqual' ) ) otherlv_2= '(' ( (lv_arg1_3_0= RULE_ID ) ) otherlv_4= ',' ( (lv_arg2_5_0= RULE_ID ) ) otherlv_6= ')' ) | ( () ( (lv_name_8_0= 'IsOwner' ) ) otherlv_9= '(' ( (lv_arg1_10_0= RULE_ID ) ) otherlv_11= ',' ( (lv_arg2_12_0= RULE_ID ) ) otherlv_13= ')' ) | ( () ( (lv_name_15_0= 'CannotBeAssigned' ) ) otherlv_16= '(' ( (lv_arg1_17_0= RULE_ID ) ) otherlv_18= ')' ) ) )
            // InternalSymboleo.g:6813:2: ( ( () ( (lv_name_1_0= 'IsEqual' ) ) otherlv_2= '(' ( (lv_arg1_3_0= RULE_ID ) ) otherlv_4= ',' ( (lv_arg2_5_0= RULE_ID ) ) otherlv_6= ')' ) | ( () ( (lv_name_8_0= 'IsOwner' ) ) otherlv_9= '(' ( (lv_arg1_10_0= RULE_ID ) ) otherlv_11= ',' ( (lv_arg2_12_0= RULE_ID ) ) otherlv_13= ')' ) | ( () ( (lv_name_15_0= 'CannotBeAssigned' ) ) otherlv_16= '(' ( (lv_arg1_17_0= RULE_ID ) ) otherlv_18= ')' ) )
            {
            // InternalSymboleo.g:6813:2: ( ( () ( (lv_name_1_0= 'IsEqual' ) ) otherlv_2= '(' ( (lv_arg1_3_0= RULE_ID ) ) otherlv_4= ',' ( (lv_arg2_5_0= RULE_ID ) ) otherlv_6= ')' ) | ( () ( (lv_name_8_0= 'IsOwner' ) ) otherlv_9= '(' ( (lv_arg1_10_0= RULE_ID ) ) otherlv_11= ',' ( (lv_arg2_12_0= RULE_ID ) ) otherlv_13= ')' ) | ( () ( (lv_name_15_0= 'CannotBeAssigned' ) ) otherlv_16= '(' ( (lv_arg1_17_0= RULE_ID ) ) otherlv_18= ')' ) )
            int alt90=3;
            switch ( input.LA(1) ) {
            case 117:
                {
                alt90=1;
                }
                break;
            case 118:
                {
                alt90=2;
                }
                break;
            case 119:
                {
                alt90=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 90, 0, input);

                throw nvae;
            }

            switch (alt90) {
                case 1 :
                    // InternalSymboleo.g:6814:3: ( () ( (lv_name_1_0= 'IsEqual' ) ) otherlv_2= '(' ( (lv_arg1_3_0= RULE_ID ) ) otherlv_4= ',' ( (lv_arg2_5_0= RULE_ID ) ) otherlv_6= ')' )
                    {
                    // InternalSymboleo.g:6814:3: ( () ( (lv_name_1_0= 'IsEqual' ) ) otherlv_2= '(' ( (lv_arg1_3_0= RULE_ID ) ) otherlv_4= ',' ( (lv_arg2_5_0= RULE_ID ) ) otherlv_6= ')' )
                    // InternalSymboleo.g:6815:4: () ( (lv_name_1_0= 'IsEqual' ) ) otherlv_2= '(' ( (lv_arg1_3_0= RULE_ID ) ) otherlv_4= ',' ( (lv_arg2_5_0= RULE_ID ) ) otherlv_6= ')'
                    {
                    // InternalSymboleo.g:6815:4: ()
                    // InternalSymboleo.g:6816:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getOtherFunctionAccess().getPredicateFunctionIsEqualAction_0_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:6822:4: ( (lv_name_1_0= 'IsEqual' ) )
                    // InternalSymboleo.g:6823:5: (lv_name_1_0= 'IsEqual' )
                    {
                    // InternalSymboleo.g:6823:5: (lv_name_1_0= 'IsEqual' )
                    // InternalSymboleo.g:6824:6: lv_name_1_0= 'IsEqual'
                    {
                    lv_name_1_0=(Token)match(input,117,FOLLOW_10); 

                    						newLeafNode(lv_name_1_0, grammarAccess.getOtherFunctionAccess().getNameIsEqualKeyword_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOtherFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_1_0, "IsEqual");
                    					

                    }


                    }

                    otherlv_2=(Token)match(input,17,FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getOtherFunctionAccess().getLeftParenthesisKeyword_0_2());
                    			
                    // InternalSymboleo.g:6840:4: ( (lv_arg1_3_0= RULE_ID ) )
                    // InternalSymboleo.g:6841:5: (lv_arg1_3_0= RULE_ID )
                    {
                    // InternalSymboleo.g:6841:5: (lv_arg1_3_0= RULE_ID )
                    // InternalSymboleo.g:6842:6: lv_arg1_3_0= RULE_ID
                    {
                    lv_arg1_3_0=(Token)match(input,RULE_ID,FOLLOW_11); 

                    						newLeafNode(lv_arg1_3_0, grammarAccess.getOtherFunctionAccess().getArg1IDTerminalRuleCall_0_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOtherFunctionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"arg1",
                    							lv_arg1_3_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,18,FOLLOW_3); 

                    				newLeafNode(otherlv_4, grammarAccess.getOtherFunctionAccess().getCommaKeyword_0_4());
                    			
                    // InternalSymboleo.g:6862:4: ( (lv_arg2_5_0= RULE_ID ) )
                    // InternalSymboleo.g:6863:5: (lv_arg2_5_0= RULE_ID )
                    {
                    // InternalSymboleo.g:6863:5: (lv_arg2_5_0= RULE_ID )
                    // InternalSymboleo.g:6864:6: lv_arg2_5_0= RULE_ID
                    {
                    lv_arg2_5_0=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(lv_arg2_5_0, grammarAccess.getOtherFunctionAccess().getArg2IDTerminalRuleCall_0_5_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOtherFunctionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"arg2",
                    							lv_arg2_5_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    otherlv_6=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getOtherFunctionAccess().getRightParenthesisKeyword_0_6());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:6886:3: ( () ( (lv_name_8_0= 'IsOwner' ) ) otherlv_9= '(' ( (lv_arg1_10_0= RULE_ID ) ) otherlv_11= ',' ( (lv_arg2_12_0= RULE_ID ) ) otherlv_13= ')' )
                    {
                    // InternalSymboleo.g:6886:3: ( () ( (lv_name_8_0= 'IsOwner' ) ) otherlv_9= '(' ( (lv_arg1_10_0= RULE_ID ) ) otherlv_11= ',' ( (lv_arg2_12_0= RULE_ID ) ) otherlv_13= ')' )
                    // InternalSymboleo.g:6887:4: () ( (lv_name_8_0= 'IsOwner' ) ) otherlv_9= '(' ( (lv_arg1_10_0= RULE_ID ) ) otherlv_11= ',' ( (lv_arg2_12_0= RULE_ID ) ) otherlv_13= ')'
                    {
                    // InternalSymboleo.g:6887:4: ()
                    // InternalSymboleo.g:6888:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getOtherFunctionAccess().getPredicateFunctionIsOwnerAction_1_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:6894:4: ( (lv_name_8_0= 'IsOwner' ) )
                    // InternalSymboleo.g:6895:5: (lv_name_8_0= 'IsOwner' )
                    {
                    // InternalSymboleo.g:6895:5: (lv_name_8_0= 'IsOwner' )
                    // InternalSymboleo.g:6896:6: lv_name_8_0= 'IsOwner'
                    {
                    lv_name_8_0=(Token)match(input,118,FOLLOW_10); 

                    						newLeafNode(lv_name_8_0, grammarAccess.getOtherFunctionAccess().getNameIsOwnerKeyword_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOtherFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_8_0, "IsOwner");
                    					

                    }


                    }

                    otherlv_9=(Token)match(input,17,FOLLOW_3); 

                    				newLeafNode(otherlv_9, grammarAccess.getOtherFunctionAccess().getLeftParenthesisKeyword_1_2());
                    			
                    // InternalSymboleo.g:6912:4: ( (lv_arg1_10_0= RULE_ID ) )
                    // InternalSymboleo.g:6913:5: (lv_arg1_10_0= RULE_ID )
                    {
                    // InternalSymboleo.g:6913:5: (lv_arg1_10_0= RULE_ID )
                    // InternalSymboleo.g:6914:6: lv_arg1_10_0= RULE_ID
                    {
                    lv_arg1_10_0=(Token)match(input,RULE_ID,FOLLOW_11); 

                    						newLeafNode(lv_arg1_10_0, grammarAccess.getOtherFunctionAccess().getArg1IDTerminalRuleCall_1_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOtherFunctionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"arg1",
                    							lv_arg1_10_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,18,FOLLOW_3); 

                    				newLeafNode(otherlv_11, grammarAccess.getOtherFunctionAccess().getCommaKeyword_1_4());
                    			
                    // InternalSymboleo.g:6934:4: ( (lv_arg2_12_0= RULE_ID ) )
                    // InternalSymboleo.g:6935:5: (lv_arg2_12_0= RULE_ID )
                    {
                    // InternalSymboleo.g:6935:5: (lv_arg2_12_0= RULE_ID )
                    // InternalSymboleo.g:6936:6: lv_arg2_12_0= RULE_ID
                    {
                    lv_arg2_12_0=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(lv_arg2_12_0, grammarAccess.getOtherFunctionAccess().getArg2IDTerminalRuleCall_1_5_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOtherFunctionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"arg2",
                    							lv_arg2_12_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    otherlv_13=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_13, grammarAccess.getOtherFunctionAccess().getRightParenthesisKeyword_1_6());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:6958:3: ( () ( (lv_name_15_0= 'CannotBeAssigned' ) ) otherlv_16= '(' ( (lv_arg1_17_0= RULE_ID ) ) otherlv_18= ')' )
                    {
                    // InternalSymboleo.g:6958:3: ( () ( (lv_name_15_0= 'CannotBeAssigned' ) ) otherlv_16= '(' ( (lv_arg1_17_0= RULE_ID ) ) otherlv_18= ')' )
                    // InternalSymboleo.g:6959:4: () ( (lv_name_15_0= 'CannotBeAssigned' ) ) otherlv_16= '(' ( (lv_arg1_17_0= RULE_ID ) ) otherlv_18= ')'
                    {
                    // InternalSymboleo.g:6959:4: ()
                    // InternalSymboleo.g:6960:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getOtherFunctionAccess().getPredicateFunctionCannotBeAssignedAction_2_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:6966:4: ( (lv_name_15_0= 'CannotBeAssigned' ) )
                    // InternalSymboleo.g:6967:5: (lv_name_15_0= 'CannotBeAssigned' )
                    {
                    // InternalSymboleo.g:6967:5: (lv_name_15_0= 'CannotBeAssigned' )
                    // InternalSymboleo.g:6968:6: lv_name_15_0= 'CannotBeAssigned'
                    {
                    lv_name_15_0=(Token)match(input,119,FOLLOW_10); 

                    						newLeafNode(lv_name_15_0, grammarAccess.getOtherFunctionAccess().getNameCannotBeAssignedKeyword_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOtherFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_15_0, "CannotBeAssigned");
                    					

                    }


                    }

                    otherlv_16=(Token)match(input,17,FOLLOW_3); 

                    				newLeafNode(otherlv_16, grammarAccess.getOtherFunctionAccess().getLeftParenthesisKeyword_2_2());
                    			
                    // InternalSymboleo.g:6984:4: ( (lv_arg1_17_0= RULE_ID ) )
                    // InternalSymboleo.g:6985:5: (lv_arg1_17_0= RULE_ID )
                    {
                    // InternalSymboleo.g:6985:5: (lv_arg1_17_0= RULE_ID )
                    // InternalSymboleo.g:6986:6: lv_arg1_17_0= RULE_ID
                    {
                    lv_arg1_17_0=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(lv_arg1_17_0, grammarAccess.getOtherFunctionAccess().getArg1IDTerminalRuleCall_2_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOtherFunctionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"arg1",
                    							lv_arg1_17_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    otherlv_18=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_18, grammarAccess.getOtherFunctionAccess().getRightParenthesisKeyword_2_4());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOtherFunction"


    // $ANTLR start "entryRuleEvent"
    // InternalSymboleo.g:7011:1: entryRuleEvent returns [EObject current=null] : iv_ruleEvent= ruleEvent EOF ;
    public final EObject entryRuleEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvent = null;


        try {
            // InternalSymboleo.g:7011:46: (iv_ruleEvent= ruleEvent EOF )
            // InternalSymboleo.g:7012:2: iv_ruleEvent= ruleEvent EOF
            {
             newCompositeNode(grammarAccess.getEventRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEvent=ruleEvent();

            state._fsp--;

             current =iv_ruleEvent; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEvent"


    // $ANTLR start "ruleEvent"
    // InternalSymboleo.g:7018:1: ruleEvent returns [EObject current=null] : (this_VariableEvent_0= ruleVariableEvent | this_ObligationEvent_1= ruleObligationEvent | this_ContractEvent_2= ruleContractEvent | this_PowerEvent_3= rulePowerEvent | this_DataTransfer_4= ruleDataTransfer ) ;
    public final EObject ruleEvent() throws RecognitionException {
        EObject current = null;

        EObject this_VariableEvent_0 = null;

        EObject this_ObligationEvent_1 = null;

        EObject this_ContractEvent_2 = null;

        EObject this_PowerEvent_3 = null;

        EObject this_DataTransfer_4 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:7024:2: ( (this_VariableEvent_0= ruleVariableEvent | this_ObligationEvent_1= ruleObligationEvent | this_ContractEvent_2= ruleContractEvent | this_PowerEvent_3= rulePowerEvent | this_DataTransfer_4= ruleDataTransfer ) )
            // InternalSymboleo.g:7025:2: (this_VariableEvent_0= ruleVariableEvent | this_ObligationEvent_1= ruleObligationEvent | this_ContractEvent_2= ruleContractEvent | this_PowerEvent_3= rulePowerEvent | this_DataTransfer_4= ruleDataTransfer )
            {
            // InternalSymboleo.g:7025:2: (this_VariableEvent_0= ruleVariableEvent | this_ObligationEvent_1= ruleObligationEvent | this_ContractEvent_2= ruleContractEvent | this_PowerEvent_3= rulePowerEvent | this_DataTransfer_4= ruleDataTransfer )
            int alt91=5;
            alt91 = dfa91.predict(input);
            switch (alt91) {
                case 1 :
                    // InternalSymboleo.g:7026:3: this_VariableEvent_0= ruleVariableEvent
                    {

                    			newCompositeNode(grammarAccess.getEventAccess().getVariableEventParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_VariableEvent_0=ruleVariableEvent();

                    state._fsp--;


                    			current = this_VariableEvent_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:7035:3: this_ObligationEvent_1= ruleObligationEvent
                    {

                    			newCompositeNode(grammarAccess.getEventAccess().getObligationEventParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ObligationEvent_1=ruleObligationEvent();

                    state._fsp--;


                    			current = this_ObligationEvent_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:7044:3: this_ContractEvent_2= ruleContractEvent
                    {

                    			newCompositeNode(grammarAccess.getEventAccess().getContractEventParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_ContractEvent_2=ruleContractEvent();

                    state._fsp--;


                    			current = this_ContractEvent_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalSymboleo.g:7053:3: this_PowerEvent_3= rulePowerEvent
                    {

                    			newCompositeNode(grammarAccess.getEventAccess().getPowerEventParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_PowerEvent_3=rulePowerEvent();

                    state._fsp--;


                    			current = this_PowerEvent_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalSymboleo.g:7062:3: this_DataTransfer_4= ruleDataTransfer
                    {

                    			newCompositeNode(grammarAccess.getEventAccess().getDataTransferParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_DataTransfer_4=ruleDataTransfer();

                    state._fsp--;


                    			current = this_DataTransfer_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEvent"


    // $ANTLR start "entryRuleDataTransfer"
    // InternalSymboleo.g:7074:1: entryRuleDataTransfer returns [EObject current=null] : iv_ruleDataTransfer= ruleDataTransfer EOF ;
    public final EObject entryRuleDataTransfer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataTransfer = null;


        try {
            // InternalSymboleo.g:7074:53: (iv_ruleDataTransfer= ruleDataTransfer EOF )
            // InternalSymboleo.g:7075:2: iv_ruleDataTransfer= ruleDataTransfer EOF
            {
             newCompositeNode(grammarAccess.getDataTransferRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDataTransfer=ruleDataTransfer();

            state._fsp--;

             current =iv_ruleDataTransfer; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDataTransfer"


    // $ANTLR start "ruleDataTransfer"
    // InternalSymboleo.g:7081:1: ruleDataTransfer returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ( (lv_variable_2_0= ruleVariableDotExpression ) ) ) ;
    public final EObject ruleDataTransfer() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_variable_2_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:7087:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) ( (lv_variable_2_0= ruleVariableDotExpression ) ) ) )
            // InternalSymboleo.g:7088:2: ( () ( (lv_name_1_0= RULE_ID ) ) ( (lv_variable_2_0= ruleVariableDotExpression ) ) )
            {
            // InternalSymboleo.g:7088:2: ( () ( (lv_name_1_0= RULE_ID ) ) ( (lv_variable_2_0= ruleVariableDotExpression ) ) )
            // InternalSymboleo.g:7089:3: () ( (lv_name_1_0= RULE_ID ) ) ( (lv_variable_2_0= ruleVariableDotExpression ) )
            {
            // InternalSymboleo.g:7089:3: ()
            // InternalSymboleo.g:7090:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getDataTransferAccess().getDataTransferAction_0(),
            					current);
            			

            }

            // InternalSymboleo.g:7096:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSymboleo.g:7097:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSymboleo.g:7097:4: (lv_name_1_0= RULE_ID )
            // InternalSymboleo.g:7098:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_3); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDataTransferAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDataTransferRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalSymboleo.g:7114:3: ( (lv_variable_2_0= ruleVariableDotExpression ) )
            // InternalSymboleo.g:7115:4: (lv_variable_2_0= ruleVariableDotExpression )
            {
            // InternalSymboleo.g:7115:4: (lv_variable_2_0= ruleVariableDotExpression )
            // InternalSymboleo.g:7116:5: lv_variable_2_0= ruleVariableDotExpression
            {

            					newCompositeNode(grammarAccess.getDataTransferAccess().getVariableVariableDotExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_variable_2_0=ruleVariableDotExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDataTransferRule());
            					}
            					set(
            						current,
            						"variable",
            						lv_variable_2_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.VariableDotExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDataTransfer"


    // $ANTLR start "entryRuleVariableEvent"
    // InternalSymboleo.g:7137:1: entryRuleVariableEvent returns [EObject current=null] : iv_ruleVariableEvent= ruleVariableEvent EOF ;
    public final EObject entryRuleVariableEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableEvent = null;


        try {
            // InternalSymboleo.g:7137:54: (iv_ruleVariableEvent= ruleVariableEvent EOF )
            // InternalSymboleo.g:7138:2: iv_ruleVariableEvent= ruleVariableEvent EOF
            {
             newCompositeNode(grammarAccess.getVariableEventRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariableEvent=ruleVariableEvent();

            state._fsp--;

             current =iv_ruleVariableEvent; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariableEvent"


    // $ANTLR start "ruleVariableEvent"
    // InternalSymboleo.g:7144:1: ruleVariableEvent returns [EObject current=null] : ( () ( (lv_variable_1_0= ruleVariableDotExpression ) ) ) ;
    public final EObject ruleVariableEvent() throws RecognitionException {
        EObject current = null;

        EObject lv_variable_1_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:7150:2: ( ( () ( (lv_variable_1_0= ruleVariableDotExpression ) ) ) )
            // InternalSymboleo.g:7151:2: ( () ( (lv_variable_1_0= ruleVariableDotExpression ) ) )
            {
            // InternalSymboleo.g:7151:2: ( () ( (lv_variable_1_0= ruleVariableDotExpression ) ) )
            // InternalSymboleo.g:7152:3: () ( (lv_variable_1_0= ruleVariableDotExpression ) )
            {
            // InternalSymboleo.g:7152:3: ()
            // InternalSymboleo.g:7153:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getVariableEventAccess().getVariableEventAction_0(),
            					current);
            			

            }

            // InternalSymboleo.g:7159:3: ( (lv_variable_1_0= ruleVariableDotExpression ) )
            // InternalSymboleo.g:7160:4: (lv_variable_1_0= ruleVariableDotExpression )
            {
            // InternalSymboleo.g:7160:4: (lv_variable_1_0= ruleVariableDotExpression )
            // InternalSymboleo.g:7161:5: lv_variable_1_0= ruleVariableDotExpression
            {

            					newCompositeNode(grammarAccess.getVariableEventAccess().getVariableVariableDotExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_variable_1_0=ruleVariableDotExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getVariableEventRule());
            					}
            					set(
            						current,
            						"variable",
            						lv_variable_1_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.VariableDotExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariableEvent"


    // $ANTLR start "entryRulePowerEvent"
    // InternalSymboleo.g:7182:1: entryRulePowerEvent returns [EObject current=null] : iv_rulePowerEvent= rulePowerEvent EOF ;
    public final EObject entryRulePowerEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePowerEvent = null;


        try {
            // InternalSymboleo.g:7182:51: (iv_rulePowerEvent= rulePowerEvent EOF )
            // InternalSymboleo.g:7183:2: iv_rulePowerEvent= rulePowerEvent EOF
            {
             newCompositeNode(grammarAccess.getPowerEventRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePowerEvent=rulePowerEvent();

            state._fsp--;

             current =iv_rulePowerEvent; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePowerEvent"


    // $ANTLR start "rulePowerEvent"
    // InternalSymboleo.g:7189:1: rulePowerEvent returns [EObject current=null] : ( () ( (lv_eventName_1_0= rulePowerEventName ) ) otherlv_2= '(' otherlv_3= 'powers.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' ) ;
    public final EObject rulePowerEvent() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_eventName_1_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:7195:2: ( ( () ( (lv_eventName_1_0= rulePowerEventName ) ) otherlv_2= '(' otherlv_3= 'powers.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' ) )
            // InternalSymboleo.g:7196:2: ( () ( (lv_eventName_1_0= rulePowerEventName ) ) otherlv_2= '(' otherlv_3= 'powers.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' )
            {
            // InternalSymboleo.g:7196:2: ( () ( (lv_eventName_1_0= rulePowerEventName ) ) otherlv_2= '(' otherlv_3= 'powers.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' )
            // InternalSymboleo.g:7197:3: () ( (lv_eventName_1_0= rulePowerEventName ) ) otherlv_2= '(' otherlv_3= 'powers.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')'
            {
            // InternalSymboleo.g:7197:3: ()
            // InternalSymboleo.g:7198:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPowerEventAccess().getPowerEventAction_0(),
            					current);
            			

            }

            // InternalSymboleo.g:7204:3: ( (lv_eventName_1_0= rulePowerEventName ) )
            // InternalSymboleo.g:7205:4: (lv_eventName_1_0= rulePowerEventName )
            {
            // InternalSymboleo.g:7205:4: (lv_eventName_1_0= rulePowerEventName )
            // InternalSymboleo.g:7206:5: lv_eventName_1_0= rulePowerEventName
            {

            					newCompositeNode(grammarAccess.getPowerEventAccess().getEventNamePowerEventNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_10);
            lv_eventName_1_0=rulePowerEventName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPowerEventRule());
            					}
            					set(
            						current,
            						"eventName",
            						lv_eventName_1_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.PowerEventName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_74); 

            			newLeafNode(otherlv_2, grammarAccess.getPowerEventAccess().getLeftParenthesisKeyword_2());
            		
            otherlv_3=(Token)match(input,52,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getPowerEventAccess().getPowersKeyword_3());
            		
            // InternalSymboleo.g:7231:3: ( (otherlv_4= RULE_ID ) )
            // InternalSymboleo.g:7232:4: (otherlv_4= RULE_ID )
            {
            // InternalSymboleo.g:7232:4: (otherlv_4= RULE_ID )
            // InternalSymboleo.g:7233:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPowerEventRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_12); 

            					newLeafNode(otherlv_4, grammarAccess.getPowerEventAccess().getPowerVariablePowerCrossReference_4_0());
            				

            }


            }

            otherlv_5=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getPowerEventAccess().getRightParenthesisKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePowerEvent"


    // $ANTLR start "entryRulePowerEventName"
    // InternalSymboleo.g:7252:1: entryRulePowerEventName returns [String current=null] : iv_rulePowerEventName= rulePowerEventName EOF ;
    public final String entryRulePowerEventName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePowerEventName = null;


        try {
            // InternalSymboleo.g:7252:54: (iv_rulePowerEventName= rulePowerEventName EOF )
            // InternalSymboleo.g:7253:2: iv_rulePowerEventName= rulePowerEventName EOF
            {
             newCompositeNode(grammarAccess.getPowerEventNameRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePowerEventName=rulePowerEventName();

            state._fsp--;

             current =iv_rulePowerEventName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePowerEventName"


    // $ANTLR start "rulePowerEventName"
    // InternalSymboleo.g:7259:1: rulePowerEventName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Triggered' | kw= 'Activated' | kw= 'Suspended' | kw= 'Resumed' | kw= 'Exerted' | kw= 'Expired' | kw= 'Terminated' ) ;
    public final AntlrDatatypeRuleToken rulePowerEventName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSymboleo.g:7265:2: ( (kw= 'Triggered' | kw= 'Activated' | kw= 'Suspended' | kw= 'Resumed' | kw= 'Exerted' | kw= 'Expired' | kw= 'Terminated' ) )
            // InternalSymboleo.g:7266:2: (kw= 'Triggered' | kw= 'Activated' | kw= 'Suspended' | kw= 'Resumed' | kw= 'Exerted' | kw= 'Expired' | kw= 'Terminated' )
            {
            // InternalSymboleo.g:7266:2: (kw= 'Triggered' | kw= 'Activated' | kw= 'Suspended' | kw= 'Resumed' | kw= 'Exerted' | kw= 'Expired' | kw= 'Terminated' )
            int alt92=7;
            switch ( input.LA(1) ) {
            case 105:
                {
                alt92=1;
                }
                break;
            case 120:
                {
                alt92=2;
                }
                break;
            case 101:
                {
                alt92=3;
                }
                break;
            case 102:
                {
                alt92=4;
                }
                break;
            case 121:
                {
                alt92=5;
                }
                break;
            case 122:
                {
                alt92=6;
                }
                break;
            case 104:
                {
                alt92=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 92, 0, input);

                throw nvae;
            }

            switch (alt92) {
                case 1 :
                    // InternalSymboleo.g:7267:3: kw= 'Triggered'
                    {
                    kw=(Token)match(input,105,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowerEventNameAccess().getTriggeredKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:7273:3: kw= 'Activated'
                    {
                    kw=(Token)match(input,120,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowerEventNameAccess().getActivatedKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:7279:3: kw= 'Suspended'
                    {
                    kw=(Token)match(input,101,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowerEventNameAccess().getSuspendedKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalSymboleo.g:7285:3: kw= 'Resumed'
                    {
                    kw=(Token)match(input,102,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowerEventNameAccess().getResumedKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalSymboleo.g:7291:3: kw= 'Exerted'
                    {
                    kw=(Token)match(input,121,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowerEventNameAccess().getExertedKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalSymboleo.g:7297:3: kw= 'Expired'
                    {
                    kw=(Token)match(input,122,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowerEventNameAccess().getExpiredKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalSymboleo.g:7303:3: kw= 'Terminated'
                    {
                    kw=(Token)match(input,104,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowerEventNameAccess().getTerminatedKeyword_6());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePowerEventName"


    // $ANTLR start "entryRuleObligationEvent"
    // InternalSymboleo.g:7312:1: entryRuleObligationEvent returns [EObject current=null] : iv_ruleObligationEvent= ruleObligationEvent EOF ;
    public final EObject entryRuleObligationEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObligationEvent = null;


        try {
            // InternalSymboleo.g:7312:56: (iv_ruleObligationEvent= ruleObligationEvent EOF )
            // InternalSymboleo.g:7313:2: iv_ruleObligationEvent= ruleObligationEvent EOF
            {
             newCompositeNode(grammarAccess.getObligationEventRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleObligationEvent=ruleObligationEvent();

            state._fsp--;

             current =iv_ruleObligationEvent; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleObligationEvent"


    // $ANTLR start "ruleObligationEvent"
    // InternalSymboleo.g:7319:1: ruleObligationEvent returns [EObject current=null] : ( () ( (lv_eventName_1_0= ruleObligationEventName ) ) otherlv_2= '(' otherlv_3= 'obligations.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' ) ;
    public final EObject ruleObligationEvent() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_eventName_1_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:7325:2: ( ( () ( (lv_eventName_1_0= ruleObligationEventName ) ) otherlv_2= '(' otherlv_3= 'obligations.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' ) )
            // InternalSymboleo.g:7326:2: ( () ( (lv_eventName_1_0= ruleObligationEventName ) ) otherlv_2= '(' otherlv_3= 'obligations.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' )
            {
            // InternalSymboleo.g:7326:2: ( () ( (lv_eventName_1_0= ruleObligationEventName ) ) otherlv_2= '(' otherlv_3= 'obligations.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' )
            // InternalSymboleo.g:7327:3: () ( (lv_eventName_1_0= ruleObligationEventName ) ) otherlv_2= '(' otherlv_3= 'obligations.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')'
            {
            // InternalSymboleo.g:7327:3: ()
            // InternalSymboleo.g:7328:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getObligationEventAccess().getObligationEventAction_0(),
            					current);
            			

            }

            // InternalSymboleo.g:7334:3: ( (lv_eventName_1_0= ruleObligationEventName ) )
            // InternalSymboleo.g:7335:4: (lv_eventName_1_0= ruleObligationEventName )
            {
            // InternalSymboleo.g:7335:4: (lv_eventName_1_0= ruleObligationEventName )
            // InternalSymboleo.g:7336:5: lv_eventName_1_0= ruleObligationEventName
            {

            					newCompositeNode(grammarAccess.getObligationEventAccess().getEventNameObligationEventNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_10);
            lv_eventName_1_0=ruleObligationEventName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getObligationEventRule());
            					}
            					set(
            						current,
            						"eventName",
            						lv_eventName_1_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.ObligationEventName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_67); 

            			newLeafNode(otherlv_2, grammarAccess.getObligationEventAccess().getLeftParenthesisKeyword_2());
            		
            otherlv_3=(Token)match(input,51,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getObligationEventAccess().getObligationsKeyword_3());
            		
            // InternalSymboleo.g:7361:3: ( (otherlv_4= RULE_ID ) )
            // InternalSymboleo.g:7362:4: (otherlv_4= RULE_ID )
            {
            // InternalSymboleo.g:7362:4: (otherlv_4= RULE_ID )
            // InternalSymboleo.g:7363:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getObligationEventRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_12); 

            					newLeafNode(otherlv_4, grammarAccess.getObligationEventAccess().getObligationVariableObligationCrossReference_4_0());
            				

            }


            }

            otherlv_5=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getObligationEventAccess().getRightParenthesisKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleObligationEvent"


    // $ANTLR start "entryRuleObligationEventName"
    // InternalSymboleo.g:7382:1: entryRuleObligationEventName returns [String current=null] : iv_ruleObligationEventName= ruleObligationEventName EOF ;
    public final String entryRuleObligationEventName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleObligationEventName = null;


        try {
            // InternalSymboleo.g:7382:59: (iv_ruleObligationEventName= ruleObligationEventName EOF )
            // InternalSymboleo.g:7383:2: iv_ruleObligationEventName= ruleObligationEventName EOF
            {
             newCompositeNode(grammarAccess.getObligationEventNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleObligationEventName=ruleObligationEventName();

            state._fsp--;

             current =iv_ruleObligationEventName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleObligationEventName"


    // $ANTLR start "ruleObligationEventName"
    // InternalSymboleo.g:7389:1: ruleObligationEventName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Triggered' | kw= 'Activated' | kw= 'Suspended' | kw= 'Resumed' | kw= 'Discharged' | kw= 'Expired' | kw= 'Fulfilled' | kw= 'Violated' | kw= 'Terminated' ) ;
    public final AntlrDatatypeRuleToken ruleObligationEventName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSymboleo.g:7395:2: ( (kw= 'Triggered' | kw= 'Activated' | kw= 'Suspended' | kw= 'Resumed' | kw= 'Discharged' | kw= 'Expired' | kw= 'Fulfilled' | kw= 'Violated' | kw= 'Terminated' ) )
            // InternalSymboleo.g:7396:2: (kw= 'Triggered' | kw= 'Activated' | kw= 'Suspended' | kw= 'Resumed' | kw= 'Discharged' | kw= 'Expired' | kw= 'Fulfilled' | kw= 'Violated' | kw= 'Terminated' )
            {
            // InternalSymboleo.g:7396:2: (kw= 'Triggered' | kw= 'Activated' | kw= 'Suspended' | kw= 'Resumed' | kw= 'Discharged' | kw= 'Expired' | kw= 'Fulfilled' | kw= 'Violated' | kw= 'Terminated' )
            int alt93=9;
            switch ( input.LA(1) ) {
            case 105:
                {
                alt93=1;
                }
                break;
            case 120:
                {
                alt93=2;
                }
                break;
            case 101:
                {
                alt93=3;
                }
                break;
            case 102:
                {
                alt93=4;
                }
                break;
            case 103:
                {
                alt93=5;
                }
                break;
            case 122:
                {
                alt93=6;
                }
                break;
            case 123:
                {
                alt93=7;
                }
                break;
            case 124:
                {
                alt93=8;
                }
                break;
            case 104:
                {
                alt93=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 93, 0, input);

                throw nvae;
            }

            switch (alt93) {
                case 1 :
                    // InternalSymboleo.g:7397:3: kw= 'Triggered'
                    {
                    kw=(Token)match(input,105,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationEventNameAccess().getTriggeredKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:7403:3: kw= 'Activated'
                    {
                    kw=(Token)match(input,120,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationEventNameAccess().getActivatedKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:7409:3: kw= 'Suspended'
                    {
                    kw=(Token)match(input,101,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationEventNameAccess().getSuspendedKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalSymboleo.g:7415:3: kw= 'Resumed'
                    {
                    kw=(Token)match(input,102,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationEventNameAccess().getResumedKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalSymboleo.g:7421:3: kw= 'Discharged'
                    {
                    kw=(Token)match(input,103,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationEventNameAccess().getDischargedKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalSymboleo.g:7427:3: kw= 'Expired'
                    {
                    kw=(Token)match(input,122,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationEventNameAccess().getExpiredKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalSymboleo.g:7433:3: kw= 'Fulfilled'
                    {
                    kw=(Token)match(input,123,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationEventNameAccess().getFulfilledKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalSymboleo.g:7439:3: kw= 'Violated'
                    {
                    kw=(Token)match(input,124,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationEventNameAccess().getViolatedKeyword_7());
                    		

                    }
                    break;
                case 9 :
                    // InternalSymboleo.g:7445:3: kw= 'Terminated'
                    {
                    kw=(Token)match(input,104,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationEventNameAccess().getTerminatedKeyword_8());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleObligationEventName"


    // $ANTLR start "entryRuleContractEvent"
    // InternalSymboleo.g:7454:1: entryRuleContractEvent returns [EObject current=null] : iv_ruleContractEvent= ruleContractEvent EOF ;
    public final EObject entryRuleContractEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContractEvent = null;


        try {
            // InternalSymboleo.g:7454:54: (iv_ruleContractEvent= ruleContractEvent EOF )
            // InternalSymboleo.g:7455:2: iv_ruleContractEvent= ruleContractEvent EOF
            {
             newCompositeNode(grammarAccess.getContractEventRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContractEvent=ruleContractEvent();

            state._fsp--;

             current =iv_ruleContractEvent; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContractEvent"


    // $ANTLR start "ruleContractEvent"
    // InternalSymboleo.g:7461:1: ruleContractEvent returns [EObject current=null] : ( () ( (lv_eventName_1_0= ruleContractEventName ) ) otherlv_2= '(' otherlv_3= 'self' otherlv_4= ')' ) ;
    public final EObject ruleContractEvent() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_eventName_1_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:7467:2: ( ( () ( (lv_eventName_1_0= ruleContractEventName ) ) otherlv_2= '(' otherlv_3= 'self' otherlv_4= ')' ) )
            // InternalSymboleo.g:7468:2: ( () ( (lv_eventName_1_0= ruleContractEventName ) ) otherlv_2= '(' otherlv_3= 'self' otherlv_4= ')' )
            {
            // InternalSymboleo.g:7468:2: ( () ( (lv_eventName_1_0= ruleContractEventName ) ) otherlv_2= '(' otherlv_3= 'self' otherlv_4= ')' )
            // InternalSymboleo.g:7469:3: () ( (lv_eventName_1_0= ruleContractEventName ) ) otherlv_2= '(' otherlv_3= 'self' otherlv_4= ')'
            {
            // InternalSymboleo.g:7469:3: ()
            // InternalSymboleo.g:7470:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getContractEventAccess().getContractEventAction_0(),
            					current);
            			

            }

            // InternalSymboleo.g:7476:3: ( (lv_eventName_1_0= ruleContractEventName ) )
            // InternalSymboleo.g:7477:4: (lv_eventName_1_0= ruleContractEventName )
            {
            // InternalSymboleo.g:7477:4: (lv_eventName_1_0= ruleContractEventName )
            // InternalSymboleo.g:7478:5: lv_eventName_1_0= ruleContractEventName
            {

            					newCompositeNode(grammarAccess.getContractEventAccess().getEventNameContractEventNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_10);
            lv_eventName_1_0=ruleContractEventName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getContractEventRule());
            					}
            					set(
            						current,
            						"eventName",
            						lv_eventName_1_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.ContractEventName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_68); 

            			newLeafNode(otherlv_2, grammarAccess.getContractEventAccess().getLeftParenthesisKeyword_2());
            		
            otherlv_3=(Token)match(input,106,FOLLOW_12); 

            			newLeafNode(otherlv_3, grammarAccess.getContractEventAccess().getSelfKeyword_3());
            		
            otherlv_4=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getContractEventAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContractEvent"


    // $ANTLR start "entryRuleContractEventName"
    // InternalSymboleo.g:7511:1: entryRuleContractEventName returns [String current=null] : iv_ruleContractEventName= ruleContractEventName EOF ;
    public final String entryRuleContractEventName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleContractEventName = null;


        try {
            // InternalSymboleo.g:7511:57: (iv_ruleContractEventName= ruleContractEventName EOF )
            // InternalSymboleo.g:7512:2: iv_ruleContractEventName= ruleContractEventName EOF
            {
             newCompositeNode(grammarAccess.getContractEventNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContractEventName=ruleContractEventName();

            state._fsp--;

             current =iv_ruleContractEventName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContractEventName"


    // $ANTLR start "ruleContractEventName"
    // InternalSymboleo.g:7518:1: ruleContractEventName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Activated' | kw= 'Suspended' | kw= 'Resumed' | kw= 'FulfilledObligations' | kw= 'RevokedParty' | kw= 'AssignedParty' | kw= 'Terminated' | kw= 'Rescinded' ) ;
    public final AntlrDatatypeRuleToken ruleContractEventName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSymboleo.g:7524:2: ( (kw= 'Activated' | kw= 'Suspended' | kw= 'Resumed' | kw= 'FulfilledObligations' | kw= 'RevokedParty' | kw= 'AssignedParty' | kw= 'Terminated' | kw= 'Rescinded' ) )
            // InternalSymboleo.g:7525:2: (kw= 'Activated' | kw= 'Suspended' | kw= 'Resumed' | kw= 'FulfilledObligations' | kw= 'RevokedParty' | kw= 'AssignedParty' | kw= 'Terminated' | kw= 'Rescinded' )
            {
            // InternalSymboleo.g:7525:2: (kw= 'Activated' | kw= 'Suspended' | kw= 'Resumed' | kw= 'FulfilledObligations' | kw= 'RevokedParty' | kw= 'AssignedParty' | kw= 'Terminated' | kw= 'Rescinded' )
            int alt94=8;
            switch ( input.LA(1) ) {
            case 120:
                {
                alt94=1;
                }
                break;
            case 101:
                {
                alt94=2;
                }
                break;
            case 102:
                {
                alt94=3;
                }
                break;
            case 125:
                {
                alt94=4;
                }
                break;
            case 126:
                {
                alt94=5;
                }
                break;
            case 127:
                {
                alt94=6;
                }
                break;
            case 104:
                {
                alt94=7;
                }
                break;
            case 128:
                {
                alt94=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 94, 0, input);

                throw nvae;
            }

            switch (alt94) {
                case 1 :
                    // InternalSymboleo.g:7526:3: kw= 'Activated'
                    {
                    kw=(Token)match(input,120,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractEventNameAccess().getActivatedKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:7532:3: kw= 'Suspended'
                    {
                    kw=(Token)match(input,101,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractEventNameAccess().getSuspendedKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:7538:3: kw= 'Resumed'
                    {
                    kw=(Token)match(input,102,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractEventNameAccess().getResumedKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalSymboleo.g:7544:3: kw= 'FulfilledObligations'
                    {
                    kw=(Token)match(input,125,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractEventNameAccess().getFulfilledObligationsKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalSymboleo.g:7550:3: kw= 'RevokedParty'
                    {
                    kw=(Token)match(input,126,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractEventNameAccess().getRevokedPartyKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalSymboleo.g:7556:3: kw= 'AssignedParty'
                    {
                    kw=(Token)match(input,127,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractEventNameAccess().getAssignedPartyKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalSymboleo.g:7562:3: kw= 'Terminated'
                    {
                    kw=(Token)match(input,104,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractEventNameAccess().getTerminatedKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalSymboleo.g:7568:3: kw= 'Rescinded'
                    {
                    kw=(Token)match(input,128,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractEventNameAccess().getRescindedKeyword_7());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContractEventName"


    // $ANTLR start "entryRulePoint"
    // InternalSymboleo.g:7577:1: entryRulePoint returns [EObject current=null] : iv_rulePoint= rulePoint EOF ;
    public final EObject entryRulePoint() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePoint = null;


        try {
            // InternalSymboleo.g:7577:46: (iv_rulePoint= rulePoint EOF )
            // InternalSymboleo.g:7578:2: iv_rulePoint= rulePoint EOF
            {
             newCompositeNode(grammarAccess.getPointRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePoint=rulePoint();

            state._fsp--;

             current =iv_rulePoint; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePoint"


    // $ANTLR start "rulePoint"
    // InternalSymboleo.g:7584:1: rulePoint returns [EObject current=null] : ( (lv_pointExpression_0_0= rulePointExpression ) ) ;
    public final EObject rulePoint() throws RecognitionException {
        EObject current = null;

        EObject lv_pointExpression_0_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:7590:2: ( ( (lv_pointExpression_0_0= rulePointExpression ) ) )
            // InternalSymboleo.g:7591:2: ( (lv_pointExpression_0_0= rulePointExpression ) )
            {
            // InternalSymboleo.g:7591:2: ( (lv_pointExpression_0_0= rulePointExpression ) )
            // InternalSymboleo.g:7592:3: (lv_pointExpression_0_0= rulePointExpression )
            {
            // InternalSymboleo.g:7592:3: (lv_pointExpression_0_0= rulePointExpression )
            // InternalSymboleo.g:7593:4: lv_pointExpression_0_0= rulePointExpression
            {

            				newCompositeNode(grammarAccess.getPointAccess().getPointExpressionPointExpressionParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_pointExpression_0_0=rulePointExpression();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getPointRule());
            				}
            				set(
            					current,
            					"pointExpression",
            					lv_pointExpression_0_0,
            					"ca.uottawa.csmlab.symboleo.Symboleo.PointExpression");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePoint"


    // $ANTLR start "entryRulePointExpression"
    // InternalSymboleo.g:7613:1: entryRulePointExpression returns [EObject current=null] : iv_rulePointExpression= rulePointExpression EOF ;
    public final EObject entryRulePointExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePointExpression = null;


        try {
            // InternalSymboleo.g:7613:56: (iv_rulePointExpression= rulePointExpression EOF )
            // InternalSymboleo.g:7614:2: iv_rulePointExpression= rulePointExpression EOF
            {
             newCompositeNode(grammarAccess.getPointExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePointExpression=rulePointExpression();

            state._fsp--;

             current =iv_rulePointExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePointExpression"


    // $ANTLR start "rulePointExpression"
    // InternalSymboleo.g:7620:1: rulePointExpression returns [EObject current=null] : (this_PointFunction_0= rulePointFunction | this_PointAtom_1= rulePointAtom ) ;
    public final EObject rulePointExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PointFunction_0 = null;

        EObject this_PointAtom_1 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:7626:2: ( (this_PointFunction_0= rulePointFunction | this_PointAtom_1= rulePointAtom ) )
            // InternalSymboleo.g:7627:2: (this_PointFunction_0= rulePointFunction | this_PointAtom_1= rulePointAtom )
            {
            // InternalSymboleo.g:7627:2: (this_PointFunction_0= rulePointFunction | this_PointAtom_1= rulePointAtom )
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==95) ) {
                alt95=1;
            }
            else if ( (LA95_0==RULE_ID||(LA95_0>=101 && LA95_0<=105)||(LA95_0>=120 && LA95_0<=128)) ) {
                alt95=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 95, 0, input);

                throw nvae;
            }
            switch (alt95) {
                case 1 :
                    // InternalSymboleo.g:7628:3: this_PointFunction_0= rulePointFunction
                    {

                    			newCompositeNode(grammarAccess.getPointExpressionAccess().getPointFunctionParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_PointFunction_0=rulePointFunction();

                    state._fsp--;


                    			current = this_PointFunction_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:7637:3: this_PointAtom_1= rulePointAtom
                    {

                    			newCompositeNode(grammarAccess.getPointExpressionAccess().getPointAtomParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_PointAtom_1=rulePointAtom();

                    state._fsp--;


                    			current = this_PointAtom_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePointExpression"


    // $ANTLR start "entryRulePointFunction"
    // InternalSymboleo.g:7649:1: entryRulePointFunction returns [EObject current=null] : iv_rulePointFunction= rulePointFunction EOF ;
    public final EObject entryRulePointFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePointFunction = null;


        try {
            // InternalSymboleo.g:7649:54: (iv_rulePointFunction= rulePointFunction EOF )
            // InternalSymboleo.g:7650:2: iv_rulePointFunction= rulePointFunction EOF
            {
             newCompositeNode(grammarAccess.getPointFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePointFunction=rulePointFunction();

            state._fsp--;

             current =iv_rulePointFunction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePointFunction"


    // $ANTLR start "rulePointFunction"
    // InternalSymboleo.g:7656:1: rulePointFunction returns [EObject current=null] : ( () ( (lv_name_1_0= rulePointFunctionName ) ) otherlv_2= '(' ( (lv_arg_3_0= rulePointExpression ) ) otherlv_4= ',' ( (lv_value_5_0= ruleTimevalue ) ) otherlv_6= ',' ( (lv_timeUnit_7_0= ruleTimeUnit ) ) otherlv_8= ')' ) ;
    public final EObject rulePointFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_arg_3_0 = null;

        EObject lv_value_5_0 = null;

        AntlrDatatypeRuleToken lv_timeUnit_7_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:7662:2: ( ( () ( (lv_name_1_0= rulePointFunctionName ) ) otherlv_2= '(' ( (lv_arg_3_0= rulePointExpression ) ) otherlv_4= ',' ( (lv_value_5_0= ruleTimevalue ) ) otherlv_6= ',' ( (lv_timeUnit_7_0= ruleTimeUnit ) ) otherlv_8= ')' ) )
            // InternalSymboleo.g:7663:2: ( () ( (lv_name_1_0= rulePointFunctionName ) ) otherlv_2= '(' ( (lv_arg_3_0= rulePointExpression ) ) otherlv_4= ',' ( (lv_value_5_0= ruleTimevalue ) ) otherlv_6= ',' ( (lv_timeUnit_7_0= ruleTimeUnit ) ) otherlv_8= ')' )
            {
            // InternalSymboleo.g:7663:2: ( () ( (lv_name_1_0= rulePointFunctionName ) ) otherlv_2= '(' ( (lv_arg_3_0= rulePointExpression ) ) otherlv_4= ',' ( (lv_value_5_0= ruleTimevalue ) ) otherlv_6= ',' ( (lv_timeUnit_7_0= ruleTimeUnit ) ) otherlv_8= ')' )
            // InternalSymboleo.g:7664:3: () ( (lv_name_1_0= rulePointFunctionName ) ) otherlv_2= '(' ( (lv_arg_3_0= rulePointExpression ) ) otherlv_4= ',' ( (lv_value_5_0= ruleTimevalue ) ) otherlv_6= ',' ( (lv_timeUnit_7_0= ruleTimeUnit ) ) otherlv_8= ')'
            {
            // InternalSymboleo.g:7664:3: ()
            // InternalSymboleo.g:7665:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPointFunctionAccess().getPointFunctionAction_0(),
            					current);
            			

            }

            // InternalSymboleo.g:7671:3: ( (lv_name_1_0= rulePointFunctionName ) )
            // InternalSymboleo.g:7672:4: (lv_name_1_0= rulePointFunctionName )
            {
            // InternalSymboleo.g:7672:4: (lv_name_1_0= rulePointFunctionName )
            // InternalSymboleo.g:7673:5: lv_name_1_0= rulePointFunctionName
            {

            					newCompositeNode(grammarAccess.getPointFunctionAccess().getNamePointFunctionNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_10);
            lv_name_1_0=rulePointFunctionName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPointFunctionRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.PointFunctionName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_71); 

            			newLeafNode(otherlv_2, grammarAccess.getPointFunctionAccess().getLeftParenthesisKeyword_2());
            		
            // InternalSymboleo.g:7694:3: ( (lv_arg_3_0= rulePointExpression ) )
            // InternalSymboleo.g:7695:4: (lv_arg_3_0= rulePointExpression )
            {
            // InternalSymboleo.g:7695:4: (lv_arg_3_0= rulePointExpression )
            // InternalSymboleo.g:7696:5: lv_arg_3_0= rulePointExpression
            {

            					newCompositeNode(grammarAccess.getPointFunctionAccess().getArgPointExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_11);
            lv_arg_3_0=rulePointExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPointFunctionRule());
            					}
            					set(
            						current,
            						"arg",
            						lv_arg_3_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.PointExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,18,FOLLOW_75); 

            			newLeafNode(otherlv_4, grammarAccess.getPointFunctionAccess().getCommaKeyword_4());
            		
            // InternalSymboleo.g:7717:3: ( (lv_value_5_0= ruleTimevalue ) )
            // InternalSymboleo.g:7718:4: (lv_value_5_0= ruleTimevalue )
            {
            // InternalSymboleo.g:7718:4: (lv_value_5_0= ruleTimevalue )
            // InternalSymboleo.g:7719:5: lv_value_5_0= ruleTimevalue
            {

            					newCompositeNode(grammarAccess.getPointFunctionAccess().getValueTimevalueParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_11);
            lv_value_5_0=ruleTimevalue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPointFunctionRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_5_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.Timevalue");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,18,FOLLOW_8); 

            			newLeafNode(otherlv_6, grammarAccess.getPointFunctionAccess().getCommaKeyword_6());
            		
            // InternalSymboleo.g:7740:3: ( (lv_timeUnit_7_0= ruleTimeUnit ) )
            // InternalSymboleo.g:7741:4: (lv_timeUnit_7_0= ruleTimeUnit )
            {
            // InternalSymboleo.g:7741:4: (lv_timeUnit_7_0= ruleTimeUnit )
            // InternalSymboleo.g:7742:5: lv_timeUnit_7_0= ruleTimeUnit
            {

            					newCompositeNode(grammarAccess.getPointFunctionAccess().getTimeUnitTimeUnitParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_12);
            lv_timeUnit_7_0=ruleTimeUnit();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPointFunctionRule());
            					}
            					set(
            						current,
            						"timeUnit",
            						lv_timeUnit_7_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.TimeUnit");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getPointFunctionAccess().getRightParenthesisKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePointFunction"


    // $ANTLR start "entryRulePointFunctionName"
    // InternalSymboleo.g:7767:1: entryRulePointFunctionName returns [String current=null] : iv_rulePointFunctionName= rulePointFunctionName EOF ;
    public final String entryRulePointFunctionName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePointFunctionName = null;


        try {
            // InternalSymboleo.g:7767:57: (iv_rulePointFunctionName= rulePointFunctionName EOF )
            // InternalSymboleo.g:7768:2: iv_rulePointFunctionName= rulePointFunctionName EOF
            {
             newCompositeNode(grammarAccess.getPointFunctionNameRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePointFunctionName=rulePointFunctionName();

            state._fsp--;

             current =iv_rulePointFunctionName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePointFunctionName"


    // $ANTLR start "rulePointFunctionName"
    // InternalSymboleo.g:7774:1: rulePointFunctionName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'Date.add' ;
    public final AntlrDatatypeRuleToken rulePointFunctionName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSymboleo.g:7780:2: (kw= 'Date.add' )
            // InternalSymboleo.g:7781:2: kw= 'Date.add'
            {
            kw=(Token)match(input,95,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getPointFunctionNameAccess().getDateAddKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePointFunctionName"


    // $ANTLR start "entryRulePointAtom"
    // InternalSymboleo.g:7789:1: entryRulePointAtom returns [EObject current=null] : iv_rulePointAtom= rulePointAtom EOF ;
    public final EObject entryRulePointAtom() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePointAtom = null;


        try {
            // InternalSymboleo.g:7789:50: (iv_rulePointAtom= rulePointAtom EOF )
            // InternalSymboleo.g:7790:2: iv_rulePointAtom= rulePointAtom EOF
            {
             newCompositeNode(grammarAccess.getPointAtomRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePointAtom=rulePointAtom();

            state._fsp--;

             current =iv_rulePointAtom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePointAtom"


    // $ANTLR start "rulePointAtom"
    // InternalSymboleo.g:7796:1: rulePointAtom returns [EObject current=null] : ( ( () ( (lv_variable_1_0= ruleVariableDotExpression ) ) ) | ( () ( (lv_obligationEvent_3_0= ruleObligationEvent ) ) ) | ( () ( (lv_contractEvent_5_0= ruleContractEvent ) ) ) | ( () ( (lv_powerEvent_7_0= rulePowerEvent ) ) ) ) ;
    public final EObject rulePointAtom() throws RecognitionException {
        EObject current = null;

        EObject lv_variable_1_0 = null;

        EObject lv_obligationEvent_3_0 = null;

        EObject lv_contractEvent_5_0 = null;

        EObject lv_powerEvent_7_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:7802:2: ( ( ( () ( (lv_variable_1_0= ruleVariableDotExpression ) ) ) | ( () ( (lv_obligationEvent_3_0= ruleObligationEvent ) ) ) | ( () ( (lv_contractEvent_5_0= ruleContractEvent ) ) ) | ( () ( (lv_powerEvent_7_0= rulePowerEvent ) ) ) ) )
            // InternalSymboleo.g:7803:2: ( ( () ( (lv_variable_1_0= ruleVariableDotExpression ) ) ) | ( () ( (lv_obligationEvent_3_0= ruleObligationEvent ) ) ) | ( () ( (lv_contractEvent_5_0= ruleContractEvent ) ) ) | ( () ( (lv_powerEvent_7_0= rulePowerEvent ) ) ) )
            {
            // InternalSymboleo.g:7803:2: ( ( () ( (lv_variable_1_0= ruleVariableDotExpression ) ) ) | ( () ( (lv_obligationEvent_3_0= ruleObligationEvent ) ) ) | ( () ( (lv_contractEvent_5_0= ruleContractEvent ) ) ) | ( () ( (lv_powerEvent_7_0= rulePowerEvent ) ) ) )
            int alt96=4;
            alt96 = dfa96.predict(input);
            switch (alt96) {
                case 1 :
                    // InternalSymboleo.g:7804:3: ( () ( (lv_variable_1_0= ruleVariableDotExpression ) ) )
                    {
                    // InternalSymboleo.g:7804:3: ( () ( (lv_variable_1_0= ruleVariableDotExpression ) ) )
                    // InternalSymboleo.g:7805:4: () ( (lv_variable_1_0= ruleVariableDotExpression ) )
                    {
                    // InternalSymboleo.g:7805:4: ()
                    // InternalSymboleo.g:7806:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPointAtomAccess().getPointAtomParameterDotExpressionAction_0_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:7812:4: ( (lv_variable_1_0= ruleVariableDotExpression ) )
                    // InternalSymboleo.g:7813:5: (lv_variable_1_0= ruleVariableDotExpression )
                    {
                    // InternalSymboleo.g:7813:5: (lv_variable_1_0= ruleVariableDotExpression )
                    // InternalSymboleo.g:7814:6: lv_variable_1_0= ruleVariableDotExpression
                    {

                    						newCompositeNode(grammarAccess.getPointAtomAccess().getVariableVariableDotExpressionParserRuleCall_0_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_variable_1_0=ruleVariableDotExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPointAtomRule());
                    						}
                    						set(
                    							current,
                    							"variable",
                    							lv_variable_1_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.VariableDotExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:7833:3: ( () ( (lv_obligationEvent_3_0= ruleObligationEvent ) ) )
                    {
                    // InternalSymboleo.g:7833:3: ( () ( (lv_obligationEvent_3_0= ruleObligationEvent ) ) )
                    // InternalSymboleo.g:7834:4: () ( (lv_obligationEvent_3_0= ruleObligationEvent ) )
                    {
                    // InternalSymboleo.g:7834:4: ()
                    // InternalSymboleo.g:7835:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPointAtomAccess().getPointAtomObligationEventAction_1_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:7841:4: ( (lv_obligationEvent_3_0= ruleObligationEvent ) )
                    // InternalSymboleo.g:7842:5: (lv_obligationEvent_3_0= ruleObligationEvent )
                    {
                    // InternalSymboleo.g:7842:5: (lv_obligationEvent_3_0= ruleObligationEvent )
                    // InternalSymboleo.g:7843:6: lv_obligationEvent_3_0= ruleObligationEvent
                    {

                    						newCompositeNode(grammarAccess.getPointAtomAccess().getObligationEventObligationEventParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_obligationEvent_3_0=ruleObligationEvent();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPointAtomRule());
                    						}
                    						set(
                    							current,
                    							"obligationEvent",
                    							lv_obligationEvent_3_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.ObligationEvent");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:7862:3: ( () ( (lv_contractEvent_5_0= ruleContractEvent ) ) )
                    {
                    // InternalSymboleo.g:7862:3: ( () ( (lv_contractEvent_5_0= ruleContractEvent ) ) )
                    // InternalSymboleo.g:7863:4: () ( (lv_contractEvent_5_0= ruleContractEvent ) )
                    {
                    // InternalSymboleo.g:7863:4: ()
                    // InternalSymboleo.g:7864:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPointAtomAccess().getPointAtomContractEventAction_2_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:7870:4: ( (lv_contractEvent_5_0= ruleContractEvent ) )
                    // InternalSymboleo.g:7871:5: (lv_contractEvent_5_0= ruleContractEvent )
                    {
                    // InternalSymboleo.g:7871:5: (lv_contractEvent_5_0= ruleContractEvent )
                    // InternalSymboleo.g:7872:6: lv_contractEvent_5_0= ruleContractEvent
                    {

                    						newCompositeNode(grammarAccess.getPointAtomAccess().getContractEventContractEventParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_contractEvent_5_0=ruleContractEvent();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPointAtomRule());
                    						}
                    						set(
                    							current,
                    							"contractEvent",
                    							lv_contractEvent_5_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.ContractEvent");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalSymboleo.g:7891:3: ( () ( (lv_powerEvent_7_0= rulePowerEvent ) ) )
                    {
                    // InternalSymboleo.g:7891:3: ( () ( (lv_powerEvent_7_0= rulePowerEvent ) ) )
                    // InternalSymboleo.g:7892:4: () ( (lv_powerEvent_7_0= rulePowerEvent ) )
                    {
                    // InternalSymboleo.g:7892:4: ()
                    // InternalSymboleo.g:7893:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPointAtomAccess().getPointAtomPowerEventAction_3_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:7899:4: ( (lv_powerEvent_7_0= rulePowerEvent ) )
                    // InternalSymboleo.g:7900:5: (lv_powerEvent_7_0= rulePowerEvent )
                    {
                    // InternalSymboleo.g:7900:5: (lv_powerEvent_7_0= rulePowerEvent )
                    // InternalSymboleo.g:7901:6: lv_powerEvent_7_0= rulePowerEvent
                    {

                    						newCompositeNode(grammarAccess.getPointAtomAccess().getPowerEventPowerEventParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_powerEvent_7_0=rulePowerEvent();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPointAtomRule());
                    						}
                    						set(
                    							current,
                    							"powerEvent",
                    							lv_powerEvent_7_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.PowerEvent");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePointAtom"


    // $ANTLR start "entryRuleTimevalue"
    // InternalSymboleo.g:7923:1: entryRuleTimevalue returns [EObject current=null] : iv_ruleTimevalue= ruleTimevalue EOF ;
    public final EObject entryRuleTimevalue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimevalue = null;


        try {
            // InternalSymboleo.g:7923:50: (iv_ruleTimevalue= ruleTimevalue EOF )
            // InternalSymboleo.g:7924:2: iv_ruleTimevalue= ruleTimevalue EOF
            {
             newCompositeNode(grammarAccess.getTimevalueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTimevalue=ruleTimevalue();

            state._fsp--;

             current =iv_ruleTimevalue; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTimevalue"


    // $ANTLR start "ruleTimevalue"
    // InternalSymboleo.g:7930:1: ruleTimevalue returns [EObject current=null] : ( ( () ( (lv_value_1_0= RULE_INT ) ) ) | ( () ( (lv_variable_3_0= ruleVariableDotExpression ) ) ) ) ;
    public final EObject ruleTimevalue() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        EObject lv_variable_3_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:7936:2: ( ( ( () ( (lv_value_1_0= RULE_INT ) ) ) | ( () ( (lv_variable_3_0= ruleVariableDotExpression ) ) ) ) )
            // InternalSymboleo.g:7937:2: ( ( () ( (lv_value_1_0= RULE_INT ) ) ) | ( () ( (lv_variable_3_0= ruleVariableDotExpression ) ) ) )
            {
            // InternalSymboleo.g:7937:2: ( ( () ( (lv_value_1_0= RULE_INT ) ) ) | ( () ( (lv_variable_3_0= ruleVariableDotExpression ) ) ) )
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==RULE_INT) ) {
                alt97=1;
            }
            else if ( (LA97_0==RULE_ID) ) {
                alt97=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 97, 0, input);

                throw nvae;
            }
            switch (alt97) {
                case 1 :
                    // InternalSymboleo.g:7938:3: ( () ( (lv_value_1_0= RULE_INT ) ) )
                    {
                    // InternalSymboleo.g:7938:3: ( () ( (lv_value_1_0= RULE_INT ) ) )
                    // InternalSymboleo.g:7939:4: () ( (lv_value_1_0= RULE_INT ) )
                    {
                    // InternalSymboleo.g:7939:4: ()
                    // InternalSymboleo.g:7940:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getTimevalueAccess().getTimevalueIntAction_0_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:7946:4: ( (lv_value_1_0= RULE_INT ) )
                    // InternalSymboleo.g:7947:5: (lv_value_1_0= RULE_INT )
                    {
                    // InternalSymboleo.g:7947:5: (lv_value_1_0= RULE_INT )
                    // InternalSymboleo.g:7948:6: lv_value_1_0= RULE_INT
                    {
                    lv_value_1_0=(Token)match(input,RULE_INT,FOLLOW_2); 

                    						newLeafNode(lv_value_1_0, grammarAccess.getTimevalueAccess().getValueINTTerminalRuleCall_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTimevalueRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"value",
                    							lv_value_1_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:7966:3: ( () ( (lv_variable_3_0= ruleVariableDotExpression ) ) )
                    {
                    // InternalSymboleo.g:7966:3: ( () ( (lv_variable_3_0= ruleVariableDotExpression ) ) )
                    // InternalSymboleo.g:7967:4: () ( (lv_variable_3_0= ruleVariableDotExpression ) )
                    {
                    // InternalSymboleo.g:7967:4: ()
                    // InternalSymboleo.g:7968:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getTimevalueAccess().getTimevalueVariableAction_1_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:7974:4: ( (lv_variable_3_0= ruleVariableDotExpression ) )
                    // InternalSymboleo.g:7975:5: (lv_variable_3_0= ruleVariableDotExpression )
                    {
                    // InternalSymboleo.g:7975:5: (lv_variable_3_0= ruleVariableDotExpression )
                    // InternalSymboleo.g:7976:6: lv_variable_3_0= ruleVariableDotExpression
                    {

                    						newCompositeNode(grammarAccess.getTimevalueAccess().getVariableVariableDotExpressionParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_variable_3_0=ruleVariableDotExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTimevalueRule());
                    						}
                    						set(
                    							current,
                    							"variable",
                    							lv_variable_3_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.VariableDotExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTimevalue"


    // $ANTLR start "entryRuleTimeUnit"
    // InternalSymboleo.g:7998:1: entryRuleTimeUnit returns [String current=null] : iv_ruleTimeUnit= ruleTimeUnit EOF ;
    public final String entryRuleTimeUnit() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleTimeUnit = null;


        try {
            // InternalSymboleo.g:7998:48: (iv_ruleTimeUnit= ruleTimeUnit EOF )
            // InternalSymboleo.g:7999:2: iv_ruleTimeUnit= ruleTimeUnit EOF
            {
             newCompositeNode(grammarAccess.getTimeUnitRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTimeUnit=ruleTimeUnit();

            state._fsp--;

             current =iv_ruleTimeUnit.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTimeUnit"


    // $ANTLR start "ruleTimeUnit"
    // InternalSymboleo.g:8005:1: ruleTimeUnit returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'seconds' | kw= 'minutes' | kw= 'hours' | kw= 'days' | kw= 'weeks' | kw= 'months' | kw= 'years' ) ;
    public final AntlrDatatypeRuleToken ruleTimeUnit() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSymboleo.g:8011:2: ( (kw= 'seconds' | kw= 'minutes' | kw= 'hours' | kw= 'days' | kw= 'weeks' | kw= 'months' | kw= 'years' ) )
            // InternalSymboleo.g:8012:2: (kw= 'seconds' | kw= 'minutes' | kw= 'hours' | kw= 'days' | kw= 'weeks' | kw= 'months' | kw= 'years' )
            {
            // InternalSymboleo.g:8012:2: (kw= 'seconds' | kw= 'minutes' | kw= 'hours' | kw= 'days' | kw= 'weeks' | kw= 'months' | kw= 'years' )
            int alt98=7;
            switch ( input.LA(1) ) {
            case 129:
                {
                alt98=1;
                }
                break;
            case 130:
                {
                alt98=2;
                }
                break;
            case 131:
                {
                alt98=3;
                }
                break;
            case 132:
                {
                alt98=4;
                }
                break;
            case 133:
                {
                alt98=5;
                }
                break;
            case 134:
                {
                alt98=6;
                }
                break;
            case 135:
                {
                alt98=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 98, 0, input);

                throw nvae;
            }

            switch (alt98) {
                case 1 :
                    // InternalSymboleo.g:8013:3: kw= 'seconds'
                    {
                    kw=(Token)match(input,129,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTimeUnitAccess().getSecondsKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:8019:3: kw= 'minutes'
                    {
                    kw=(Token)match(input,130,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTimeUnitAccess().getMinutesKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:8025:3: kw= 'hours'
                    {
                    kw=(Token)match(input,131,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTimeUnitAccess().getHoursKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalSymboleo.g:8031:3: kw= 'days'
                    {
                    kw=(Token)match(input,132,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTimeUnitAccess().getDaysKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalSymboleo.g:8037:3: kw= 'weeks'
                    {
                    kw=(Token)match(input,133,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTimeUnitAccess().getWeeksKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalSymboleo.g:8043:3: kw= 'months'
                    {
                    kw=(Token)match(input,134,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTimeUnitAccess().getMonthsKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalSymboleo.g:8049:3: kw= 'years'
                    {
                    kw=(Token)match(input,135,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTimeUnitAccess().getYearsKeyword_6());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTimeUnit"


    // $ANTLR start "entryRuleInterval"
    // InternalSymboleo.g:8058:1: entryRuleInterval returns [EObject current=null] : iv_ruleInterval= ruleInterval EOF ;
    public final EObject entryRuleInterval() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterval = null;


        try {
            // InternalSymboleo.g:8058:49: (iv_ruleInterval= ruleInterval EOF )
            // InternalSymboleo.g:8059:2: iv_ruleInterval= ruleInterval EOF
            {
             newCompositeNode(grammarAccess.getIntervalRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInterval=ruleInterval();

            state._fsp--;

             current =iv_ruleInterval; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInterval"


    // $ANTLR start "ruleInterval"
    // InternalSymboleo.g:8065:1: ruleInterval returns [EObject current=null] : ( (lv_intervalExpression_0_0= ruleIntervalExpression ) ) ;
    public final EObject ruleInterval() throws RecognitionException {
        EObject current = null;

        EObject lv_intervalExpression_0_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:8071:2: ( ( (lv_intervalExpression_0_0= ruleIntervalExpression ) ) )
            // InternalSymboleo.g:8072:2: ( (lv_intervalExpression_0_0= ruleIntervalExpression ) )
            {
            // InternalSymboleo.g:8072:2: ( (lv_intervalExpression_0_0= ruleIntervalExpression ) )
            // InternalSymboleo.g:8073:3: (lv_intervalExpression_0_0= ruleIntervalExpression )
            {
            // InternalSymboleo.g:8073:3: (lv_intervalExpression_0_0= ruleIntervalExpression )
            // InternalSymboleo.g:8074:4: lv_intervalExpression_0_0= ruleIntervalExpression
            {

            				newCompositeNode(grammarAccess.getIntervalAccess().getIntervalExpressionIntervalExpressionParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_intervalExpression_0_0=ruleIntervalExpression();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getIntervalRule());
            				}
            				set(
            					current,
            					"intervalExpression",
            					lv_intervalExpression_0_0,
            					"ca.uottawa.csmlab.symboleo.Symboleo.IntervalExpression");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInterval"


    // $ANTLR start "entryRuleIntervalExpression"
    // InternalSymboleo.g:8094:1: entryRuleIntervalExpression returns [EObject current=null] : iv_ruleIntervalExpression= ruleIntervalExpression EOF ;
    public final EObject entryRuleIntervalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntervalExpression = null;


        try {
            // InternalSymboleo.g:8094:59: (iv_ruleIntervalExpression= ruleIntervalExpression EOF )
            // InternalSymboleo.g:8095:2: iv_ruleIntervalExpression= ruleIntervalExpression EOF
            {
             newCompositeNode(grammarAccess.getIntervalExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIntervalExpression=ruleIntervalExpression();

            state._fsp--;

             current =iv_ruleIntervalExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntervalExpression"


    // $ANTLR start "ruleIntervalExpression"
    // InternalSymboleo.g:8101:1: ruleIntervalExpression returns [EObject current=null] : ( ( () otherlv_1= 'Interval' otherlv_2= '(' ( (lv_arg1_3_0= rulePointExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= rulePointExpression ) ) otherlv_6= ')' ) | ( () ( (lv_situation_8_0= ruleSituation ) ) ) ) ;
    public final EObject ruleIntervalExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_arg1_3_0 = null;

        EObject lv_arg2_5_0 = null;

        EObject lv_situation_8_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:8107:2: ( ( ( () otherlv_1= 'Interval' otherlv_2= '(' ( (lv_arg1_3_0= rulePointExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= rulePointExpression ) ) otherlv_6= ')' ) | ( () ( (lv_situation_8_0= ruleSituation ) ) ) ) )
            // InternalSymboleo.g:8108:2: ( ( () otherlv_1= 'Interval' otherlv_2= '(' ( (lv_arg1_3_0= rulePointExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= rulePointExpression ) ) otherlv_6= ')' ) | ( () ( (lv_situation_8_0= ruleSituation ) ) ) )
            {
            // InternalSymboleo.g:8108:2: ( ( () otherlv_1= 'Interval' otherlv_2= '(' ( (lv_arg1_3_0= rulePointExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= rulePointExpression ) ) otherlv_6= ')' ) | ( () ( (lv_situation_8_0= ruleSituation ) ) ) )
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==136) ) {
                alt99=1;
            }
            else if ( ((LA99_0>=137 && LA99_0<=148)) ) {
                alt99=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 99, 0, input);

                throw nvae;
            }
            switch (alt99) {
                case 1 :
                    // InternalSymboleo.g:8109:3: ( () otherlv_1= 'Interval' otherlv_2= '(' ( (lv_arg1_3_0= rulePointExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= rulePointExpression ) ) otherlv_6= ')' )
                    {
                    // InternalSymboleo.g:8109:3: ( () otherlv_1= 'Interval' otherlv_2= '(' ( (lv_arg1_3_0= rulePointExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= rulePointExpression ) ) otherlv_6= ')' )
                    // InternalSymboleo.g:8110:4: () otherlv_1= 'Interval' otherlv_2= '(' ( (lv_arg1_3_0= rulePointExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= rulePointExpression ) ) otherlv_6= ')'
                    {
                    // InternalSymboleo.g:8110:4: ()
                    // InternalSymboleo.g:8111:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getIntervalExpressionAccess().getIntervalFunctionAction_0_0(),
                    						current);
                    				

                    }

                    otherlv_1=(Token)match(input,136,FOLLOW_10); 

                    				newLeafNode(otherlv_1, grammarAccess.getIntervalExpressionAccess().getIntervalKeyword_0_1());
                    			
                    otherlv_2=(Token)match(input,17,FOLLOW_71); 

                    				newLeafNode(otherlv_2, grammarAccess.getIntervalExpressionAccess().getLeftParenthesisKeyword_0_2());
                    			
                    // InternalSymboleo.g:8125:4: ( (lv_arg1_3_0= rulePointExpression ) )
                    // InternalSymboleo.g:8126:5: (lv_arg1_3_0= rulePointExpression )
                    {
                    // InternalSymboleo.g:8126:5: (lv_arg1_3_0= rulePointExpression )
                    // InternalSymboleo.g:8127:6: lv_arg1_3_0= rulePointExpression
                    {

                    						newCompositeNode(grammarAccess.getIntervalExpressionAccess().getArg1PointExpressionParserRuleCall_0_3_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_arg1_3_0=rulePointExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIntervalExpressionRule());
                    						}
                    						set(
                    							current,
                    							"arg1",
                    							lv_arg1_3_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.PointExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,18,FOLLOW_71); 

                    				newLeafNode(otherlv_4, grammarAccess.getIntervalExpressionAccess().getCommaKeyword_0_4());
                    			
                    // InternalSymboleo.g:8148:4: ( (lv_arg2_5_0= rulePointExpression ) )
                    // InternalSymboleo.g:8149:5: (lv_arg2_5_0= rulePointExpression )
                    {
                    // InternalSymboleo.g:8149:5: (lv_arg2_5_0= rulePointExpression )
                    // InternalSymboleo.g:8150:6: lv_arg2_5_0= rulePointExpression
                    {

                    						newCompositeNode(grammarAccess.getIntervalExpressionAccess().getArg2PointExpressionParserRuleCall_0_5_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_arg2_5_0=rulePointExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIntervalExpressionRule());
                    						}
                    						set(
                    							current,
                    							"arg2",
                    							lv_arg2_5_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.PointExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_6=(Token)match(input,19,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getIntervalExpressionAccess().getRightParenthesisKeyword_0_6());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:8173:3: ( () ( (lv_situation_8_0= ruleSituation ) ) )
                    {
                    // InternalSymboleo.g:8173:3: ( () ( (lv_situation_8_0= ruleSituation ) ) )
                    // InternalSymboleo.g:8174:4: () ( (lv_situation_8_0= ruleSituation ) )
                    {
                    // InternalSymboleo.g:8174:4: ()
                    // InternalSymboleo.g:8175:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getIntervalExpressionAccess().getSituationExpressionAction_1_0(),
                    						current);
                    				

                    }

                    // InternalSymboleo.g:8181:4: ( (lv_situation_8_0= ruleSituation ) )
                    // InternalSymboleo.g:8182:5: (lv_situation_8_0= ruleSituation )
                    {
                    // InternalSymboleo.g:8182:5: (lv_situation_8_0= ruleSituation )
                    // InternalSymboleo.g:8183:6: lv_situation_8_0= ruleSituation
                    {

                    						newCompositeNode(grammarAccess.getIntervalExpressionAccess().getSituationSituationParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_situation_8_0=ruleSituation();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIntervalExpressionRule());
                    						}
                    						set(
                    							current,
                    							"situation",
                    							lv_situation_8_0,
                    							"ca.uottawa.csmlab.symboleo.Symboleo.Situation");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntervalExpression"


    // $ANTLR start "entryRuleSituation"
    // InternalSymboleo.g:8205:1: entryRuleSituation returns [EObject current=null] : iv_ruleSituation= ruleSituation EOF ;
    public final EObject entryRuleSituation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSituation = null;


        try {
            // InternalSymboleo.g:8205:50: (iv_ruleSituation= ruleSituation EOF )
            // InternalSymboleo.g:8206:2: iv_ruleSituation= ruleSituation EOF
            {
             newCompositeNode(grammarAccess.getSituationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSituation=ruleSituation();

            state._fsp--;

             current =iv_ruleSituation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSituation"


    // $ANTLR start "ruleSituation"
    // InternalSymboleo.g:8212:1: ruleSituation returns [EObject current=null] : (this_ObligationState_0= ruleObligationState | this_ContractState_1= ruleContractState | this_PowerState_2= rulePowerState ) ;
    public final EObject ruleSituation() throws RecognitionException {
        EObject current = null;

        EObject this_ObligationState_0 = null;

        EObject this_ContractState_1 = null;

        EObject this_PowerState_2 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:8218:2: ( (this_ObligationState_0= ruleObligationState | this_ContractState_1= ruleContractState | this_PowerState_2= rulePowerState ) )
            // InternalSymboleo.g:8219:2: (this_ObligationState_0= ruleObligationState | this_ContractState_1= ruleContractState | this_PowerState_2= rulePowerState )
            {
            // InternalSymboleo.g:8219:2: (this_ObligationState_0= ruleObligationState | this_ContractState_1= ruleContractState | this_PowerState_2= rulePowerState )
            int alt100=3;
            alt100 = dfa100.predict(input);
            switch (alt100) {
                case 1 :
                    // InternalSymboleo.g:8220:3: this_ObligationState_0= ruleObligationState
                    {

                    			newCompositeNode(grammarAccess.getSituationAccess().getObligationStateParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ObligationState_0=ruleObligationState();

                    state._fsp--;


                    			current = this_ObligationState_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:8229:3: this_ContractState_1= ruleContractState
                    {

                    			newCompositeNode(grammarAccess.getSituationAccess().getContractStateParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ContractState_1=ruleContractState();

                    state._fsp--;


                    			current = this_ContractState_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:8238:3: this_PowerState_2= rulePowerState
                    {

                    			newCompositeNode(grammarAccess.getSituationAccess().getPowerStateParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_PowerState_2=rulePowerState();

                    state._fsp--;


                    			current = this_PowerState_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSituation"


    // $ANTLR start "entryRulePowerState"
    // InternalSymboleo.g:8250:1: entryRulePowerState returns [EObject current=null] : iv_rulePowerState= rulePowerState EOF ;
    public final EObject entryRulePowerState() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePowerState = null;


        try {
            // InternalSymboleo.g:8250:51: (iv_rulePowerState= rulePowerState EOF )
            // InternalSymboleo.g:8251:2: iv_rulePowerState= rulePowerState EOF
            {
             newCompositeNode(grammarAccess.getPowerStateRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePowerState=rulePowerState();

            state._fsp--;

             current =iv_rulePowerState; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePowerState"


    // $ANTLR start "rulePowerState"
    // InternalSymboleo.g:8257:1: rulePowerState returns [EObject current=null] : ( ( (lv_stateName_0_0= rulePowerStateName ) ) otherlv_1= '(' otherlv_2= 'powers.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' ) ;
    public final EObject rulePowerState() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_stateName_0_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:8263:2: ( ( ( (lv_stateName_0_0= rulePowerStateName ) ) otherlv_1= '(' otherlv_2= 'powers.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' ) )
            // InternalSymboleo.g:8264:2: ( ( (lv_stateName_0_0= rulePowerStateName ) ) otherlv_1= '(' otherlv_2= 'powers.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )
            {
            // InternalSymboleo.g:8264:2: ( ( (lv_stateName_0_0= rulePowerStateName ) ) otherlv_1= '(' otherlv_2= 'powers.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )
            // InternalSymboleo.g:8265:3: ( (lv_stateName_0_0= rulePowerStateName ) ) otherlv_1= '(' otherlv_2= 'powers.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')'
            {
            // InternalSymboleo.g:8265:3: ( (lv_stateName_0_0= rulePowerStateName ) )
            // InternalSymboleo.g:8266:4: (lv_stateName_0_0= rulePowerStateName )
            {
            // InternalSymboleo.g:8266:4: (lv_stateName_0_0= rulePowerStateName )
            // InternalSymboleo.g:8267:5: lv_stateName_0_0= rulePowerStateName
            {

            					newCompositeNode(grammarAccess.getPowerStateAccess().getStateNamePowerStateNameParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_10);
            lv_stateName_0_0=rulePowerStateName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPowerStateRule());
            					}
            					set(
            						current,
            						"stateName",
            						lv_stateName_0_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.PowerStateName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,17,FOLLOW_74); 

            			newLeafNode(otherlv_1, grammarAccess.getPowerStateAccess().getLeftParenthesisKeyword_1());
            		
            otherlv_2=(Token)match(input,52,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getPowerStateAccess().getPowersKeyword_2());
            		
            // InternalSymboleo.g:8292:3: ( (otherlv_3= RULE_ID ) )
            // InternalSymboleo.g:8293:4: (otherlv_3= RULE_ID )
            {
            // InternalSymboleo.g:8293:4: (otherlv_3= RULE_ID )
            // InternalSymboleo.g:8294:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPowerStateRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_12); 

            					newLeafNode(otherlv_3, grammarAccess.getPowerStateAccess().getPowerVariablePowerCrossReference_3_0());
            				

            }


            }

            otherlv_4=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getPowerStateAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePowerState"


    // $ANTLR start "entryRulePowerStateName"
    // InternalSymboleo.g:8313:1: entryRulePowerStateName returns [String current=null] : iv_rulePowerStateName= rulePowerStateName EOF ;
    public final String entryRulePowerStateName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePowerStateName = null;


        try {
            // InternalSymboleo.g:8313:54: (iv_rulePowerStateName= rulePowerStateName EOF )
            // InternalSymboleo.g:8314:2: iv_rulePowerStateName= rulePowerStateName EOF
            {
             newCompositeNode(grammarAccess.getPowerStateNameRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePowerStateName=rulePowerStateName();

            state._fsp--;

             current =iv_rulePowerStateName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePowerStateName"


    // $ANTLR start "rulePowerStateName"
    // InternalSymboleo.g:8320:1: rulePowerStateName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Create' | kw= 'UnsuccessfulTermination' | kw= 'Active' | kw= 'InEffect' | kw= 'Suspension' | kw= 'SuccessfulTermination' ) ;
    public final AntlrDatatypeRuleToken rulePowerStateName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSymboleo.g:8326:2: ( (kw= 'Create' | kw= 'UnsuccessfulTermination' | kw= 'Active' | kw= 'InEffect' | kw= 'Suspension' | kw= 'SuccessfulTermination' ) )
            // InternalSymboleo.g:8327:2: (kw= 'Create' | kw= 'UnsuccessfulTermination' | kw= 'Active' | kw= 'InEffect' | kw= 'Suspension' | kw= 'SuccessfulTermination' )
            {
            // InternalSymboleo.g:8327:2: (kw= 'Create' | kw= 'UnsuccessfulTermination' | kw= 'Active' | kw= 'InEffect' | kw= 'Suspension' | kw= 'SuccessfulTermination' )
            int alt101=6;
            switch ( input.LA(1) ) {
            case 137:
                {
                alt101=1;
                }
                break;
            case 138:
                {
                alt101=2;
                }
                break;
            case 139:
                {
                alt101=3;
                }
                break;
            case 140:
                {
                alt101=4;
                }
                break;
            case 141:
                {
                alt101=5;
                }
                break;
            case 142:
                {
                alt101=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 101, 0, input);

                throw nvae;
            }

            switch (alt101) {
                case 1 :
                    // InternalSymboleo.g:8328:3: kw= 'Create'
                    {
                    kw=(Token)match(input,137,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowerStateNameAccess().getCreateKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:8334:3: kw= 'UnsuccessfulTermination'
                    {
                    kw=(Token)match(input,138,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowerStateNameAccess().getUnsuccessfulTerminationKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:8340:3: kw= 'Active'
                    {
                    kw=(Token)match(input,139,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowerStateNameAccess().getActiveKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalSymboleo.g:8346:3: kw= 'InEffect'
                    {
                    kw=(Token)match(input,140,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowerStateNameAccess().getInEffectKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalSymboleo.g:8352:3: kw= 'Suspension'
                    {
                    kw=(Token)match(input,141,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowerStateNameAccess().getSuspensionKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalSymboleo.g:8358:3: kw= 'SuccessfulTermination'
                    {
                    kw=(Token)match(input,142,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowerStateNameAccess().getSuccessfulTerminationKeyword_5());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePowerStateName"


    // $ANTLR start "entryRuleObligationState"
    // InternalSymboleo.g:8367:1: entryRuleObligationState returns [EObject current=null] : iv_ruleObligationState= ruleObligationState EOF ;
    public final EObject entryRuleObligationState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObligationState = null;


        try {
            // InternalSymboleo.g:8367:56: (iv_ruleObligationState= ruleObligationState EOF )
            // InternalSymboleo.g:8368:2: iv_ruleObligationState= ruleObligationState EOF
            {
             newCompositeNode(grammarAccess.getObligationStateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleObligationState=ruleObligationState();

            state._fsp--;

             current =iv_ruleObligationState; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleObligationState"


    // $ANTLR start "ruleObligationState"
    // InternalSymboleo.g:8374:1: ruleObligationState returns [EObject current=null] : ( ( (lv_stateName_0_0= ruleObligationStateName ) ) otherlv_1= '(' otherlv_2= 'obligations.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' ) ;
    public final EObject ruleObligationState() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_stateName_0_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:8380:2: ( ( ( (lv_stateName_0_0= ruleObligationStateName ) ) otherlv_1= '(' otherlv_2= 'obligations.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' ) )
            // InternalSymboleo.g:8381:2: ( ( (lv_stateName_0_0= ruleObligationStateName ) ) otherlv_1= '(' otherlv_2= 'obligations.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )
            {
            // InternalSymboleo.g:8381:2: ( ( (lv_stateName_0_0= ruleObligationStateName ) ) otherlv_1= '(' otherlv_2= 'obligations.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )
            // InternalSymboleo.g:8382:3: ( (lv_stateName_0_0= ruleObligationStateName ) ) otherlv_1= '(' otherlv_2= 'obligations.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')'
            {
            // InternalSymboleo.g:8382:3: ( (lv_stateName_0_0= ruleObligationStateName ) )
            // InternalSymboleo.g:8383:4: (lv_stateName_0_0= ruleObligationStateName )
            {
            // InternalSymboleo.g:8383:4: (lv_stateName_0_0= ruleObligationStateName )
            // InternalSymboleo.g:8384:5: lv_stateName_0_0= ruleObligationStateName
            {

            					newCompositeNode(grammarAccess.getObligationStateAccess().getStateNameObligationStateNameParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_10);
            lv_stateName_0_0=ruleObligationStateName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getObligationStateRule());
            					}
            					set(
            						current,
            						"stateName",
            						lv_stateName_0_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.ObligationStateName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,17,FOLLOW_67); 

            			newLeafNode(otherlv_1, grammarAccess.getObligationStateAccess().getLeftParenthesisKeyword_1());
            		
            otherlv_2=(Token)match(input,51,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getObligationStateAccess().getObligationsKeyword_2());
            		
            // InternalSymboleo.g:8409:3: ( (otherlv_3= RULE_ID ) )
            // InternalSymboleo.g:8410:4: (otherlv_3= RULE_ID )
            {
            // InternalSymboleo.g:8410:4: (otherlv_3= RULE_ID )
            // InternalSymboleo.g:8411:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getObligationStateRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_12); 

            					newLeafNode(otherlv_3, grammarAccess.getObligationStateAccess().getObligationVariableObligationCrossReference_3_0());
            				

            }


            }

            otherlv_4=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getObligationStateAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleObligationState"


    // $ANTLR start "entryRuleObligationStateName"
    // InternalSymboleo.g:8430:1: entryRuleObligationStateName returns [String current=null] : iv_ruleObligationStateName= ruleObligationStateName EOF ;
    public final String entryRuleObligationStateName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleObligationStateName = null;


        try {
            // InternalSymboleo.g:8430:59: (iv_ruleObligationStateName= ruleObligationStateName EOF )
            // InternalSymboleo.g:8431:2: iv_ruleObligationStateName= ruleObligationStateName EOF
            {
             newCompositeNode(grammarAccess.getObligationStateNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleObligationStateName=ruleObligationStateName();

            state._fsp--;

             current =iv_ruleObligationStateName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleObligationStateName"


    // $ANTLR start "ruleObligationStateName"
    // InternalSymboleo.g:8437:1: ruleObligationStateName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Create' | kw= 'Discharge' | kw= 'Active' | kw= 'InEffect' | kw= 'Suspension' | kw= 'Violation' | kw= 'Fulfillment' | kw= 'UnsuccessfulTermination' ) ;
    public final AntlrDatatypeRuleToken ruleObligationStateName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSymboleo.g:8443:2: ( (kw= 'Create' | kw= 'Discharge' | kw= 'Active' | kw= 'InEffect' | kw= 'Suspension' | kw= 'Violation' | kw= 'Fulfillment' | kw= 'UnsuccessfulTermination' ) )
            // InternalSymboleo.g:8444:2: (kw= 'Create' | kw= 'Discharge' | kw= 'Active' | kw= 'InEffect' | kw= 'Suspension' | kw= 'Violation' | kw= 'Fulfillment' | kw= 'UnsuccessfulTermination' )
            {
            // InternalSymboleo.g:8444:2: (kw= 'Create' | kw= 'Discharge' | kw= 'Active' | kw= 'InEffect' | kw= 'Suspension' | kw= 'Violation' | kw= 'Fulfillment' | kw= 'UnsuccessfulTermination' )
            int alt102=8;
            switch ( input.LA(1) ) {
            case 137:
                {
                alt102=1;
                }
                break;
            case 143:
                {
                alt102=2;
                }
                break;
            case 139:
                {
                alt102=3;
                }
                break;
            case 140:
                {
                alt102=4;
                }
                break;
            case 141:
                {
                alt102=5;
                }
                break;
            case 144:
                {
                alt102=6;
                }
                break;
            case 145:
                {
                alt102=7;
                }
                break;
            case 138:
                {
                alt102=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 102, 0, input);

                throw nvae;
            }

            switch (alt102) {
                case 1 :
                    // InternalSymboleo.g:8445:3: kw= 'Create'
                    {
                    kw=(Token)match(input,137,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationStateNameAccess().getCreateKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:8451:3: kw= 'Discharge'
                    {
                    kw=(Token)match(input,143,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationStateNameAccess().getDischargeKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:8457:3: kw= 'Active'
                    {
                    kw=(Token)match(input,139,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationStateNameAccess().getActiveKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalSymboleo.g:8463:3: kw= 'InEffect'
                    {
                    kw=(Token)match(input,140,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationStateNameAccess().getInEffectKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalSymboleo.g:8469:3: kw= 'Suspension'
                    {
                    kw=(Token)match(input,141,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationStateNameAccess().getSuspensionKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalSymboleo.g:8475:3: kw= 'Violation'
                    {
                    kw=(Token)match(input,144,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationStateNameAccess().getViolationKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalSymboleo.g:8481:3: kw= 'Fulfillment'
                    {
                    kw=(Token)match(input,145,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationStateNameAccess().getFulfillmentKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalSymboleo.g:8487:3: kw= 'UnsuccessfulTermination'
                    {
                    kw=(Token)match(input,138,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationStateNameAccess().getUnsuccessfulTerminationKeyword_7());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleObligationStateName"


    // $ANTLR start "entryRuleContractState"
    // InternalSymboleo.g:8496:1: entryRuleContractState returns [EObject current=null] : iv_ruleContractState= ruleContractState EOF ;
    public final EObject entryRuleContractState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContractState = null;


        try {
            // InternalSymboleo.g:8496:54: (iv_ruleContractState= ruleContractState EOF )
            // InternalSymboleo.g:8497:2: iv_ruleContractState= ruleContractState EOF
            {
             newCompositeNode(grammarAccess.getContractStateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContractState=ruleContractState();

            state._fsp--;

             current =iv_ruleContractState; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContractState"


    // $ANTLR start "ruleContractState"
    // InternalSymboleo.g:8503:1: ruleContractState returns [EObject current=null] : ( ( (lv_stateName_0_0= ruleContractStateName ) ) otherlv_1= '(' otherlv_2= 'self' otherlv_3= ')' ) ;
    public final EObject ruleContractState() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_stateName_0_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:8509:2: ( ( ( (lv_stateName_0_0= ruleContractStateName ) ) otherlv_1= '(' otherlv_2= 'self' otherlv_3= ')' ) )
            // InternalSymboleo.g:8510:2: ( ( (lv_stateName_0_0= ruleContractStateName ) ) otherlv_1= '(' otherlv_2= 'self' otherlv_3= ')' )
            {
            // InternalSymboleo.g:8510:2: ( ( (lv_stateName_0_0= ruleContractStateName ) ) otherlv_1= '(' otherlv_2= 'self' otherlv_3= ')' )
            // InternalSymboleo.g:8511:3: ( (lv_stateName_0_0= ruleContractStateName ) ) otherlv_1= '(' otherlv_2= 'self' otherlv_3= ')'
            {
            // InternalSymboleo.g:8511:3: ( (lv_stateName_0_0= ruleContractStateName ) )
            // InternalSymboleo.g:8512:4: (lv_stateName_0_0= ruleContractStateName )
            {
            // InternalSymboleo.g:8512:4: (lv_stateName_0_0= ruleContractStateName )
            // InternalSymboleo.g:8513:5: lv_stateName_0_0= ruleContractStateName
            {

            					newCompositeNode(grammarAccess.getContractStateAccess().getStateNameContractStateNameParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_10);
            lv_stateName_0_0=ruleContractStateName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getContractStateRule());
            					}
            					set(
            						current,
            						"stateName",
            						lv_stateName_0_0,
            						"ca.uottawa.csmlab.symboleo.Symboleo.ContractStateName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,17,FOLLOW_68); 

            			newLeafNode(otherlv_1, grammarAccess.getContractStateAccess().getLeftParenthesisKeyword_1());
            		
            otherlv_2=(Token)match(input,106,FOLLOW_12); 

            			newLeafNode(otherlv_2, grammarAccess.getContractStateAccess().getSelfKeyword_2());
            		
            otherlv_3=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getContractStateAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContractState"


    // $ANTLR start "entryRuleContractStateName"
    // InternalSymboleo.g:8546:1: entryRuleContractStateName returns [String current=null] : iv_ruleContractStateName= ruleContractStateName EOF ;
    public final String entryRuleContractStateName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleContractStateName = null;


        try {
            // InternalSymboleo.g:8546:57: (iv_ruleContractStateName= ruleContractStateName EOF )
            // InternalSymboleo.g:8547:2: iv_ruleContractStateName= ruleContractStateName EOF
            {
             newCompositeNode(grammarAccess.getContractStateNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContractStateName=ruleContractStateName();

            state._fsp--;

             current =iv_ruleContractStateName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContractStateName"


    // $ANTLR start "ruleContractStateName"
    // InternalSymboleo.g:8553:1: ruleContractStateName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Form' | kw= 'UnAssign' | kw= 'InEffect' | kw= 'Suspension' | kw= 'Rescission' | kw= 'SuccessfulTermination' | kw= 'UnsuccessfulTermination' | kw= 'Active' ) ;
    public final AntlrDatatypeRuleToken ruleContractStateName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSymboleo.g:8559:2: ( (kw= 'Form' | kw= 'UnAssign' | kw= 'InEffect' | kw= 'Suspension' | kw= 'Rescission' | kw= 'SuccessfulTermination' | kw= 'UnsuccessfulTermination' | kw= 'Active' ) )
            // InternalSymboleo.g:8560:2: (kw= 'Form' | kw= 'UnAssign' | kw= 'InEffect' | kw= 'Suspension' | kw= 'Rescission' | kw= 'SuccessfulTermination' | kw= 'UnsuccessfulTermination' | kw= 'Active' )
            {
            // InternalSymboleo.g:8560:2: (kw= 'Form' | kw= 'UnAssign' | kw= 'InEffect' | kw= 'Suspension' | kw= 'Rescission' | kw= 'SuccessfulTermination' | kw= 'UnsuccessfulTermination' | kw= 'Active' )
            int alt103=8;
            switch ( input.LA(1) ) {
            case 146:
                {
                alt103=1;
                }
                break;
            case 147:
                {
                alt103=2;
                }
                break;
            case 140:
                {
                alt103=3;
                }
                break;
            case 141:
                {
                alt103=4;
                }
                break;
            case 148:
                {
                alt103=5;
                }
                break;
            case 142:
                {
                alt103=6;
                }
                break;
            case 138:
                {
                alt103=7;
                }
                break;
            case 139:
                {
                alt103=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 103, 0, input);

                throw nvae;
            }

            switch (alt103) {
                case 1 :
                    // InternalSymboleo.g:8561:3: kw= 'Form'
                    {
                    kw=(Token)match(input,146,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractStateNameAccess().getFormKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:8567:3: kw= 'UnAssign'
                    {
                    kw=(Token)match(input,147,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractStateNameAccess().getUnAssignKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:8573:3: kw= 'InEffect'
                    {
                    kw=(Token)match(input,140,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractStateNameAccess().getInEffectKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalSymboleo.g:8579:3: kw= 'Suspension'
                    {
                    kw=(Token)match(input,141,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractStateNameAccess().getSuspensionKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalSymboleo.g:8585:3: kw= 'Rescission'
                    {
                    kw=(Token)match(input,148,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractStateNameAccess().getRescissionKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalSymboleo.g:8591:3: kw= 'SuccessfulTermination'
                    {
                    kw=(Token)match(input,142,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractStateNameAccess().getSuccessfulTerminationKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalSymboleo.g:8597:3: kw= 'UnsuccessfulTermination'
                    {
                    kw=(Token)match(input,138,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractStateNameAccess().getUnsuccessfulTerminationKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalSymboleo.g:8603:3: kw= 'Active'
                    {
                    kw=(Token)match(input,139,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractStateNameAccess().getActiveKeyword_7());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContractStateName"

    // Delegated rules


    protected DFA3 dfa3 = new DFA3(this);
    protected DFA24 dfa24 = new DFA24(this);
    protected DFA27 dfa27 = new DFA27(this);
    protected DFA30 dfa30 = new DFA30(this);
    protected DFA42 dfa42 = new DFA42(this);
    protected DFA61 dfa61 = new DFA61(this);
    protected DFA75 dfa75 = new DFA75(this);
    protected DFA84 dfa84 = new DFA84(this);
    protected DFA91 dfa91 = new DFA91(this);
    protected DFA96 dfa96 = new DFA96(this);
    protected DFA100 dfa100 = new DFA100(this);
    static final String dfa_1s = "\12\uffff";
    static final String dfa_2s = "\1\4\1\41\1\4\5\22\2\uffff";
    static final String dfa_3s = "\1\4\1\41\1\47\5\23\2\uffff";
    static final String dfa_4s = "\10\uffff\1\2\1\1";
    static final String dfa_5s = "\12\uffff}>";
    static final String[] dfa_6s = {
            "\1\1",
            "\1\2",
            "\1\7\37\uffff\1\3\1\4\1\5\1\6",
            "\1\11\1\10",
            "\1\11\1\10",
            "\1\11\1\10",
            "\1\11\1\10",
            "\1\11\1\10",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "()+ loopback of 185:3: ( ( (lv_parameters_11_0= ruleParameter ) ) otherlv_12= ',' )+";
        }
    }
    static final String dfa_7s = "\13\uffff";
    static final String dfa_8s = "\4\uffff\5\12\2\uffff";
    static final String dfa_9s = "\2\4\1\41\1\4\5\14\2\uffff";
    static final String dfa_10s = "\1\72\1\4\1\41\1\47\5\22\2\uffff";
    static final String dfa_11s = "\11\uffff\1\1\1\2";
    static final String dfa_12s = "\13\uffff}>";
    static final String[] dfa_13s = {
            "\1\2\65\uffff\1\1",
            "\1\2",
            "\1\3",
            "\1\10\37\uffff\1\4\1\5\1\6\1\7",
            "\1\12\5\uffff\1\11",
            "\1\12\5\uffff\1\11",
            "\1\12\5\uffff\1\11",
            "\1\12\5\uffff\1\11",
            "\1\12\5\uffff\1\11",
            "",
            ""
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA24 extends DFA {

        public DFA24(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 24;
            this.eot = dfa_7;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "()* loopback of 837:5: ( ( (lv_attributes_6_0= ruleAttribute ) ) otherlv_7= ',' )*";
        }
    }

    class DFA27 extends DFA {

        public DFA27(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 27;
            this.eot = dfa_7;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "()* loopback of 932:5: ( ( (lv_attributes_14_0= ruleAttribute ) ) otherlv_15= ',' )*";
        }
    }

    class DFA30 extends DFA {

        public DFA30(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 30;
            this.eot = dfa_7;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "()* loopback of 1033:5: ( ( (lv_attributes_22_0= ruleAttribute ) ) otherlv_23= ',' )*";
        }
    }
    static final String dfa_14s = "\6\uffff";
    static final String dfa_15s = "\1\uffff\1\4\3\uffff\1\4";
    static final String dfa_16s = "\3\4\2\uffff\1\4";
    static final String dfa_17s = "\1\4\1\73\1\4\2\uffff\1\73";
    static final String dfa_18s = "\3\uffff\1\1\1\2\1\uffff";
    static final String dfa_19s = "\6\uffff}>";
    static final String[] dfa_20s = {
            "\1\1",
            "\1\4\15\uffff\1\3\10\uffff\2\4\25\uffff\1\4\10\uffff\1\2",
            "\1\5",
            "",
            "",
            "\1\4\15\uffff\1\3\10\uffff\2\4\25\uffff\1\4\10\uffff\1\2"
    };

    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final short[] dfa_15 = DFA.unpackEncodedString(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final char[] dfa_17 = DFA.unpackEncodedStringToUnsignedChars(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[] dfa_19 = DFA.unpackEncodedString(dfa_19s);
    static final short[][] dfa_20 = unpackEncodedStringArray(dfa_20s);

    class DFA42 extends DFA {

        public DFA42(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 42;
            this.eot = dfa_14;
            this.eof = dfa_15;
            this.min = dfa_16;
            this.max = dfa_17;
            this.accept = dfa_18;
            this.special = dfa_19;
            this.transition = dfa_20;
        }
        public String getDescription() {
            return "()* loopback of 1663:3: ( ( (lv_controller_2_0= ruleController ) ) otherlv_3= ',' )*";
        }
    }
    static final String dfa_21s = "\3\uffff\1\10\1\uffff\1\11\5\uffff";
    static final String dfa_22s = "\1\4\2\uffff\1\14\1\uffff\1\14\5\uffff";
    static final String dfa_23s = "\1\114\2\uffff\1\111\1\uffff\1\111\5\uffff";
    static final String dfa_24s = "\1\uffff\1\1\1\2\1\uffff\1\5\1\uffff\1\7\1\3\1\4\1\10\1\6";
    static final String[] dfa_25s = {
            "\1\5\1\3\1\6\37\uffff\1\4\44\uffff\1\1\1\2",
            "",
            "",
            "\1\10\5\uffff\2\10\17\uffff\1\10\16\uffff\1\10\10\uffff\1\7\1\uffff\15\10",
            "",
            "\1\11\4\uffff\1\12\2\11\17\uffff\1\11\16\uffff\1\11\10\uffff\1\11\1\uffff\15\11",
            "",
            "",
            "",
            "",
            ""
    };
    static final short[] dfa_21 = DFA.unpackEncodedString(dfa_21s);
    static final char[] dfa_22 = DFA.unpackEncodedStringToUnsignedChars(dfa_22s);
    static final char[] dfa_23 = DFA.unpackEncodedStringToUnsignedChars(dfa_23s);
    static final short[] dfa_24 = DFA.unpackEncodedString(dfa_24s);
    static final short[][] dfa_25 = unpackEncodedStringArray(dfa_25s);

    class DFA61 extends DFA {

        public DFA61(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 61;
            this.eot = dfa_7;
            this.eof = dfa_21;
            this.min = dfa_22;
            this.max = dfa_23;
            this.accept = dfa_24;
            this.special = dfa_12;
            this.transition = dfa_25;
        }
        public String getDescription() {
            return "3472:2: ( ( () ( (lv_value_1_0= 'true' ) ) ) | ( () ( (lv_value_3_0= 'false' ) ) ) | ( () ( (lv_value_5_0= ruleDouble ) ) ) | ( () ( (lv_value_7_0= RULE_INT ) ) ) | ( () ( (lv_value_9_0= ruleDate ) ) ) | ( () ( (otherlv_11= RULE_ID ) ) otherlv_12= '(' ( (otherlv_13= RULE_ID ) ) otherlv_14= ')' ) | ( () ( (lv_value_16_0= RULE_STRING ) ) ) | ( () ( (lv_value_18_0= ruleVariableDotExpression ) ) ) )";
        }
    }
    static final String dfa_26s = "\17\uffff";
    static final String dfa_27s = "\1\145\2\21\1\uffff\1\21\1\uffff\3\63\6\uffff";
    static final String dfa_28s = "\1\151\2\21\1\uffff\1\21\1\uffff\3\152\6\uffff";
    static final String dfa_29s = "\3\uffff\1\3\1\uffff\1\5\3\uffff\1\6\1\1\1\2\1\7\1\10\1\4";
    static final String dfa_30s = "\17\uffff}>";
    static final String[] dfa_31s = {
            "\1\1\1\2\1\3\1\4\1\5",
            "\1\6",
            "\1\7",
            "",
            "\1\10",
            "",
            "\1\12\66\uffff\1\11",
            "\1\13\66\uffff\1\14",
            "\1\16\66\uffff\1\15",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_26 = DFA.unpackEncodedString(dfa_26s);
    static final char[] dfa_27 = DFA.unpackEncodedStringToUnsignedChars(dfa_27s);
    static final char[] dfa_28 = DFA.unpackEncodedStringToUnsignedChars(dfa_28s);
    static final short[] dfa_29 = DFA.unpackEncodedString(dfa_29s);
    static final short[] dfa_30 = DFA.unpackEncodedString(dfa_30s);
    static final short[][] dfa_31 = unpackEncodedStringArray(dfa_31s);

    class DFA75 extends DFA {

        public DFA75(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 75;
            this.eot = dfa_26;
            this.eof = dfa_26;
            this.min = dfa_27;
            this.max = dfa_28;
            this.accept = dfa_29;
            this.special = dfa_30;
            this.transition = dfa_31;
        }
        public String getDescription() {
            return "4821:2: ( ( () ( (lv_action_1_0= 'Suspended' ) ) otherlv_2= '(' otherlv_3= 'obligations.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' ) | ( () ( (lv_action_7_0= 'Resumed' ) ) otherlv_8= '(' otherlv_9= 'obligations.' ( (otherlv_10= RULE_ID ) ) otherlv_11= ')' ) | ( () ( (lv_action_13_0= 'Discharged' ) ) otherlv_14= '(' otherlv_15= 'obligations.' ( (otherlv_16= RULE_ID ) ) otherlv_17= ')' ) | ( () ( (lv_action_19_0= 'Terminated' ) ) otherlv_20= '(' otherlv_21= 'obligations.' ( (otherlv_22= RULE_ID ) ) otherlv_23= ')' ) | ( () ( (lv_action_25_0= 'Triggered' ) ) otherlv_26= '(' otherlv_27= 'obligations.' ( (otherlv_28= RULE_ID ) ) otherlv_29= ')' ) | ( () ( (lv_action_31_0= 'Suspended' ) ) otherlv_32= '(' ( (lv_norm_33_0= 'self' ) ) otherlv_34= ')' ) | ( () ( (lv_action_36_0= 'Resumed' ) ) otherlv_37= '(' ( (lv_norm_38_0= 'self' ) ) otherlv_39= ')' ) | ( () ( (lv_action_41_0= 'Terminated' ) ) otherlv_42= '(' ( (lv_norm_43_0= 'self' ) ) otherlv_44= ')' ) )";
        }
    }
    static final String dfa_32s = "\5\uffff\1\13\2\uffff\1\15\6\uffff";
    static final String dfa_33s = "\1\4\4\uffff\1\14\2\uffff\1\14\6\uffff";
    static final String dfa_34s = "\1\167\4\uffff\1\140\2\uffff\1\140\6\uffff";
    static final String dfa_35s = "\1\uffff\1\1\1\2\1\3\1\4\1\uffff\1\7\1\10\1\uffff\1\13\1\14\1\6\1\5\1\12\1\11";
    static final String[] dfa_36s = {
            "\1\5\1\10\1\11\12\uffff\1\1\24\uffff\1\12\43\uffff\1\2\1\6\1\7\36\uffff\12\3\3\4",
            "",
            "",
            "",
            "",
            "\1\13\4\uffff\1\14\2\13\47\uffff\1\13\1\uffff\15\13\26\uffff\1\13",
            "",
            "",
            "\1\15\5\uffff\2\15\47\uffff\1\16\1\uffff\15\15\26\uffff\1\15",
            "",
            "",
            "",
            "",
            "",
            ""
    };
    static final short[] dfa_32 = DFA.unpackEncodedString(dfa_32s);
    static final char[] dfa_33 = DFA.unpackEncodedStringToUnsignedChars(dfa_33s);
    static final char[] dfa_34 = DFA.unpackEncodedStringToUnsignedChars(dfa_34s);
    static final short[] dfa_35 = DFA.unpackEncodedString(dfa_35s);
    static final short[][] dfa_36 = unpackEncodedStringArray(dfa_36s);

    class DFA84 extends DFA {

        public DFA84(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 84;
            this.eot = dfa_26;
            this.eof = dfa_32;
            this.min = dfa_33;
            this.max = dfa_34;
            this.accept = dfa_35;
            this.special = dfa_30;
            this.transition = dfa_36;
        }
        public String getDescription() {
            return "5666:2: ( ( () otherlv_1= '(' ( (lv_inner_2_0= ruleProposition ) ) otherlv_3= ')' ) | ( () otherlv_5= 'not' ( (lv_negated_6_0= rulePAtomicExpression ) ) ) | ( () ( (lv_predicateFunction_8_0= rulePredicateFunction ) ) ) | ( () ( (lv_function_10_0= ruleOtherFunction ) ) ) | ( () ( (otherlv_12= RULE_ID ) ) otherlv_13= '(' ( (otherlv_14= RULE_ID ) ) otherlv_15= ')' ) | ( () ( (lv_variable_17_0= ruleVariableDotExpression ) ) ) | ( () ( (lv_value_19_0= 'true' ) ) ) | ( () ( (lv_value_21_0= 'false' ) ) ) | ( () ( (lv_value_23_0= ruleDouble ) ) ) | ( () ( (lv_value_25_0= RULE_INT ) ) ) | ( () ( (lv_value_27_0= RULE_STRING ) ) ) | ( () ( (lv_value_29_0= ruleDate ) ) ) )";
        }
    }
    static final String dfa_37s = "\1\uffff\1\13\15\uffff";
    static final String dfa_38s = "\2\4\4\21\1\uffff\2\21\4\uffff\2\63";
    static final String dfa_39s = "\1\u0080\1\73\4\21\1\uffff\2\21\4\uffff\1\64\1\152";
    static final String dfa_40s = "\6\uffff\1\2\2\uffff\1\3\1\4\1\1\1\5\2\uffff";
    static final String[] dfa_41s = {
            "\1\1\140\uffff\1\4\1\5\1\6\1\10\1\2\16\uffff\1\3\1\12\1\7\2\6\4\11",
            "\1\14\15\uffff\2\13\47\uffff\1\13",
            "\1\15",
            "\1\16",
            "\1\16",
            "\1\16",
            "",
            "\1\15",
            "\1\16",
            "",
            "",
            "",
            "",
            "\1\6\1\12",
            "\1\6\1\12\65\uffff\1\11"
    };
    static final short[] dfa_37 = DFA.unpackEncodedString(dfa_37s);
    static final char[] dfa_38 = DFA.unpackEncodedStringToUnsignedChars(dfa_38s);
    static final char[] dfa_39 = DFA.unpackEncodedStringToUnsignedChars(dfa_39s);
    static final short[] dfa_40 = DFA.unpackEncodedString(dfa_40s);
    static final short[][] dfa_41 = unpackEncodedStringArray(dfa_41s);

    class DFA91 extends DFA {

        public DFA91(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 91;
            this.eot = dfa_26;
            this.eof = dfa_37;
            this.min = dfa_38;
            this.max = dfa_39;
            this.accept = dfa_40;
            this.special = dfa_30;
            this.transition = dfa_41;
        }
        public String getDescription() {
            return "7025:2: (this_VariableEvent_0= ruleVariableEvent | this_ObligationEvent_1= ruleObligationEvent | this_ContractEvent_2= ruleContractEvent | this_PowerEvent_3= rulePowerEvent | this_DataTransfer_4= ruleDataTransfer )";
        }
    }
    static final String dfa_42s = "\15\uffff";
    static final String dfa_43s = "\1\4\1\uffff\4\21\1\uffff\2\21\2\uffff\2\63";
    static final String dfa_44s = "\1\u0080\1\uffff\4\21\1\uffff\2\21\2\uffff\1\64\1\152";
    static final String dfa_45s = "\1\uffff\1\1\4\uffff\1\2\2\uffff\1\3\1\4\2\uffff";
    static final String dfa_46s = "\15\uffff}>";
    static final String[] dfa_47s = {
            "\1\1\140\uffff\1\4\1\5\1\6\1\10\1\2\16\uffff\1\3\1\12\1\7\2\6\4\11",
            "",
            "\1\13",
            "\1\14",
            "\1\14",
            "\1\14",
            "",
            "\1\13",
            "\1\14",
            "",
            "",
            "\1\6\1\12",
            "\1\6\1\12\65\uffff\1\11"
    };

    static final short[] dfa_42 = DFA.unpackEncodedString(dfa_42s);
    static final char[] dfa_43 = DFA.unpackEncodedStringToUnsignedChars(dfa_43s);
    static final char[] dfa_44 = DFA.unpackEncodedStringToUnsignedChars(dfa_44s);
    static final short[] dfa_45 = DFA.unpackEncodedString(dfa_45s);
    static final short[] dfa_46 = DFA.unpackEncodedString(dfa_46s);
    static final short[][] dfa_47 = unpackEncodedStringArray(dfa_47s);

    class DFA96 extends DFA {

        public DFA96(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 96;
            this.eot = dfa_42;
            this.eof = dfa_42;
            this.min = dfa_43;
            this.max = dfa_44;
            this.accept = dfa_45;
            this.special = dfa_46;
            this.transition = dfa_47;
        }
        public String getDescription() {
            return "7803:2: ( ( () ( (lv_variable_1_0= ruleVariableDotExpression ) ) ) | ( () ( (lv_obligationEvent_3_0= ruleObligationEvent ) ) ) | ( () ( (lv_contractEvent_5_0= ruleContractEvent ) ) ) | ( () ( (lv_powerEvent_7_0= rulePowerEvent ) ) ) )";
        }
    }
    static final String dfa_48s = "\1\u0089\1\21\1\uffff\4\21\1\uffff\1\21\2\63\1\64\1\uffff";
    static final String dfa_49s = "\1\u0094\1\21\1\uffff\4\21\1\uffff\1\21\1\64\2\152\1\uffff";
    static final String dfa_50s = "\2\uffff\1\1\4\uffff\1\2\4\uffff\1\3";
    static final String[] dfa_51s = {
            "\1\1\1\6\1\3\1\4\1\5\1\10\3\2\3\7",
            "\1\11",
            "",
            "\1\12",
            "\1\12",
            "\1\12",
            "\1\12",
            "",
            "\1\13",
            "\1\2\1\14",
            "\1\2\1\14\65\uffff\1\7",
            "\1\14\65\uffff\1\7",
            ""
    };
    static final char[] dfa_48 = DFA.unpackEncodedStringToUnsignedChars(dfa_48s);
    static final char[] dfa_49 = DFA.unpackEncodedStringToUnsignedChars(dfa_49s);
    static final short[] dfa_50 = DFA.unpackEncodedString(dfa_50s);
    static final short[][] dfa_51 = unpackEncodedStringArray(dfa_51s);

    class DFA100 extends DFA {

        public DFA100(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 100;
            this.eot = dfa_42;
            this.eof = dfa_42;
            this.min = dfa_48;
            this.max = dfa_49;
            this.accept = dfa_50;
            this.special = dfa_46;
            this.transition = dfa_51;
        }
        public String getDescription() {
            return "8219:2: (this_ObligationState_0= ruleObligationState | this_ContractState_1= ruleContractState | this_PowerState_2= rulePowerState )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x00000000000000FEL});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000F00000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000E00010L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000004000C20070L,0x00FFF80000001C00L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000004000820070L,0x00FFF80000001C00L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x000000001F800010L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x000000001E000010L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x000000001C000010L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000018000010L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000004010020070L,0x00FFF80000001C00L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x000000F000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x00000F0000010000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0200000100000002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0400000000000010L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x000000F000000010L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000C00000002L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000004000020070L,0x00FFF800FFFFFC00L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000C00000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x01E0000000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x04180F0100010010L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x2000000000000002L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x8000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000002L,0x000000000000001EL});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000060L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000380L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000004000020070L,0x00FFF80600001C00L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000000L,0x0000000600000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000004000020070L,0x00FFF80000001C00L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000004000020070L,0x00FFF81800001C00L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000000L,0x0000001800000000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000000L,0x000003E000000000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000000L,0x0000040000000000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000000002L,0x00000000000003E0L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000010L,0xFF0003E000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000000010L,0xFF0003E080000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x00000000001FFF00L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000081000L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000000000030L});

}