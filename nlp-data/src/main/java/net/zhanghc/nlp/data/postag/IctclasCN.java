package net.zhanghc.nlp.data.postag;

public enum IctclasCN {
	N, NR, NS, NT, NZ, NL, NG, NR1, NR2, NRJ, NRF, NSF,
	T, TG,
	S,
	F,
	V, VD, VN, VSHI, VYOU, VF, VX, VI, VL, VG,
	A, AD, AN, AG, AL,
	B, BL,
	Z,
	R, RR, RZ, RY, RG, RZT, RZS, RZV, RYT, RYS, RYV,
	M, MG, MQ, Q, QV, QT,
	D, DL, DG,
	P, PBA, PBEI,
	C, CC,
	U, UZHE, ULE, UGUO, UDE1, UDE2, UDE3, USUO, UDENG, UYY, UDH, ULS, UZHI, ULIAN, 
	E, Y, O,
	H, K, 
	X, XX, XU, URL, EMAIL,
	W, WKZ, WKY, WYZ, WYY, WJ, WW, WT, WD, WF, WN, WM, WS, WP, WB, WH,
	N_NEW;

	public BuiltInCN toNative() {
		switch(this) {
		case N:
			return BuiltInCN.N;
		case NR:
		case NR1:
		case NR2:
			return BuiltInCN.NR;
		case NS:
		case NT:
		case NZ:
		case NL:
		case NRJ:
		case NRF:
		case NSF:
			return BuiltInCN.NZ;
		case T:
			return BuiltInCN.T;
		case NG:
		case TG:
		case VG:
		case AG:
		case RG:
		case DG:
		case MG:
		case K:
		case H:
			return BuiltInCN.G;
		case S:
		case F:
			return BuiltInCN.F;
		case B:
		case BL:
		case Z:
			return BuiltInCN.J;
		case V:
		case VD:
		case VN:
		case VF:
		case VX:
		case VL:
			return BuiltInCN.V;
		case VI:
			return BuiltInCN.VI;
		case VSHI:
			return BuiltInCN.VSHI;
		case VYOU:
			return BuiltInCN.VYOU;
		case A:
		case AD:
		case AN:
		case AL:
			return BuiltInCN.A;
		case R:
		case RY:
		case RYT:
		case RYS:
		case RYV:
			return BuiltInCN.R;
		case RZ:
		case RZT: 
		case RZS: 
		case RZV:
			return BuiltInCN.RZ;
		case RR:
			return BuiltInCN.RR;
		case M:
			return BuiltInCN.M;
		case MQ:
		case Q:
		case QV:
		case QT:
			return BuiltInCN.Q;
		case D:
		case DL:
			return BuiltInCN.D;
		case P:
			return BuiltInCN.P;
		case PBA:
			return BuiltInCN.PBA;
		case PBEI:
			return BuiltInCN.PBEI;
		case C:
			return BuiltInCN.C;
		case CC:
			return BuiltInCN.CC;
		case U: 
			return BuiltInCN.U;
		case UZHE:
		case ULE:
		case UGUO: 
			return BuiltInCN.UA;
		case UDE1:
			return BuiltInCN.UDE1;
		case UDE2:
			return BuiltInCN.UDE2;
		case UDE3:
			return BuiltInCN.UDE3;
		case UDENG:
			return BuiltInCN.UETC;
		case USUO:
		case UYY:
		case UDH:
		case ULS:
		case UZHI:
		case ULIAN:
			return BuiltInCN.UO;
		case E:
			return BuiltInCN.E;
		case Y:
			return BuiltInCN.Y;
		case O:
			return BuiltInCN.O;
		case X:
		case XX:
		case XU:
		case URL:
			return BuiltInCN.X;
		case W:
		case WKZ:
		case WKY:
		case WYZ:
		case WYY:
		case WJ:
		case WW:
		case WT:
		case WD:
		case WF:
		case WN:
		case WM:
		case WS:
		case WP:
		case WB:
		case WH:
			return BuiltInCN.W;
		case N_NEW:
			return BuiltInCN.I;
		default:
			return BuiltInCN.X;
		}
	}

	public static IctclasCN fromNative(BuiltInCN pos) {
		switch(pos) {
		case N:
		case NR:
		case NZ:
		case V:
		case VSHI:
		case VYOU:
		case VI:
		case A:
		case J:
		case D:
		case F:
		case G:
		case R:
		case RR:
		case RZ:
		case M:
		case Q:
		case P:
		case PBA:
		case PBEI:
		case C:
		case CC:
		case T:
		case U:
		case UA:
		case UDE1:
		case UDE2:
		case UDE3:
		case UETC:
		case UO:
		case Y:
		case E:
		case O:
		case W:
		case I:
		case X:
		default:
			return IctclasCN.X;
		}
	}
}
