package br.com.javac.nfeapplet.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;

import br.com.javac.nfeapplet.controller.NFeController;
import javax.swing.JProgressBar;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;

public class NFe extends JApplet {
	private static final long serialVersionUID = -6226458876764970599L;
	
	private NFeController controller;
	@SuppressWarnings("rawtypes")
	private JList listaCertificados;
	private JTextArea textInformacao;
	private JProgressBar progressBarStatus;
	private JButton btnConsultarStatusServico;
	private JButton btnDadosDoCertificado;
	private JButton btnListarCertificados;
	private JPasswordField edtSenhaDoCertificado;
	private final ButtonGroup btgAssinatura = new ButtonGroup();
	private JRadioButton rbtLoteNfe;
	private JRadioButton rbtCancelamento;
	private JRadioButton rbtInutilizacao;
	private JRadioButton rbtCce;
	private JRadioButton rbtDpec;
	private JButton btnAssinatura;

	/**
	 * Create the applet.
	 */
	@SuppressWarnings("rawtypes")
	public NFe() {
		try {
			UIManager.setLookAndFeel(
			        UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {}

		JPanel panelCentro = new JPanel();
		panelCentro.setBackground(Color.WHITE);
		getContentPane().add(panelCentro, BorderLayout.CENTER);
		
		listaCertificados = new JList();
		listaCertificados.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JLabel lblCerticados = new JLabel("Certificados Instalados:");
		
		btnListarCertificados = new JButton("Listar Certificados");
		btnListarCertificados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getController().listaCerticados();
			}
		});
		
		JLabel lblInformaes = new JLabel("Informa\u00E7\u00F5es:");
		
		btnConsultarStatusServico = new JButton("Consultar Status do Servi\u00E7o SEFAZ");
		btnConsultarStatusServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getController().consultaStatusDoServico();
			}
		});
		
		btnDadosDoCertificado = new JButton("Dados do Certificado");
		btnDadosDoCertificado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getController().dadosDoCertificado();
			}
		});
		
		progressBarStatus = new JProgressBar();
		progressBarStatus.setStringPainted(true);
		
		edtSenhaDoCertificado = new JPasswordField();
		
		JLabel lblNewLabel = new JLabel("Senha do Certificado:");
		
		rbtLoteNfe = new JRadioButton("Lote NF-e;");
		rbtLoteNfe.setSelected(true);
		rbtLoteNfe.setBackground(Color.WHITE);
		btgAssinatura.add(rbtLoteNfe);
		
		rbtCancelamento = new JRadioButton("Cancelamento;");
		rbtCancelamento.setBackground(Color.WHITE);
		btgAssinatura.add(rbtCancelamento);
		
		rbtInutilizacao = new JRadioButton("Inutiliza\u00E7\u00E3o;");
		btgAssinatura.add(rbtInutilizacao);
		rbtInutilizacao.setBackground(Color.WHITE);
		
		rbtCce = new JRadioButton("Carta de Corre\u00E7\u00E3o Eletr\u00F4nica (CC-e);");
		btgAssinatura.add(rbtCce);
		rbtCce.setBackground(Color.WHITE);
		
		rbtDpec = new JRadioButton("DPEC;");
		btgAssinatura.add(rbtDpec);
		rbtDpec.setBackground(Color.WHITE);
		
		btnAssinatura = new JButton("Assinar XML");
		btnAssinatura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getController().assinarXml();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panelCentro = new GroupLayout(panelCentro);
		gl_panelCentro.setHorizontalGroup(
			gl_panelCentro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCentro.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelCentro.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panelCentro.createSequentialGroup()
							.addComponent(rbtLoteNfe)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rbtCancelamento)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rbtInutilizacao)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rbtCce)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rbtDpec)
							.addGap(85))
						.addGroup(Alignment.TRAILING, gl_panelCentro.createSequentialGroup()
							.addComponent(lblCerticados, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
							.addGap(386))
						.addGroup(Alignment.TRAILING, gl_panelCentro.createSequentialGroup()
							.addGroup(gl_panelCentro.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panelCentro.createSequentialGroup()
									.addComponent(btnConsultarStatusServico)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnDadosDoCertificado)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnListarCertificados, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_panelCentro.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(edtSenhaDoCertificado, GroupLayout.PREFERRED_SIZE, 435, GroupLayout.PREFERRED_SIZE))
								.addComponent(listaCertificados, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_panelCentro.createSequentialGroup()
							.addComponent(lblInformaes, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
							.addGap(488))
						.addGroup(Alignment.TRAILING, gl_panelCentro.createSequentialGroup()
							.addGroup(gl_panelCentro.createParallelGroup(Alignment.TRAILING)
								.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
								.addComponent(btnAssinatura, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
								.addComponent(progressBarStatus, GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE))
							.addGap(63))))
		);
		gl_panelCentro.setVerticalGroup(
			gl_panelCentro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCentro.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCerticados)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(listaCertificados, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelCentro.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(edtSenhaDoCertificado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelCentro.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnConsultarStatusServico)
						.addComponent(btnDadosDoCertificado)
						.addComponent(btnListarCertificados))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelCentro.createParallelGroup(Alignment.BASELINE)
						.addComponent(rbtLoteNfe)
						.addComponent(rbtCancelamento)
						.addComponent(rbtInutilizacao)
						.addComponent(rbtCce)
						.addComponent(rbtDpec))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAssinatura)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(progressBarStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblInformaes)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		textInformacao = new JTextArea();
		scrollPane.setViewportView(textInformacao);
		textInformacao.setWrapStyleWord(true);
		textInformacao.setLineWrap(true);
		textInformacao.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelCentro.setLayout(gl_panelCentro);

	}

	public NFeController getController() {
		synchronized (NFeController.class) {
			if (controller == null) {
				controller = new NFeController(this);
			}
		}
		return controller;
	}
	
	@SuppressWarnings("rawtypes")
	public JList getListaCertificados() {
		return listaCertificados;
	}
	public JTextArea getTextInformacao() {
		return textInformacao;
	}
	public JProgressBar getProgressBarStatus() {
		return progressBarStatus;
	}
	public JButton getBtnConsultarStatusServico() {
		return btnConsultarStatusServico;
	}
	public JButton getBtnDadosDoCertificado() {
		return btnDadosDoCertificado;
	}
	public JButton getBtnListarCertificados() {
		return btnListarCertificados;
	}
	public JPasswordField getEdtSenhaDoCertificado() {
		return edtSenhaDoCertificado;
	}
	public JRadioButton getRbtLoteNfe() {
		return rbtLoteNfe;
	}
	public JRadioButton getRbtCancelamento() {
		return rbtCancelamento;
	}
	public JRadioButton getRbtInutilizacao() {
		return rbtInutilizacao;
	}
	public JRadioButton getRbtCce() {
		return rbtCce;
	}
	public JRadioButton getRbtDpec() {
		return rbtDpec;
	}
	public JButton getBtnAssinatura() {
		return btnAssinatura;
	}
}
