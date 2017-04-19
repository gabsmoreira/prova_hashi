package br.pro.hashi.ensino.desagil.lucianogic.model;

public class HalfGate extends Gate{
	private Emitter a;
	private Emitter b;
	private AndGate andGate;
	private XorGate xorGate;

	public HalfGate() {
		super(2, 2);
		name = "HALF";
		andGate = new AndGate();
		xorGate = new XorGate();
		
	}

	@Override
	public boolean doRead(int index) {
		if (index == 0){
			return xorGate.read() ;
		}
		else {
			return andGate.read() ;
			}
	}

	@Override
	protected void doConnect(Emitter emitter, int index) {
		switch(index) {
		case 0:
			a = emitter;
			
			andGate.connect(a, 0);
			xorGate.connect(a, 0);
			break;
		case 1:
			b = emitter;
			andGate.connect(b, 1);
			xorGate.connect(b, 1);
			break;
		}
	}
}


