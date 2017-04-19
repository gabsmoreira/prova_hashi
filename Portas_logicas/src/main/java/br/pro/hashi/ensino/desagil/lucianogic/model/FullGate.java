package br.pro.hashi.ensino.desagil.lucianogic.model;

public class FullGate extends Gate {
	private Emitter a;
	private Emitter b;
	private Emitter c;
	private AndGate andGate_0;
	private XorGate xorGate_0;
	private AndGate andGate_1;
	private XorGate xorGate_1;
	private OrGate orGate;

	public FullGate() {
		super(3,2);
		name = "FULL";
		andGate_0 = new AndGate();
		xorGate_0 = new XorGate();
		andGate_1 = new AndGate();
		xorGate_1 = new XorGate();
		orGate = new OrGate();
		
	}

	@Override
	public boolean doRead(int index) {
		if (index == 0){
			return xorGate_1.read() ;
		}
		else {
			return orGate.read() ;
			}
	}

	@Override
	protected void doConnect(Emitter emitter, int index) {
		switch(index) {
		case 0:
			a = emitter;
			xorGate_0.connect(a, 0);
			xorGate_1.connect(xorGate_0, 0);
			andGate_0.connect(xorGate_0, 0);
			andGate_1.connect(a, 0);
			orGate.connect(andGate_0, 0);
			orGate.connect(andGate_1, 1);
			break;
		case 1:
			b = emitter;
			xorGate_0.connect(b, 1);
			xorGate_1.connect(xorGate_0, 0);
			andGate_0.connect(xorGate_0, 0);
			andGate_1.connect(b, 1);
			orGate.connect(andGate_0, 0);
			orGate.connect(andGate_1, 1);
			
			break;
		case 2:
			c = emitter;
			xorGate_1.connect(c, 1);
			andGate_0.connect(c, 1);
			orGate.connect(andGate_0, 0);
			break;
		}
	}
}
