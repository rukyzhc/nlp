package net.zhanghc.nlp.data.postag;

public enum PennTreeCN {
	VA, VC, VE, VV,
	NR, NT, NN,
	LC,
	PN,
	DT, CD, OD,
	M,
	AD,
	P,
	CC, CS,
	DEC, DEG, DER, DEV, AS, SP, ETC, MSP,
	IJ, ON, LB, SB, BA, JJ, FW, PU;

	public BuiltInCN toNative() {
		switch(this) {
		case NR:
			return BuiltInCN.NR;
		case NT:
			return BuiltInCN.T;
		case NN:
			return BuiltInCN.N;
		case VC:
			return BuiltInCN.VSHI;
		case VE:
			return BuiltInCN.VYOU;
		case VV:
			return BuiltInCN.V;
		case VA:
			return BuiltInCN.A;
		case AD:
			return BuiltInCN.D;
		case JJ:
			return BuiltInCN.J;
		case LC:
			return BuiltInCN.F;
		case PN:
			return BuiltInCN.R;
		case DT:
			return BuiltInCN.RZ;
		case M: 
			return BuiltInCN.Q;
		case CD:
		case OD:
			return BuiltInCN.M;
		case P: 
			return BuiltInCN.P;
		case CC: 
			return BuiltInCN.CC;
		case CS: 
			return BuiltInCN.C;
		case DEC: 
		case DEG: 
			return BuiltInCN.UDE1;
		case DEV: 
			return BuiltInCN.UDE2;
		case DER: 
			return BuiltInCN.UDE3;
		case AS:
			return BuiltInCN.UA;
		case SP:
			return BuiltInCN.Y;
		case ETC:
			return BuiltInCN.UETC;
		case MSP:
			return BuiltInCN.UO;
		case IJ:
			return BuiltInCN.E; 
		case ON:
			return BuiltInCN.O;
		case LB:
		case SB:
			return BuiltInCN.PBEI;
		case BA:
			return BuiltInCN.PBA;
		case PU:
			return BuiltInCN.W;
		case FW:
			return BuiltInCN.X;
		default:
			return BuiltInCN.X;
		}
	}
	
	public static PennTreeCN fromNative(BuiltInCN pos) {
		switch(pos) {
		case N:
		case NZ:
		case G: //FIXME
			return PennTreeCN.NN;
		case NR:
			return PennTreeCN.NR;
		case V:
		case VI:
			return PennTreeCN.VV;
		case VSHI:
			return PennTreeCN.VC;
		case VYOU:
			return PennTreeCN.VE;
		case A:
			return PennTreeCN.VA;
		case J:
			return PennTreeCN.JJ;
		case D:
			return PennTreeCN.AD;
		case F:
			return PennTreeCN.LC;
		case R:
		case RR:
			return PennTreeCN.PN;
		case RZ:
			return PennTreeCN.DT;
		case M:
			return PennTreeCN.CD;
		case Q:
			return PennTreeCN.M;
		case P:
			return PennTreeCN.P;
		case PBA:
			return PennTreeCN.BA;
		case PBEI:
			return PennTreeCN.SB;
		case C:
			return PennTreeCN.CS;
		case CC:
			return PennTreeCN.CC;
		case T:
			return PennTreeCN.NT;
		case UA:
			return PennTreeCN.AS;
		case UDE1:
			return PennTreeCN.DEC;
		case UDE2:
			return PennTreeCN.DEV;
		case UDE3:
			return PennTreeCN.DER;
		case UETC:
			return PennTreeCN.ETC;
		case Y:
			return PennTreeCN.SP;
		case E:
			return PennTreeCN.IJ;
		case O:
			return PennTreeCN.ON;
		case W:
			return PennTreeCN.PU;
		case I:
			return PennTreeCN.NN;
		case U:
		case UO:
		case X:
		default:
			return PennTreeCN.MSP;
		}
	}

}
