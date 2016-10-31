// Draw.cpp : implementation file
//

#include "stdafx.h"
#include "Cassiopeia_313751158.h"

#include <math.h>
#include "Draw.h"
#include "MainFrm.h"
#include "MenuAll.h"
#include "Statistics.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CDraw

IMPLEMENT_DYNCREATE(CDraw, CFormView)

CDraw::CDraw()
	: CFormView(CDraw::IDD)
{
	//{{AFX_DATA_INIT(CDraw)
		// NOTE: the ClassWizard will add member initialization here
	//}}AFX_DATA_INIT
}

CDraw::~CDraw()
{
}

void CDraw::DoDataExchange(CDataExchange* pDX)
{
	CFormView::DoDataExchange(pDX);
	//{{AFX_DATA_MAP(CDraw)
		// NOTE: the ClassWizard will add DDX and DDV calls here
	//}}AFX_DATA_MAP
}


BEGIN_MESSAGE_MAP(CDraw, CFormView)
	//{{AFX_MSG_MAP(CDraw)
	ON_BN_CLICKED(IDC_BUTTON1, OnButton1)
	ON_BN_CLICKED(IDC_BUTTON2, OnButton2)
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CDraw diagnostics

#ifdef _DEBUG
void CDraw::AssertValid() const
{
	CFormView::AssertValid();
}

void CDraw::Dump(CDumpContext& dc) const
{
	CFormView::Dump(dc);
}
#endif //_DEBUG

/////////////////////////////////////////////////////////////////////////////
// CDraw message handlers

void CDraw::OnDraw(CDC* pDC) 
{

//	CString su;
//	su.Format("%lf",sumOut);
//	MessageBox(su);
	// TODO: Add your specialized code here and/or call the base class

	double per;
	sumOut=sumOut*(-1);
	per=sumOut/haveN;

	CPen* pOldPen=NULL;
	CBrush brush1,brush2;
	CBrush* pOldBrush=NULL;

	CPen penWhite;
	penWhite.CreatePen(PS_DOT,1,RGB(255,255,255));
		
	pOldPen = pDC->SelectObject(&penWhite);  //虚线的椭圆

	brush1.CreateSolidBrush( RGB(252,117,111) ); //实心画刷
	brush2.CreateHatchBrush(HS_BDIAGONAL, RGB(255,0,0) );  //斜线填充

	pOldBrush = pDC->SelectObject(&brush1);  //虚线的椭圆

  //pDC->Rectangle(620,30,750,130);
	pDC->SelectObject(pOldPen);
	penWhite.DeleteObject();
	///////////////////////////////////////

	CPen pen1;
	pen1.CreatePen(PS_SOLID,1,RGB(88,88,88));
	pOldPen=pDC->SelectObject(&pen1);
	pDC->Ellipse(100,100,400,400);

//	pDC->SelectObject(pOldPen);

	pOldBrush=pDC->SelectObject(&brush2);


	//Pie表示收入
	if (sumOut<=haveN*0.125)
	{
		pDC->Pie(100,100,400,400,250,100,(double)((double)250-(double)150*(double)(tan(2*3.14*per))),100);
	}
	if ((sumOut>haveN*0.125)&&(sumOut<=haveN*0.25))
	{
		pDC->Pie(100,100,400,400,250,100,100,(double)250-(double)150/(double)(tan(2*3.14*per)));
	}
	if ((sumOut>haveN*0.25)&&(sumOut<=haveN*0.375))
	{
		pDC->Pie(100,100,400,400,250,100,100,(double)250+(double)150/(double)(tan(3.14-2*3.14*per)));
	}
	if ((sumOut>haveN*0.325)&&(sumOut<=haveN*0.5))
	{
		pDC->Pie(100,100,400,400,250,100,(double)((double)250-(double)150*(double)(tan(3.14-2*3.14*per))),400);
	}


	if ((sumOut>haveN*0.5)&&(sumOut<=haveN*0.625))
	{
		pDC->Pie(100,100,400,400,250,100,(double)((double)250+(double)150*(double)(tan(2*3.14*per-3.14))),400);
	}
	if ((sumOut>haveN*0.625)&&(sumOut<=haveN*0.75))
	{
		pDC->Pie(100,100,400,400,250,100,400,(double)((double)250+(double)150*(double)(tan(4.71-2*3.14*per))));
	}
	if ((sumOut>haveN*0.75)&&(sumOut<=haveN*0.875))
	{
		pDC->Pie(100,100,400,400,250,100,400,(double)((double)250-(double)150*(double)(tan(2*3.14*per-4.71))));
	}
	if ((sumOut>haveN*0.875)&&(sumOut<=haveN))
	{
		pDC->Pie(100,100,400,400,250,100,(double)((double)250+(double)150*(double)(tan(6.28-2*3.14*per))),100);
	}


//	pDC->Pie(100,100,400,400,250,400,250,100);

	pDC->SelectObject(pOldPen);
	pDC->SelectObject(pOldBrush);
}

void CDraw::OnButton1() 
{
	// TODO: Add your control notification handler code here
	CMainFrame *pMain=(CMainFrame *)AfxGetApp()->m_pMainWnd;
	pMain->SwitchToForm(IDD_FORMVIEW_Statistics);
}

void CDraw::OnButton2() 
{
	// TODO: Add your control notification handler code here
	CMenuAll dlg;
	dlg.DoModal();
}
