import React, { useEffect, useRef } from 'react';
import '../assets/css/App.css'; // Import component-specific styles

import animationData from '../assets/lotties/terms1-anim.json'
import Lottie from 'lottie-web';
function TermsAndConditions() {
  const container=useRef(null);
  useEffect(() => {
    const anim = Lottie.loadAnimation({
      container: container.current,
      renderer: 'svg',
      loop: true,
      autoplay: true,
      animationData: animationData,
    });


    return () => {
      anim.destroy();
    };
  }, []);
  useEffect(() => {
    const tabLists = document.querySelectorAll(".tabs_list ul li");
    const tabItems = document.querySelectorAll(".tab_item");

    tabLists.forEach((list) => {
      list.addEventListener("click", function () {
        const tabData = list.getAttribute("data-tc");

        tabLists.forEach((list) => {
          list.classList.remove("active");
        });
        list.classList.add("active");

        tabItems.forEach((item) => {
          const tabClass = item.getAttribute("class").split(" ");
          if (tabClass.includes(tabData)) {
            item.style.display = "block";
          } else {
            item.style.display = "none";
          }
        });
      });
    });
  }, []);

  return (
    <div className="terms-container">
    <div className="wrapper flex_align_justify">
    <div className='animation-container'>
        <div ref={container} className='animcon'></div>
      </div>
      <div className="tc_wrap">

        <div className="tabs_list">
          <ul>
            <li data-tc="tab_item_1" className="active">
              Terms of use
            </li>
            <li data-tc="tab_item_2">Intellectual property rights</li>
            <li data-tc="tab_item_3">Prohibited activities</li>
           
            <li data-tc="tab_item_4">Governing law</li>
          </ul>
        </div>
        <div className="tabs_content">
          <div className="tab_head">
            <h2>Terms & Conditions</h2>
          </div>
          <div className="tab_body">
            <div className="tab_item tab_item_1">
              <h3>Terms of use</h3>
              <p>
              By accessing and using our currency exchange platform, you agree to comply with the following terms and conditions. You must be at least 18 years old to use our services. We provide currency exchange services, and all transactions are subject to accurate and up-to-date information. Exchange rates may fluctuate, and ForexFlare is not responsible for any financial losses resulting from rate changes. Your privacy and data security are important to us; please review our Privacy Policy for details. Our platform is provided "as-is" without warranties, and ForexFlare is not liable for direct, indirect, or consequential damages. We reserve the right to suspend or terminate access to our platform. We may update these terms, and your continued use implies acceptance of any revisions. These terms are governed by local laws, with disputes subject to the jurisdiction of local courts. For questions or concerns, please contact ForexFlare.
              </p>
              {/* Other content for Terms of Use */}
            </div>
            <div className="tab_item tab_item_2" style={{ display: "none" }}>.
              <h3>Intellectual property rights</h3>
              <p>
              All content, trademarks, logos, and intellectual property displayed on our currency exchange platform are the exclusive property of ForexFlare. You may not use, reproduce, or distribute any of our intellectual property without our explicit consent. Unauthorized use of our intellectual property may result in legal action. We are committed to protecting our brand and ensuring the security of our platform and its users.
              </p>
              {/* Other content for Intellectual Property Rights */}
            </div>
            <div className="tab_item tab_item_3" style={{ display: "none" }}>.
              <h3>Prohibited Activities</h3>
              <p>
              On our currency exchange platform, engaging in any fraudulent, deceptive, or illegal activities, including but not limited to fraud, money laundering, unauthorized access, harassment, disruption, violation of laws, impersonation, or spam, is strictly prohibited. We maintain a zero-tolerance policy for such activities and will take appropriate actions against users found in violation, including account suspension or termination.              </p>
              {/* Other content for Intellectual Property Rights */}
            </div>
            <div className="tab_item tab_item_4" style={{ display: "none" }}>.
              <h3>Governing Laws</h3>
              <p>
              Our currency exchange platform facilitates transactions between individuals and entities from different countries. The legal framework governing these international transactions can be intricate and multifaceted. To address this complexity, we adhere to international trade and financial regulations. However, it's important to note that specific laws may vary depending on the countries involved and the nature of the transaction. We recommend that users familiarize themselves with the relevant laws and regulations in their respective jurisdictions. In the event of disputes or legal issues related to international transactions, we employ international arbitration or other dispute resolution mechanisms as stipulated in our Terms of Use."              {/* Other content for Intellectual Property Rights */}
            </p>
            </div>
            {/* Repeat for other tabs */}
          </div>
        
        </div>
      </div>
    </div>
    </div>
  );
}

export default TermsAndConditions;
