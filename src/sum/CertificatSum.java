package sum;

import binpack.CertificatBinPack;
import binpack.PblBinPack;
import binpack.Sac;

public class CertificatSum extends CertificatBinPack {

	public CertificatSum(PblBinPack binPack) {
		super(binPack);
	}
	
	@Override
	public boolean estCorrect() {
		this.viderSacs();
		this.ajouterObjetsDansSacs();
		for(Sac sac : this.getBinPack().getSacs()) {
			if(sac.getPoids() == sac.getCapacite())
				return true;
		}
		return false;
	}

}
